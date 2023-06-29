package com.OpenCrew.ERentCar.scores.domain.services;

import java.util.List;

import com.OpenCrew.ERentCar.scores.application.requests.CreateScore;
import com.OpenCrew.ERentCar.scores.domain.entities.ScoreOwner;

public interface ScoreOwnerService {
    ScoreOwner getById(Long id);
    ScoreOwner registerScoreOwner(CreateScore createScore,Long ownerId,Long clientId);
    List<ScoreOwner> getByOwnerId(Long ownerId);
}
