package spring.user;

import org.mapstruct.Mapper;
import spring.user.User;
import spring.user.UserDto;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto userToUserDto(User user);

    User dtoToUser(UserDto userDto);
}
