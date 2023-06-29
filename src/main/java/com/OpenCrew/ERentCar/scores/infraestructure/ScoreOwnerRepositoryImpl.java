package com.OpenCrew.ERentCar.scores.infraestructure;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.OpenCrew.ERentCar.scores.domain.entities.ScoreOwner;
import com.OpenCrew.ERentCar.scores.domain.repository.ScoreOwnerRepository;

public interface ScoreOwnerRepositoryImpl extends JpaRepository<ScoreOwner,Long>, ScoreOwnerRepository{
    @Query(value="select*from scores_owner where owner_id=?1", nativeQuery = true)
    List<ScoreOwner> getRatingsByOwner(Long ownerId);

    @Query(value="select avg(score) from scores_owner where owner_id=?1 group by owner_id", nativeQuery = true)
    Double getNewScoreOwner(Long ownerId);
}
