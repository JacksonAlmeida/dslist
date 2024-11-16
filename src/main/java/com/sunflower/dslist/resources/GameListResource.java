package com.sunflower.dslist.resources;

import com.sunflower.dslist.dtos.GameListDto;
import com.sunflower.dslist.services.GameListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListResource {

    @Autowired
    private GameListService gameListService;

    @GetMapping
    public ResponseEntity<List<GameListDto>> findAll() {
        List<GameListDto> gameListDto = gameListService.findAll();
        return ResponseEntity.ok().body(gameListDto);
    }

}
