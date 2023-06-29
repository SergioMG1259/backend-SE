package com.OpenCrew.ERentCar.scores.application.mapper;

import org.springframework.beans.factory.annotation.Autowired;

import com.OpenCrew.ERentCar.scores.application.dto.ScoreDTO;
import com.OpenCrew.ERentCar.scores.domain.entities.ScoreCar;
import com.OpenCrew.ERentCar.scores.domain.entities.ScoreClient;
import com.OpenCrew.ERentCar.scores.domain.entities.ScoreOwner;
import com.OpenCrew.ERentCar.shared.mapping.EnhancedModelMapper;

public class ScoreMapper {
    @Autowired
    EnhancedModelMapper mapper;

    public ScoreDTO toDTO(ScoreOwner model){
        return mapper.map(model, ScoreDTO.class);
    }
    public ScoreDTO toDTO(ScoreClient model){
        return mapper.map(model, ScoreDTO.class);
    }
    public ScoreDTO toDTO(ScoreCar model){
        return mapper.map(model, ScoreDTO.class);
    }
}
