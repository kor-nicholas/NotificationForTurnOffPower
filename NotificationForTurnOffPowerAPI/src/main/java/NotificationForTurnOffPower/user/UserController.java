package NotificationForTurnOffPower.user;

import NotificationForTurnOffPower.power.PowerService;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.websocket.server.PathParam;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(path = "getAll")
    public List<User> getAllUsers() {
        return  userService.getAllUsers();
    }

    @PostMapping(path = "add")
    public void addNewUser(@RequestBody User user) {
        userService.addNewUser(user);
    }

    @PutMapping(path = "change")
    public void changeUser(@RequestBody User user) {
        userService.changeUser(user);
    }

    @Transactional
    @DeleteMapping(path = "deleteByTelegramId/{telegramid}")
    public void deleteUser(@PathVariable Integer telegramid) { userService.deleteUserByTelegramId(telegramid); }
}
