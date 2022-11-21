package com.paradoxcalculator.europa.repositories;

import com.paradoxcalculator.europa.model.Game;
import com.paradoxcalculator.europa.model.GameSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameSessionRepository extends JpaRepository<GameSession, Integer> {
}
