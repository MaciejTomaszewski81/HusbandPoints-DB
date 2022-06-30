package pl.tomaszewski.demo.points;

import pl.tomaszewski.demo.engine.Tasks;

import java.time.LocalDate;

public class PointsDto {

    private int points;

    private LocalDate date;

    private Tasks tasks;

    public PointsDto(int points, LocalDate date, Tasks tasks) {
        this.points = points;
        this.date = date;
        this.tasks = tasks;
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
