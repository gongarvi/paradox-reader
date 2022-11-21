package com.paradoxcalculator.europa.pojo.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
public class GameCreationRequest {
    @NonNull
    private String game;
    @NonNull
    private String edition;
}
