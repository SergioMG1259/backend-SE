package com.OpenCrew.ERentCar.scores.domain.services;

import java.util.List;

import com.OpenCrew.ERentCar.scores.application.requests.CreateScore;
import com.OpenCrew.ERentCar.scores.domain.entities.ScoreCar;

public interface ScoreCarService {
    ScoreCar getById(Long id);
    ScoreCar registerScoreCar(CreateScore createCar,Long carId,Long clientIds,Long rentId);
    List<ScoreCar> getByCarId(Long carId);
}
