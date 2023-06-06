package NotificationForTurnOffPower.user;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByTelegramId(Integer telegramid) {
        Optional<User> userInBase = userRepository.findUserByTelegramid(telegramid);

        if(userInBase.isPresent())
            return userInBase.get();
        else
            return null;
    }

    public User getUserById(Integer id) {
        Optional<User> userInBase = userRepository.findById(id);

        if(userInBase.isPresent())
            return userInBase.get();
        else
            return null;
    }

    public User addNewUser(User user) {
        user.setAge(Period.between(user.getDateofbirthday(), LocalDate.now()).getYears());
        userRepository.save(user);
        return userRepository.findUserByLogin(user.getLogin()).get();
    }

    // curl -X PUT -H "Content-Type: application/json" -d "{\"telegramid\": 779209332, \"age\": 24}" http://localhost:8080/users/change
    public void changeUserByTelegramId(User user) {
        Optional<User> userInBase = userRepository.findUserByTelegramid(user.getTelegramid());

        if(userInBase.isPresent()) {
            User localUserFromBase = userInBase.get();

            if(localUserFromBase.getName() != null && user.getName() != null) {
                localUserFromBase.setName(user.getName());
            }

            if(localUserFromBase.getSurname() != null && user.getSurname() != null) {
                localUserFromBase.setSurname(user.getSurname());
            }

            if(localUserFromBase.getTelegramid() != null && user.getTelegramid() != null) {
                localUserFromBase.setTelegramid(user.getTelegramid());
            }

            if(localUserFromBase.getDateofbirthday() != null && user.getDateofbirthday() != null) {
                localUserFromBase.setDateofbirthday(user.getDateofbirthday());
            }

            if(localUserFromBase.getAge() != null) {
                localUserFromBase.setAge(Period.between(localUserFromBase.getDateofbirthday(), LocalDate.now()).getYears());
            }

            if(localUserFromBase.getCity() != null && user.getCity() != null) {
                localUserFromBase.setCity(user.getCity());
            }

            userRepository.save(localUserFromBase);
        }
    }

    public void changeUserById(User user) {
        Optional<User> userInBase = userRepository.findById(user.getId());

        if(userInBase.isPresent()) {
            User localUserFromBase = userInBase.get();

            if(localUserFromBase.getName() != null && user.getName() != null) {
                localUserFromBase.setName(user.getName());
            }

            if(localUserFromBase.getSurname() != null && user.getSurname() != null) {
                localUserFromBase.setSurname(user.getSurname());
            }

            if(localUserFromBase.getTelegramid() != null && user.getTelegramid() != null) {
                localUserFromBase.setTelegramid(user.getTelegramid());
            }

            if(localUserFromBase.getDateofbirthday() != null && user.getDateofbirthday() != null) {
                localUserFromBase.setDateofbirthday(user.getDateofbirthday());
            }

            if(localUserFromBase.getAge() != null) {
                localUserFromBase.setAge(Period.between(localUserFromBase.getDateofbirthday(), LocalDate.now()).getYears());
            }

            if(localUserFromBase.getCity() != null && user.getCity() != null) {
                localUserFromBase.setCity(user.getCity());
            }

            userRepository.save(localUserFromBase);
        }
    }

    public void changeTelegramIdById(Integer id, Integer telegramid) {
        Optional<User> userInBase = userRepository.findById(id);

        if(userInBase.isPresent()) {
            User localUserFromBase = userInBase.get();

            localUserFromBase.setTelegramid(telegramid);

            userRepository.save(localUserFromBase);
        }
    }

    public void deleteUserByTelegramId(Integer telegramid) {
        userRepository.deleteUserByTelegramid(telegramid);
    }

    public void deleteUserById(Integer id) { userRepository.deleteById(id); }

    public User login(String login, String pass) {
        Optional<User> userInBase = userRepository.findUserByLogin(login);

        if(userInBase.isPresent()) {
            User localUser = userInBase.get();
            if(localUser.getPass().equals(pass))
                return localUser;
            else
                return null;
        }
        else {
            return null;
        }
    }
}
