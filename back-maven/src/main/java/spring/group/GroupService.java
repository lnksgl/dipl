package spring.group;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Service
@AllArgsConstructor
@Transactional(readOnly = true)
@CacheConfig(cacheNames = {"service"})
public class GroupService {

    GroupRepository groupRepository;
    GroupMapper groupMapper;

    @Transactional
    public void createGroup(GroupDto groupDto) {
        groupRepository.save(mapFromDtoToGroup(groupDto));
    }

    @Transactional
    public void updateGroup(GroupDto groupDto) {
        groupRepository.updateGroup(groupDto.getName(), groupDto.getContent(), groupDto.getId());
    }

    @Transactional
    public void updateAverage(double average, Long id) {
        groupRepository.updateGroup(String.valueOf(average), id);
    }

    @Cacheable
    public List<GroupDto> showAllGroups() {
        return groupRepository.findAll().stream().map(this::mapFromGroupToDto).collect(toList());
    }

    @Transactional
    public void deleteGroup(long id) {
        groupRepository.delete(groupRepository.findById(id).orElseThrow(() -> new GroupNotFoundException("For id " + id)));
    }

    @Cacheable
    public GroupDto readSingleGroup(Long id) {
        return mapFromGroupToDto(groupRepository.findById(id).orElseThrow(() -> new GroupNotFoundException("For id " + id)));
    }

    @Cacheable
    public List<GroupDto> showNameGroup(String name) {
        return groupsStream(groupRepository.findByName(name));
    }

    public List<GroupDto> groupsStream(List<Group> groups) {
        return groups.stream().map(this::mapFromGroupToDto).collect(toList());
    }

    public GroupDto mapFromGroupToDto(Group group) {
        return groupMapper.groupToGroupDto(group);
    }

    public Group mapFromDtoToGroup(GroupDto group) {
        return groupMapper.dtoToGroup(group);
    }
}
