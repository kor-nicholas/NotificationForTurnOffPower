package NotificationForTurnOffPower.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findUserByTelegramid(Integer telegramid);
    Optional<List<User>> findAllUsersByCity(String city);
    void deleteUserByTelegramid(Integer telegramid);

    Optional<User> findUserByLogin(String login);
}
