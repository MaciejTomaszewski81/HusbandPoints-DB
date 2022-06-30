package pl.tomaszewski.demo.points;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
public interface PointsRepository extends JpaRepository <Points, UUID> {
}
