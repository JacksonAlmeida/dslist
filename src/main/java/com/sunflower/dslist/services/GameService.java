package com.sunflower.dslist.services;

import com.sunflower.dslist.dtos.GameDto;
import com.sunflower.dslist.dtos.GameMinDto;
import com.sunflower.dslist.entities.Game;
import com.sunflower.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDto> findAll() {
        return gameRepository.findAll().stream().map(GameMinDto::new).toList();
    }

    @Transactional(readOnly = true)
    public GameDto findById(Long id) {
        Game game = gameRepository.findById(id).get();
        if (game != null) {
            return new GameDto(game);
        }
        return null;
    }

}
