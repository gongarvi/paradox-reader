package com.paradoxcalculator.europa.repositories;

import com.paradoxcalculator.europa.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
public interface GameRepository extends JpaRepository<Game, Integer> {
}
