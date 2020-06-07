package spring.mapper;

import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import spring.user.User;
import spring.user.UserDto;
import spring.user.UserMapper;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-03-04T14:19:08+0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 13.0.2 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto userToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( user.getId() );
        userDto.setUsername( user.getUsername() );
        userDto.setEmail( user.getEmail() );

        return userDto;
    }

    @Override
    public User dtoToUser(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDto.getId() );
        user.setUsername( userDto.getUsername() );
        user.setEmail( userDto.getEmail() );

        return user;
    }
}
