package com.minesweeper;

import java.util.HashMap;
import java.util.Map;

public class GameRepository {
    private int id;
    private Map<Integer, Game> games = new HashMap<>();

    public void save(Game game) {
        games.put(id++, game);
    }

    public Game findGameById(int id) {
        return games.get(id);
    }
}
