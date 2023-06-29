package com.OpenCrew.ERentCar.scores.infraestructure;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.OpenCrew.ERentCar.scores.domain.entities.ScoreClient;
import com.OpenCrew.ERentCar.scores.domain.repository.ScoreClientRepository;

public interface ScoreClientRepositoryImpl extends JpaRepository<ScoreClient,Long>, ScoreClientRepository{
    @Query(value="select*from scores_client where client_id=?1", nativeQuery = true)
    List<ScoreClient> getScoresByClient(Long clientId);

    @Query(value="select avg(score) from scores_client where client_id=?1 group by client_id", nativeQuery = true)
    Double getNewScoreClient(Long clientId);
}
