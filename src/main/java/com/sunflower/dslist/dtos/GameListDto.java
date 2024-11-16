package com.sunflower.dslist.dtos;

import com.sunflower.dslist.entities.GameList;

public class GameListDto {

    private Long id;
    private String name;

    public GameListDto() {}

    public GameListDto(GameList gameList) {
        this.id = gameList.getId();
        this.name = gameList.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
