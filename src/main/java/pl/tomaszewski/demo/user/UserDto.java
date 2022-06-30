package pl.tomaszewski.demo.user;

import pl.tomaszewski.demo.points.PointsDto;

import java.util.List;

public class UserDto {

    private String firstName;

    public String lastName;

    private String nick;

    private List<PointsDto> points;

    public UserDto(String firstName, String lastName, String nick, List<PointsDto> points) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nick = nick;
        this.points = points;
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

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public List<PointsDto> getPoints() {
        return points;
    }

    public void setPoints(List<PointsDto> points) {
        this.points = points;
    }
}
