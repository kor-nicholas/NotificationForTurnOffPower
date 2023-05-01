package NotificationForTurnOffPower.powerPlant;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "powerplant")
public class PowerPlantController {
    private final PowerPlantService powerPlantService;

    public PowerPlantController(PowerPlantService powerPlantService) {
        this.powerPlantService = powerPlantService;
    }

    @PutMapping(path = "changeCountOfPower")
    public void changeCountOfPower(@RequestBody PowerPlant powerPlant) {
        powerPlantService.changeCountOfPower(powerPlant);
    }
}
