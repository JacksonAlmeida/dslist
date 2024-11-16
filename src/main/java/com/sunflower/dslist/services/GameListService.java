package com.sunflower.dslist.services;

import com.sunflower.dslist.dtos.GameListDto;
import com.sunflower.dslist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDto> findAll() {
        return gameListRepository.findAll().stream().map(GameListDto::new).toList();
    }

}
