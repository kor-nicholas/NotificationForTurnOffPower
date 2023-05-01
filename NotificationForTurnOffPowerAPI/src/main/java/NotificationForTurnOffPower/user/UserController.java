package NotificationForTurnOffPower.user;

import NotificationForTurnOffPower.power.PowerService;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping(path = "getByTelegramId/{telegramid}")
//    public User getUserForTelegramId(Integer telegramid) {
//        return userService.getUserByTelegramId(telegramid);
//    }

    @PostMapping(path = "add")
    public void addNewUser(@RequestBody User user) {
        userService.addNewUser(user);
    }

    @PutMapping(path = "change")
    public void changeUser(@RequestBody User user) {
        userService.changeUser(user);
    }

    @DeleteMapping(path = "delete/{id}")
    public void deleteUser(@PathVariable Integer id) { userService.deleteUser(id); }
}
