package NotificationForTurnOffPower.powerPlant;

import NotificationForTurnOffPower.user.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PowerPlantService {
    private final PowerPlantRepository powerPlantRepository;

    public PowerPlantService(PowerPlantRepository powerPlantRepository) {
        this.powerPlantRepository = powerPlantRepository;
    }

    public void changeCountOfPower(PowerPlant powerPlant) {
        Optional<PowerPlant> powerPlantInBase = powerPlantRepository.findByName(powerPlant.getName());

        if(powerPlantInBase.isPresent()) {
            PowerPlant localPowerPlantFromBase = powerPlantInBase.get();

            if(localPowerPlantFromBase.getCountofpower() != null) {
                localPowerPlantFromBase.setCountofpower(powerPlant.getCountofpower());
            }

            powerPlantRepository.save(localPowerPlantFromBase);
        }
    }
}
