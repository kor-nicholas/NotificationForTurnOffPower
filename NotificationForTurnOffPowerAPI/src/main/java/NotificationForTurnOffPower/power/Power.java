package NotificationForTurnOffPower.power;

import jakarta.persistence.*;

@Entity
@Table(name = "power")
public class Power {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String city;
    private Integer countofpower;

    public Power() {
    }

    public Integer getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public Integer getCountofpower() {
        return countofpower;
    }
}
