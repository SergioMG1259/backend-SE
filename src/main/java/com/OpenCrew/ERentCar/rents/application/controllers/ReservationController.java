package com.OpenCrew.ERentCar.rents.application.controllers;

import javax.validation.Valid;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OpenCrew.ERentCar.rents.application.dto.ReservationDTO;
import com.OpenCrew.ERentCar.rents.application.dto.ReservationOwnerDTO;
import com.OpenCrew.ERentCar.rents.application.dto.ReservationClientDTO;
import com.OpenCrew.ERentCar.rents.application.mapper.ReservationMapper;
import com.OpenCrew.ERentCar.rents.application.requests.CreateReservation;
import com.OpenCrew.ERentCar.rents.domain.services.ReservationService;

@RestController
@RequestMapping("/api/v1/reservations")
public class ReservationController {
    private final ReservationService reservationService;
    private final ReservationMapper mapper;
    public ReservationController(ReservationService reservationService, ReservationMapper mapper) {
        this.reservationService = reservationService;
        this.mapper = mapper;
    }
    @PostMapping("register/owner/{ownerId}/client/{clientId}/car/{carId}")
    public ResponseEntity<ReservationDTO> registerReservation(@PathVariable("ownerId")Long ownerId,
    @PathVariable("clientId")Long clientId,@PathVariable("carId")Long carId,@Valid @RequestBody CreateReservation request){
        ReservationDTO reservationDTO= mapper.toDTO(this.reservationService.registerReservation(request,ownerId,carId,clientId));
        return ResponseEntity.ok(reservationDTO);
    }

    @GetMapping("owner/{ownerId}")
    public List<ReservationOwnerDTO> getAllReservationsOwner(@PathVariable("ownerId")Long ownerId){
        return mapper.modelListToListOwnerDTO(reservationService.getByOwnerId(ownerId));
    }

    @GetMapping("client/{clientId}")
    public List<ReservationClientDTO> getAllReservationsClient(@PathVariable("clientId")Long clientId){
        return mapper.modelListToListClientDTO(reservationService.getByClientId(clientId));
    }

    @GetMapping("{reservationId}")
    public ReservationDTO getReservationsById(@PathVariable("reservationId")Long reservationId){
        return mapper.toDTO(reservationService.getById(reservationId));
    }

    @PutMapping("accept/reservation/{reservationId}")
    public ReservationDTO acceptReservation(@PathVariable("reservationId")Long reservationId){
        return mapper.toDTO(reservationService.acceptReservation(reservationId));
    }

    @PutMapping("decline/reservation/{reservationId}")
    public ReservationDTO declineReservation(@PathVariable("reservationId")Long reservationId){
        return mapper.toDTO(reservationService.acceptReservation(reservationId));
    }
}
