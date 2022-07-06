package pl.tomaszewski.demo.points;

import org.springframework.stereotype.Service;
import pl.tomaszewski.demo.engine.Converter;

import java.util.List;

@Service
public class PointsService {

    PointsRepository pointsRepository;

    public PointsService(PointsRepository pointsRepository) {
        this.pointsRepository = pointsRepository;
    }

    public List<PointsDto> showAllPoints() {
        List<Points> points = pointsRepository.findAll();
        return Converter.convertPointsListToPointsDtoList(points);
    }
}
