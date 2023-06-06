package NotificationForTurnOffPower.user;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname;
    private Integer telegramid;
    private LocalDate dateofbirthday;
    private Integer age;
    private String city;
    private String login;
    private String pass;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getTelegramid() {
        return telegramid;
    }

    public LocalDate getDateofbirthday() {
        return dateofbirthday;
    }

    public Integer getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }
    public String getLogin() { return login; }
    public String getPass() { return pass; }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setTelegramid(Integer telegramid) {
        this.telegramid = telegramid;
    }

    public void setDateofbirthday(LocalDate dateofbirthday) {
        this.dateofbirthday = dateofbirthday;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public void setLogin(String login) { this.login = login; }
    public void setPass(String pass) { this.pass = pass; }
}
