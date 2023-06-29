package com.OpenCrew.ERentCar.rents.application.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OpenCrew.ERentCar.rents.application.dto.RentClientDTO;
import com.OpenCrew.ERentCar.rents.application.dto.RentOwnerDTO;
import com.OpenCrew.ERentCar.rents.application.mapper.RentMapper;
import com.OpenCrew.ERentCar.rents.domain.services.RentService;

@RestController
@RequestMapping("/api/v1/rents")
public class RentController {
    private final RentService rentService;
    private final RentMapper mapper;
    public RentController(RentService rentService, RentMapper mapper) {
        this.rentService = rentService;
        this.mapper = mapper;
    }
    @PostMapping("register/reservation/{reservationId}")
    public ResponseEntity<RentClientDTO> registerRent(@PathVariable("reservationId")Long reservationId){
        RentClientDTO rentClientDTO= mapper.toClientDTO(this.rentService.registerRent(reservationId));
        return ResponseEntity.ok(rentClientDTO);
    }

    @GetMapping("owner/{ownerId}")
    public List<RentOwnerDTO> getAllRentsOwner(@PathVariable("ownerId")Long ownerId){
        return mapper.modelListToListOwnerDTO(rentService.getByOwnerId(ownerId));
    }

    @GetMapping("client/{clientId}")
    public List<RentClientDTO> getAllRentsClient(@PathVariable("clientId")Long clientId){
        return mapper.modelListToListClientDTO(rentService.getByClientId(clientId));
    }

    @PutMapping("endRent/rent/{rentId}")
    public RentClientDTO endRent(@PathVariable("rentId")Long rentId){
        return mapper.toClientDTO(rentService.endRent(rentId));
    }
}
