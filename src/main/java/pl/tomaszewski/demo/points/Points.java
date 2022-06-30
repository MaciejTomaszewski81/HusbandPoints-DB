package pl.tomaszewski.demo.points;

import org.springframework.format.annotation.DateTimeFormat;
import pl.tomaszewski.demo.engine.Tasks;
import pl.tomaszewski.demo.user.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
public class Points {

    @Id
    private UUID id;

    private int points;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

   @Enumerated(EnumType.STRING)
    private Tasks tasks;

   @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
   private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Tasks getTasks() {
        return tasks;
    }

    public void setTasks(Tasks tasks) {
        this.tasks = tasks;
    }
}
