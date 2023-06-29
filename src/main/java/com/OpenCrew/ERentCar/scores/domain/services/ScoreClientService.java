package com.OpenCrew.ERentCar.scores.domain.services;

import java.util.List;

import com.OpenCrew.ERentCar.scores.application.requests.CreateScore;
import com.OpenCrew.ERentCar.scores.domain.entities.ScoreClient;

public interface ScoreClientService {
    ScoreClient getById(Long id);
    ScoreClient registerScoreClient(CreateScore createScore,Long clientId,Long ownerId);
    List<ScoreClient> getByClientId(Long clientId);
}
