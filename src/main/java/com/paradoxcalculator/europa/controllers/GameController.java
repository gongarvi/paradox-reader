package com.paradoxcalculator.europa.controllers;

import com.paradoxcalculator.europa.exceptions.CustomException;
import com.paradoxcalculator.europa.pojo.APIResponse;
import com.paradoxcalculator.europa.pojo.request.GameCreationRequest;
import com.paradoxcalculator.europa.services.GameService;
import com.paradoxcalculator.europa.services.ResponsesService;
import com.paradoxcalculator.europa.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/game")
public class GameController {

    private final GameService gameService;
    private final ResponsesService responsesService;

    private final SessionService sessionService;


    @Autowired
    public GameController(GameService gameService, ResponsesService responsesService, SessionService sessionService) {
        this.gameService = gameService;
        this.responsesService = responsesService;
        this.sessionService = sessionService;
    }

    @GetMapping("/")
    public APIResponse<?> getGameList(){
        return new APIResponse<>(responsesService.getGameListResponse(gameService.getGameList()), "Game list returned");
    }

    @GetMapping("/{id}")
    public APIResponse<?> getGameList(@PathVariable int id) throws CustomException {
        return new APIResponse<>(responsesService.getGameDetailed(gameService.getGameDetail(id)), "Game found");
    }

    @PostMapping("")
    public APIResponse<?> createGame(@Validated @RequestBody GameCreationRequest body) {
        return new APIResponse<>(gameService.createGame(body), "Game stored");
    }

    @PostMapping("/{id}/session")
    public APIResponse<?> createNewSession(
            @PathVariable int id,
            @RequestPart MultipartFile file) throws CustomException {
        return new APIResponse<>(sessionService.createGameSession(id, file));
    }
}
