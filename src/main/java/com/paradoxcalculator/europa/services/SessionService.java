package com.paradoxcalculator.europa.services;

import com.paradoxcalculator.europa.exceptions.CustomException;
import com.paradoxcalculator.europa.pojo.request.GameSessionCreationRequest;
import com.paradoxcalculator.europa.repositories.GameRepository;
import com.paradoxcalculator.europa.repositories.GameSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class SessionService {
    @Autowired
    protected GameSessionRepository gameSessionRepository;
    @Autowired
    protected GameRepository gameRepository;

    public String createGameSession(Integer gameId, MultipartFile file) throws CustomException {
        if(file.isEmpty()) throw new CustomException("File contet empty", HttpStatus.NO_CONTENT.value());
        if(gameRepository.findById(gameId).isEmpty()) throw new CustomException("Game not found", HttpStatus.NOT_FOUND.value());



        return "";
    }
}
