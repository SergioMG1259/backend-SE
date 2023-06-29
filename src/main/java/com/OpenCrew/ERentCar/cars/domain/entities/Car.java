package com.OpenCrew.ERentCar.cars.domain.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.OpenCrew.ERentCar.rents.domain.entities.Reservation;
import com.OpenCrew.ERentCar.scores.domain.entities.ScoreCar;
import com.OpenCrew.ERentCar.users.domain.entities.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="cars")
public class Car implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    private String plateNumber;

    @NotNull
    private Double mileage;

    @NotNull
    @NotBlank
    private String fuel;

    @NotNull
    @NotBlank
    private String gearBox;

    @NotNull
    private Double pricePerDay;

    @NotNull
    @NotBlank
    @Size(max = 200)
    private String description;

    @NotNull
    private String image;

    private Double score=0.0;

    @NotNull
    @NotBlank
    private String state="FREE";

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Location> locations;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> reservations;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ScoreCar> scoresCar;
}
