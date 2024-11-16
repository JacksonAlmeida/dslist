package com.sunflower.dslist.services;

import com.sunflower.dslist.dtos.GameListDto;
import com.sunflower.dslist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    public List<GameListDto> findAll() {
        return gameListRepository.findAll().stream().map(GameListDto::new).toList();
    }

}
