package com.OpenCrew.ERentCar.cars.application.commands;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.OpenCrew.ERentCar.cars.application.dto.LocationDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarCreateCommand {
    @NotNull
    @NotBlank
    private String brand;

    @NotNull
    @NotBlank
    private String model;

    @NotNull
    @NotBlank
    private String type;

    @NotNull
    private int seats;

    @NotNull
    private int year;

    @NotNull
    @NotBlank
    private String fuel;

    @NotNull
    @NotBlank
    private String gearBox;

    @NotNull
    @NotBlank
    private String plateNumber;

    @NotNull
    @NotBlank
    @Size(max = 200)
    private String description;

    @NotNull
    private Double mileage;

    @NotNull
    private Double pricePerDay;

    @NotNull
    private String image;

    private List<LocationDTO> locations;
}
