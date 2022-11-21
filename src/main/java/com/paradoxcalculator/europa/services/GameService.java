package com.paradoxcalculator.europa.services;

import com.paradoxcalculator.europa.exceptions.CustomException;
import com.paradoxcalculator.europa.model.Game;
import com.paradoxcalculator.europa.pojo.request.GameCreationRequest;
import com.paradoxcalculator.europa.pojo.response.GameDetailedResponse;
import com.paradoxcalculator.europa.pojo.response.GameResponse;
import com.paradoxcalculator.europa.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class GameService {
    @Autowired
    protected GameRepository gameRepository;

    public Collection<Game> getGameList(){
        return gameRepository.findAll();
    }

    public Game getGameDetail(Integer id) throws CustomException {
        return gameRepository.findById(id).orElseThrow(()->new CustomException("Game not found", HttpStatus.NOT_FOUND.value()));
    }

    public Game createGame(GameCreationRequest body) {
        return gameRepository.save(new Game(body.getGame(), body.getEdition()));
    }
}
