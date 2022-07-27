package pl.tomaszewski.demo.user;

import org.springframework.web.bind.annotation.*;
import pl.tomaszewski.demo.points.UpdatePointsDto;

import java.util.List;
import java.util.Map;

@RequestMapping("/home")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public List<UserDto> userList(){
        return userService.userList();
    }

    @GetMapping("/{nick}")
    public UserDto singleUser (@PathVariable String nick){
        return userService.singleUser(nick);
    }
    @PostMapping("")
    public User createUser(@RequestBody UserAddDto userAddDto ){
        return userService.userAdd(userAddDto);
    }

    @PatchMapping("/{nick}")
    public UserDto updateUser(@PathVariable String nick, @RequestBody Map<Object, Object> fields) {
        return userService.updateUser(nick, fields);
    }

    @DeleteMapping("/{nick}")
    public void deleteByNick(@PathVariable String nick){
        userService.deleteByNick(nick);
    }

    @PostMapping("/{nick}")
    public UserDto updatePoints(@PathVariable String nick, @RequestBody UpdatePointsDto updatePointsDto) {
        return userService.updatePoints(nick, updatePointsDto);
    }
}