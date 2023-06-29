package com.OpenCrew.ERentCar.rents.application.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RentOwnerDTO {
    private Long id;

    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private Date payDate;

    private String state;

    private ReservationOwnerDTO reservation;
}
