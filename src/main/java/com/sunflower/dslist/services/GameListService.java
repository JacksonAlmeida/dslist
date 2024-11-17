package com.sunflower.dslist.services;

import com.sunflower.dslist.dtos.GameListDto;
import com.sunflower.dslist.projections.GameMinProjection;
import com.sunflower.dslist.repositories.GameListRepository;
import com.sunflower.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDto> findAll() {
        return gameListRepository.findAll().stream().map(GameListDto::new).toList();
    }

    @Transactional(readOnly = true)
    public void move(Long listId, int sourceIndex, int destionationIndex) {
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destionationIndex, obj);
        int min = sourceIndex < destionationIndex ? sourceIndex : destionationIndex;
        int max = sourceIndex < destionationIndex ? destionationIndex : sourceIndex;
        for (int i = min; i <= max; i ++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }

}
