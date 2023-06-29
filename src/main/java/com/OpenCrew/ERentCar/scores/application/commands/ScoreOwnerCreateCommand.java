package com.OpenCrew.ERentCar.scores.application.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScoreOwnerCreateCommand {
    private String comment;
    private Double score;
}
