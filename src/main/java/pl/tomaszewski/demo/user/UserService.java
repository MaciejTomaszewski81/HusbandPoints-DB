package pl.tomaszewski.demo.user;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.util.ReflectionUtils;
import org.springframework.stereotype.Service;
import pl.tomaszewski.demo.engine.Converter;
import pl.tomaszewski.demo.engine.Tasks;
import pl.tomaszewski.demo.points.Points;
import pl.tomaszewski.demo.points.UpdatePointsDto;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> userList() {
       List<User>user = userRepository.findAll();
        return Converter.convertListUsersToUsersDto(user);
    }

    public UserDto singleUser(String nick) {
        User user = userRepository.findByNick(nick);
        return Converter.convertUserToSingleUserDto(user);
    }

    public User userAdd(UserAddDto userAddDto) {
        UUID id = UUID.randomUUID();
        String firstName = userAddDto.getFirstName();
        String lastName = userAddDto.getLastName();
        String password = userAddDto.getPassword();
        String nick = userAddDto.getNick();
        List<Points> points = new ArrayList<>();
        User userAdd = new User(id,firstName,lastName,password,nick,points);
        return userRepository.save(userAdd);
    }

    public UserDto updateUser(String nick, Map<Object, Object> fields) {
        User user = userRepository.findByNick(nick);
        fields.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(User.class, (String) key);
            if (field == null) {
                throw new NullPointerException("Field " + key + " does not exist");
            } else {
                if (field.getName().equals("firstName") || field.getName().equals("lastName") || field.getName().equals("password") || field.getName().equals("nick")) {
                    field.setAccessible(true);
                    ReflectionUtils.setField(field, user, value);
                } else {
                    throw new NullPointerException("Field " + key + " cannot be updated");
                }
            }
        });
        userRepository.save(user);
        return Converter.convertUserToSingleUserDto(user);
    }

    public void deleteByNick(String nick) {
        try {
           User user = userRepository.findByNick(nick);
            UUID id = user.getId();
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            //ignore
        }
    }

    public UserDto updatePoints(String nick, UpdatePointsDto updatePointsDto) {
        User user = userRepository.findByNick(nick);
        List<Points> points = user.getPoints();
        UUID id = UUID.randomUUID();
        int point = updatePointsDto.getPoints();
        Tasks task= updatePointsDto.getTasks();
        LocalDate date = LocalDate.now();
        Points points1 = new Points(id,point,date,task,user);
        points.add(points1);
        userRepository.save(user);
        return Converter.convertUserToSingleUserDto(user);
    }
}