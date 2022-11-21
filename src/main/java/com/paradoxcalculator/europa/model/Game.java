package com.paradoxcalculator.europa.model;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Game extends DateTimeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NonNull
    private String name;
    @NonNull
    private String edition;


    @OneToMany(mappedBy = "game_session", fetch = FetchType.LAZY)
    private Collection<GameSession> sessions;
}
