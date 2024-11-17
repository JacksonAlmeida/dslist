package com.sunflower.dslist.resources;

import com.sunflower.dslist.dtos.GameListDto;
import com.sunflower.dslist.dtos.GameMinDto;
import com.sunflower.dslist.dtos.ReplacementDTO;
import com.sunflower.dslist.services.GameListService;
import com.sunflower.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListResource {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<GameListDto>> findAll() {
        List<GameListDto> gameListDto = gameListService.findAll();
        return ResponseEntity.ok().body(gameListDto);
    }

    @GetMapping("/{listId}/games")
    public ResponseEntity<List<GameMinDto>> findByList(@PathVariable Long listId) {
        List<GameMinDto> gameListDto = gameService.findByList(listId);
        return ResponseEntity.ok().body(gameListDto);
    }

    @PostMapping(value = "/{listId}/replacement")
    public ResponseEntity<Void> move(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
        return ResponseEntity.noContent().build();
    }

}
