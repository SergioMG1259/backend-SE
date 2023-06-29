package com.OpenCrew.ERentCar.rents.application.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RentClientDTO {
    private Long id;

    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private Date payDate;

    private String state;

    private Boolean stateScore;

    private ReservationClientDTO reservation;
}
