package com.OpenCrew.ERentCar.scores.infraestructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.OpenCrew.ERentCar.scores.domain.entities.ScoreCar;
import com.OpenCrew.ERentCar.scores.domain.repository.ScoreCarRepository;

public interface ScoreCarRepositoryImpl extends JpaRepository<ScoreCar,Long>, ScoreCarRepository{
    @Query(value="select avg(score) from scores_car where car_id=?1 group by car_id", nativeQuery = true)
    Double getNewScoreCar(Long carId);
}
