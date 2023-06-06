package NotificationForTurnOffPower.user;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@CrossOrigin(
//        origins = "*",
////        origins = "http://localhost:4200",
//        allowedHeaders = "*",
//        exposedHeaders = "*"
//)
@RestController
@RequestMapping(path = "users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "getByTelegramId/{telegramid}")
    public User getUserForTelegramId(@PathVariable Integer telegramid) {
        return userService.getUserByTelegramId(telegramid);
    }

    @GetMapping(path = "getById/{id}")
    public User getUserForId(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

//    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "login/{login}/{pass}")
    public User login(@PathVariable String login, @PathVariable String pass) {
        return userService.login(login, pass);
    }

    @GetMapping(path = "getAll")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

//    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(path = "add")
    public User addNewUser(@RequestBody User user) {
        return userService.addNewUser(user);
    }

//    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping(path = "changeUserByTelegramId")
    public void changeUserByTelegramId(@RequestBody User user) {
        userService.changeUserByTelegramId(user);
    }

    @PutMapping(path = "changeUserById")
    public void changeUserById(@RequestBody User user) { userService.changeUserById(user); }

//    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping(path = "changeTelegramIdById/{id}/{telegramid}")
    public void changeTelegramIdById(@PathVariable Integer id, @PathVariable Integer telegramid) { userService.changeTelegramIdById(id, telegramid); }

    @Transactional
    @DeleteMapping(path = "deleteByTelegramId/{telegramid}")
    public void deleteUser(@PathVariable Integer telegramid) { userService.deleteUserByTelegramId(telegramid); }

//    @CrossOrigin(origins = "http://localhost:4200")
    @Transactional
    @DeleteMapping(path = "deleteById/{id}")
    public void deleteUserForId(@PathVariable Integer id) { userService.deleteUserById(id); }
}
