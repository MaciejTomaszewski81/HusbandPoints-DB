package pl.tomaszewski.demo.user;

import org.springframework.web.bind.annotation.*;

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
//    @PutMapping("/{nick}")
//    public UserDto updateUser(@RequestBody UserAddDto userAddDto, @PathVariable String nick){
//        return userService.updateUser(userAddDto,nick);
//    }
    @DeleteMapping("/{nick}")
    public void deleteByNick(@PathVariable String nick){
        userService.deleteByNick(nick);
    }
}