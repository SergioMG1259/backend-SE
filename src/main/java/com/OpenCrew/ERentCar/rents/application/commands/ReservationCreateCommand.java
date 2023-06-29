package com.OpenCrew.ERentCar.rents.application.commands;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationCreateCommand {
    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private Date reserveDate;

    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private Date returnDate;

    @NotNull
    @NotBlank
    private Double amount;

    @NotNull
    @NotBlank
    private String location;
}
