package pl.tomaszewski.demo.points;

import pl.tomaszewski.demo.engine.Tasks;

import java.time.LocalDate;

public class UpdatePointsDto {

    private int points;

    private Tasks tasks;

    public UpdatePointsDto(int points, Tasks tasks) {
        this.points = points;
        this.tasks = tasks;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Tasks getTasks() {
        return tasks;
    }

    public void setTasks(Tasks tasks) {
        this.tasks = tasks;
    }
}