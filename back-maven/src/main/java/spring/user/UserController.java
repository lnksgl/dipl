package spring.user;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.group.GroupDto;

import java.util.List;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    UserService userService;

    @GetMapping
    public ResponseEntity<List<UserAverageDto>> showAllUsers() {
        return new ResponseEntity<>(userService.showAllUsers(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<GroupDto> getSingleUser(@PathVariable Long id) {
        return new ResponseEntity(userService.mapFromUserToDto(userService.readSingleUser(id)), HttpStatus.OK);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<List<GroupDto>> getUsername(@PathVariable String username) {
        return new ResponseEntity(userService.showUsername(username), HttpStatus.OK);
    }

    @GetMapping("/current-username/{username}")
    public ResponseEntity<UserAverageDto> getCurrentUser(@PathVariable String username) {
        return new ResponseEntity(userService.readCurrentUser(username), HttpStatus.OK);
    }

    @PutMapping
    public void updateUser(@RequestBody UserAverageDto userAverageDto)  {
        userService.updateUser(userAverageDto);
    }
}
