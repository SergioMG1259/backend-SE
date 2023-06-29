package com.OpenCrew.ERentCar.scores.domain.repository;

import java.util.List;
import java.util.Optional;

import com.OpenCrew.ERentCar.scores.domain.entities.ScoreOwner;

public interface ScoreOwnerRepository {
    Optional<ScoreOwner> findById(Long id);
    ScoreOwner save(ScoreOwner score);
    void deleteById(Long id);
    List<ScoreOwner> findAllScoreOwnerByOwnerId(Long id);
    Double getNewScoreOwner(Long ownerId);
}
