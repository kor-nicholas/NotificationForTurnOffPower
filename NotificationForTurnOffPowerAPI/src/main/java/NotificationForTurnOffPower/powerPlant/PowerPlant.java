package NotificationForTurnOffPower.powerPlant;

import jakarta.persistence.*;

@Entity
@Table(name = "powerplant")
public class PowerPlant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String city;

    private Integer countofpower;

    public PowerPlant() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public Integer getCountofpower() {
        return countofpower;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountofpower(Integer countofpower) {
        this.countofpower = countofpower;
    }
}
