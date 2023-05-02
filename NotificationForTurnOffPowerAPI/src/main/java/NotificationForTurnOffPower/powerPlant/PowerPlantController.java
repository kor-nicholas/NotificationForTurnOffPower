package NotificationForTurnOffPower.powerPlant;

import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(path = "getAll")
    public List<PowerPlant> getAllPowerPlants() {
        return powerPlantService.getAllPowerPlants();
    }
}
