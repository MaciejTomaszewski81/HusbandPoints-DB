package pl.tomaszewski.demo.points;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/points")
@RestController
public class PointsController {

    PointsService pointsService;

    public PointsController(PointsService pointsService) {
        this.pointsService = pointsService;
    }

    @GetMapping("")
    public List<PointsDto> showPoints(){
        return pointsService.showAllPoints();
    }
}