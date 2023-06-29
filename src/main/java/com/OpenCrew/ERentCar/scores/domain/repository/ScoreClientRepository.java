package com.OpenCrew.ERentCar.scores.domain.repository;

import java.util.List;
import java.util.Optional;

import com.OpenCrew.ERentCar.scores.domain.entities.ScoreClient;

public interface ScoreClientRepository {
    Optional<ScoreClient> findById(Long id);
    ScoreClient save(ScoreClient score);
    void deleteById(Long id);
    List<ScoreClient> findAllScoreClientByOwnerId(Long id);
    Double getNewScoreClient(Long clientId);
}
