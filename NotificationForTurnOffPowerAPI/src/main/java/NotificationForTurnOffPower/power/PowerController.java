package NotificationForTurnOffPower.power;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("power")
public class PowerController {
    private final PowerService powerService;

    public PowerController(PowerService powerService) {
        this.powerService = powerService;
    }

    @GetMapping(path = "getTelegramIdsToNotification")
    public List<Integer> getTelegramIdsToNotification() {
        return powerService.getTelegramIdsToNotification();
    }
}
