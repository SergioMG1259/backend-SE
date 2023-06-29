package com.OpenCrew.ERentCar.scores.application.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.OpenCrew.ERentCar.scores.application.dto.ScoreDTO;
import com.OpenCrew.ERentCar.scores.application.mapper.ScoreMapper;
import com.OpenCrew.ERentCar.scores.application.requests.CreateScore;
import com.OpenCrew.ERentCar.scores.domain.services.ScoreCarService;
import com.OpenCrew.ERentCar.scores.domain.services.ScoreClientService;
import com.OpenCrew.ERentCar.scores.domain.services.ScoreOwnerService;

@RestController
@RequestMapping("/api/v1/scores")
public class ScoreController {
    private final ScoreOwnerService scoreOwnerService;
    private final ScoreClientService scoreClientService;
    private final ScoreCarService scoreCarService;
    private final ScoreMapper mapper;
    public ScoreController(ScoreOwnerService scoreOwnerService,ScoreCarService scoreCarService,ScoreClientService scoreClientService,ScoreMapper mapper) {
        this.scoreOwnerService = scoreOwnerService;
        this.scoreClientService=scoreClientService;
        this.scoreCarService=scoreCarService;
        this.mapper = mapper;
    }

    @PostMapping("scoreOwner/owner/{ownerId}/client/{clientId}")
    public ResponseEntity<ScoreDTO> registerScoreOwner(@PathVariable("ownerId")Long ownerId,
    @PathVariable("clientId")Long clientId,@RequestBody CreateScore createScore){
        ScoreDTO scoreDTO= mapper.toDTO(this.scoreOwnerService.registerScoreOwner(createScore,ownerId,clientId));
        return ResponseEntity.ok(scoreDTO);
    }

    @PostMapping("scoreClient/client/{clientId}/owner/{ownerId}")
    public ResponseEntity<ScoreDTO> registerScoreClient(@PathVariable("ownerId")Long ownerId,
    @PathVariable("clientId")Long clientId,@RequestBody CreateScore createScore){
        ScoreDTO scoreDTO= mapper.toDTO(this.scoreClientService.registerScoreClient(createScore,clientId,ownerId));
        return ResponseEntity.ok(scoreDTO);
    }

    @PostMapping("scoreCar/car/{carId}/client/{clientId}/rent/{rentId}")
    public ResponseEntity<ScoreDTO> registerScoreCar(@PathVariable("clientId")Long clientId,
    @PathVariable("carId")Long carId,@PathVariable("rentId")Long rentId,@RequestBody CreateScore createScore){
        ScoreDTO scoreDTO= mapper.toDTO(this.scoreCarService.registerScoreCar(createScore,carId,clientId,rentId));
        return ResponseEntity.ok(scoreDTO);
    }
}
