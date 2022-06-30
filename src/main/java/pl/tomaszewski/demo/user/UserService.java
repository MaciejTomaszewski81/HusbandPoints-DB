package pl.tomaszewski.demo.user;

import org.springframework.stereotype.Service;
import pl.tomaszewski.demo.engine.Converter;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> userList() {
       List<User>user = userRepository.findAll();
        return Converter.ConvertUserToUserDto(user);
    }
}
