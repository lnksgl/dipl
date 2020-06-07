package spring.mapper;

import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import spring.user.User;
import spring.user.UserAverageDto;
import spring.user.UserAverageMapper;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-03-04T14:19:08+0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 13.0.2 (Oracle Corporation)"
)
@Component
public class UserAverageMapperImpl implements UserAverageMapper {

    @Override
    public UserAverageDto userToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserAverageDto userAverageDto = new UserAverageDto();

        userAverageDto.setId( user.getId() );
        userAverageDto.setUsername( user.getUsername() );
        userAverageDto.setEmail( user.getEmail() );

        return userAverageDto;
    }

    @Override
    public User dtoToUser(UserAverageDto userAverageDto) {
        if ( userAverageDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( userAverageDto.getId() );
        user.setUsername( userAverageDto.getUsername() );
        user.setEmail( userAverageDto.getEmail() );

        return user;
    }
}
