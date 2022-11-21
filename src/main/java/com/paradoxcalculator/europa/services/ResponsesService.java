package com.paradoxcalculator.europa.services;

import com.paradoxcalculator.europa.model.Game;
import com.paradoxcalculator.europa.pojo.response.GameDetailedResponse;
import com.paradoxcalculator.europa.pojo.response.GameResponse;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class ResponsesService {

    public Collection<GameResponse> getGameListResponse(Collection<Game> games){
        return games.stream().map(game->gameListResponse(game)).collect(Collectors.toList());
    }
    public GameResponse gameListResponse(Game game) {
        return new GameResponse(game.getName(), game.getEdition());
    }

    public GameDetailedResponse getGameDetailed(Game game){
        return new GameDetailedResponse(game.getName(), game.getEdition());
    }
}
