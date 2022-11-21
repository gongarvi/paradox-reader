package com.paradoxcalculator.europa.model.ids;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class GameSessionId  implements Serializable {
    private Integer gameId;
    private Integer session;
    private String countryTag;
}
