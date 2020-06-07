package spring.group;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@RestController
@RequestMapping("/api/v1/group")
public class GroupController {

    GroupService groupService;

    @PostMapping
    public ResponseEntity createGroup(@RequestBody GroupDto groupDto) {
        groupService.createGroup(groupDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<List<GroupDto>> updateGroup(@RequestBody GroupDto groupDto) {
        groupService.updateGroup(groupDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/name/{name}")
    public ResponseEntity<List<GroupDto>> getUsernameGroups(@PathVariable String name) {
        return new ResponseEntity<>(groupService.showNameGroup(name), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<GroupDto>> showAllGroups() {
        return new ResponseEntity<>(groupService.showAllGroups(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteGroup(@PathVariable Long id) {
        groupService.deleteGroup(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<GroupDto> getSingleGroup(@PathVariable Long id) {
        return new ResponseEntity(groupService.readSingleGroup(id), HttpStatus.OK);
    }
}
