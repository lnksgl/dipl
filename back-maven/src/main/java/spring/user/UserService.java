package spring.user;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.enquiry.EnquiryMathOperations;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Service
@Transactional(readOnly = true)
@CacheConfig(cacheNames = {"service"})
public class UserService {

    UserRepository userRepository;
    UserMapper userMapper;
    UserAverageMapper userAverageMapper;
    EnquiryMathOperations enquiryMathOperations;

    @Transactional
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Cacheable
    public List<UserAverageDto> showAllUsers() {
        return (userRepository.findAll().stream().map(this::mapFromUserToAverageDto).collect(toList()));
    }

    @Transactional
    public void updateUser(UserAverageDto userAverageDto) {
        userRepository.updateUser(avg(userAverageDto.getAverage()), userAverageDto.getId());
    }

    public String avg(String evaluations) {
        return String.valueOf(
                enquiryMathOperations.average(evaluations.replaceAll("[^\\d.]", "").split("")));
    }

    @Transactional
    public void deleteUser(long id) {
        userRepository.delete(userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("For id " + id)));
    }

    @Cacheable
    public User readSingleUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("For id " + id));
    }

    @Cacheable
    public UserAverageDto readCurrentUser(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException("For id " + username));
        return mapFromUserToAverageDto(user);
    }

    public boolean checkUsername(String username, String email) {
        return showUsername(username).isEmpty() && showEmail(email).isEmpty();
    }

    @Cacheable
    public List<UserDto> showUsername(String username) {
        return usersStream(userRepository.findByUsername(username).stream().collect(Collectors.toList()));
    }

    @Cacheable
    public List<User> showEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<UserDto> usersStream(List<User> users) {
        return users.stream().map(this::mapFromUserToDto).collect(toList());
    }

    public UserDto mapFromUserToDto(User user) {
        return userMapper.userToUserDto(user);
    }

    public User mapFromDtoToUser(UserDto user) {
        return userMapper.dtoToUser(user);
    }

    public UserAverageDto mapFromUserToAverageDto(User user) {
        return userAverageMapper.userToUserDto(user);
    }
}
