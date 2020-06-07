package spring.user;

import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-03-04T15:03:47+0300",
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
