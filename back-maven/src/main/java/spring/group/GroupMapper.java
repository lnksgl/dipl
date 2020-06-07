package spring.group;

import org.mapstruct.Mapper;
import spring.group.Group;
import spring.group.GroupDto;

@Mapper(componentModel = "spring")
public interface GroupMapper  {

    GroupDto groupToGroupDto(Group group);

    Group dtoToGroup(GroupDto groupDto);
}
