package com.OpenCrew.ERentCar.scores.domain.repository;

import java.util.List;
import java.util.Optional;

import com.OpenCrew.ERentCar.scores.domain.entities.ScoreCar;

public interface ScoreCarRepository {
    Optional<ScoreCar> findById(Long id);
    ScoreCar save(ScoreCar score);
    void deleteById(Long id);
    List<ScoreCar> findAllScoreCarByCarId(Long id);
    Double getNewScoreCar(Long carId);
}
