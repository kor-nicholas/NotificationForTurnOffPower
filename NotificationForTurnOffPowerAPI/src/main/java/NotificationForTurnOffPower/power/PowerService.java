package NotificationForTurnOffPower.power;

import NotificationForTurnOffPower.powerPlant.PowerPlant;
import NotificationForTurnOffPower.powerPlant.PowerPlantRepository;
import NotificationForTurnOffPower.user.User;
import NotificationForTurnOffPower.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PowerService {

    private final PowerPlantRepository powerPlantRepository;
    private final UserRepository userRepository;

    public PowerService(PowerPlantRepository powerPlantRepository, UserRepository userRepository) {
        this.powerPlantRepository = powerPlantRepository;
        this.userRepository = userRepository;
    }

    public List<Integer> getTelegramIdsToNotification() {
        List<PowerPlant> powerPlants = powerPlantRepository.findAll();
        Map<String, Integer> countOfPowersForCity = new HashMap<String, Integer>();
        List<Integer> telegramIds = new LinkedList<Integer>();
        List<User> users = new LinkedList<User>();

        for(PowerPlant powerPlant : powerPlants) {
            if(countOfPowersForCity.containsKey(powerPlant.getCity())) {
                countOfPowersForCity.put(powerPlant.getCity(), countOfPowersForCity.get(powerPlant.getCity()) + powerPlant.getCountofpower());
            } else {
                countOfPowersForCity.put(powerPlant.getCity(), powerPlant.getCountofpower());
            }
        }

        for(Map.Entry<String, Integer> countOfPower : countOfPowersForCity.entrySet()) {
            if(countOfPower.getValue() <= 800) {
                users = userRepository.findAllUsersByCity(countOfPower.getKey()).get();

                for(User user : users) {
                    telegramIds.add(user.getTelegramid());
                }
            }
        }

        return telegramIds;
    }
}
