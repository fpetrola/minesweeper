package com.minesweeper.model;

import java.util.HashMap;
import java.util.Map;

public class GameRepository {
    private int id;
    private Map<Integer, Game> games = new HashMap<>();

    public int save(Game game) {
        int newId = id++;
        games.put(newId, game);
        return newId;
    }

    public Game findGameById(int id) {
        return games.get(id);
    }
}
