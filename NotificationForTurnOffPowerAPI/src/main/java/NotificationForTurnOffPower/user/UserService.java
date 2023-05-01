package NotificationForTurnOffPower.user;

import NotificationForTurnOffPower.power.PowerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PowerRepository powerRepository;

    public UserService(UserRepository userRepository, PowerRepository powerRepository) {
        this.userRepository = userRepository;
        this.powerRepository = powerRepository;
    }

//    public User getUserByTelegramId(Integer telegramid) {
//        Optional<User> userInBase = userRepository.findUserByTelegramid(telegramid);
//
//        if(userInBase.isPresent())
//            return userInBase.get();
//        else
//            return null;
//    }

    public void addNewUser(User user) {
        userRepository.save(user);
    }

    public void changeUser(User user) {
        Optional<User> userInBase = userRepository.findUserByTelegramid(user.getTelegramid());

        if(userInBase.isPresent()) {
            User localUserFromBase = userInBase.get();

            if(localUserFromBase.getName() != null) {
                localUserFromBase.setName(user.getName());
            }

            if(localUserFromBase.getSurname() != null) {
                localUserFromBase.setSurname(user.getSurname());
            }

            if(localUserFromBase.getTelegramid() != null) {
                localUserFromBase.setTelegramid(user.getTelegramid());
            }

            if(localUserFromBase.getDateofbirthday() != null) {
                localUserFromBase.setDateofbirthday(user.getDateofbirthday());
            }

            if(localUserFromBase.getAge() != null) {
                localUserFromBase.setAge(user.getAge());
            }

            if(localUserFromBase.getCity() != null) {
                localUserFromBase.setCity(user.getCity());
            }

            userRepository.save(localUserFromBase);
        }
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
