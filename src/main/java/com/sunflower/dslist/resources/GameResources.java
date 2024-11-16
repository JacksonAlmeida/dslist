package com.sunflower.dslist.resources;

import com.sunflower.dslist.dtos.GameDto;
import com.sunflower.dslist.dtos.GameMinDto;
import com.sunflower.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameResources {

    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<GameMinDto>> findAll() {
        List<GameMinDto> gameDtoList = gameService.findAll();
        return ResponseEntity.ok().body(gameDtoList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<GameDto> findById( @PathVariable Long id) {
        GameDto gameDto = gameService.findById(id);
        return ResponseEntity.ok().body(gameDto);
    }

}
