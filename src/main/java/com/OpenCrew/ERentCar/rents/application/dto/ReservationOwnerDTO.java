package com.OpenCrew.ERentCar.rents.application.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.OpenCrew.ERentCar.cars.application.dto.CarDTO;
import com.OpenCrew.ERentCar.users.application.dto.UserShortDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationOwnerDTO {
    private Long id;

    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private Date reserveDate;

    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private Date returnDate;

    private Double amount;

    private String state;

    private String location;

    private UserShortDTO client;

    private CarDTO car;
}
