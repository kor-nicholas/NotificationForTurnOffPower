package NotificationForTurnOffPower.powerPlant;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PowerPlantRepository extends JpaRepository<PowerPlant, Integer> {
    Optional<PowerPlant> findByName(String name);
}
