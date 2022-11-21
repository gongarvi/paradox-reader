package com.paradoxcalculator.europa.model;

import com.paradoxcalculator.europa.model.ids.GameSessionId;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class GameSession extends DateTimeModel{
    @EmbeddedId
    private GameSessionId id;
}
