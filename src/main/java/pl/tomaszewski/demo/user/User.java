package pl.tomaszewski.demo.user;
import pl.tomaszewski.demo.points.Points;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class User {

    @Id
    private UUID id;

    private String firstName;

    private String lastName;

    private String password;

    private String nick;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private List<Points>points;

    public List<Points> getPoints() {
        return points;
    }

    public void setPoints(List<Points> points) {
        this.points = points;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
}