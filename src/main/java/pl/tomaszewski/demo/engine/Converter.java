package pl.tomaszewski.demo.engine;

import pl.tomaszewski.demo.points.Points;
import pl.tomaszewski.demo.points.PointsDto;
import pl.tomaszewski.demo.user.User;
import pl.tomaszewski.demo.user.UserDto;

import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Converter {

    public static List<UserDto> ConvertUserToUserDto(List<User> user){
        List<UserDto> userDtos = new ArrayList<>();
        for (User user1 : user){
            String firstName = user1.getFirstName();
            String lastName = user1.getLastName();
            String nick = user1.getNick();
            List<Points> score = user1.getPoints();
            List<PointsDto> score1 = ConvertPointsToPointsDto(score);
            UserDto userDto = new UserDto(firstName, lastName, nick, score1);
            userDtos.add(userDto);
        }
        return userDtos;
    }

    public static List<PointsDto> ConvertPointsToPointsDto(List<Points> points){
        List<PointsDto> pointsDto = new ArrayList<>();
        for (Points points1 : points){
            int score = points1.getPoints();
            Tasks task = points1.getTasks();
            LocalDate date = points1.getDate();
            PointsDto pointsDto1 = new PointsDto(score, date, task);
            pointsDto.add(pointsDto1);
        }
        return pointsDto;
    }

//    public static List<PointsDto> ConvertPointsToPointsDto(User user){
//        List<PointsDto> pointsDto = new ArrayList<>();
//        for (Points points1 : user.getPoints()){
//            int score = points1.getPoints();
//            Tasks task = points1.getTasks();
//            LocalDate date = points1.getDate();
//            PointsDto pointsDto1 = new PointsDto(score, date, task);
//            pointsDto.add(pointsDto1);
//        }
//        return pointsDto;
//    }

}
