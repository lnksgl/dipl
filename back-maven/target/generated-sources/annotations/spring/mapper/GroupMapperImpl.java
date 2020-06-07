package spring.mapper;

import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import spring.group.Group;
import spring.group.GroupDto;
import spring.group.GroupMapper;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-03-04T14:19:08+0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 13.0.2 (Oracle Corporation)"
)
@Component
public class GroupMapperImpl implements GroupMapper {

    @Override
    public GroupDto groupToGroupDto(Group group) {
        if ( group == null ) {
            return null;
        }

        GroupDto groupDto = new GroupDto();

        groupDto.setId( group.getId() );
        groupDto.setName( group.getName() );
        groupDto.setContent( group.getContent() );
        groupDto.setAverage( group.getAverage() );

        return groupDto;
    }

    @Override
    public Group dtoToGroup(GroupDto groupDto) {
        if ( groupDto == null ) {
            return null;
        }

        Group group = new Group();

        group.setId( groupDto.getId() );
        group.setName( groupDto.getName() );
        group.setContent( groupDto.getContent() );
        group.setAverage( groupDto.getAverage() );

        return group;
    }
}
