package spring.user;

import org.mapstruct.Mapper;
import spring.user.User;
import spring.user.UserAverageDto;

@Mapper(componentModel = "spring")
public interface UserAverageMapper {

    UserAverageDto userToUserDto(User user);

    User dtoToUser(UserAverageDto userAverageDto);
}
