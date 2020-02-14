package com.minesweeper.api;

import com.minesweeper.model.Board;
import com.minesweeper.model.Game;
import com.minesweeper.model.GameRepository;

import java.util.Arrays;

public class MineSweeperApiImpl implements MineSweeperApi {
    GameRepository gameRepository;

    public MineSweeperApiImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public String createGame(int rows, int columns, int mines) {
        Game game = new Game(new Board(createRandomBoardDefinition(rows, columns, mines), rows, columns));
        return gameRepository.save(game) + "";
    }

    public void revealSquareAt(int row, int column, int gameId) {
        Game game = gameRepository.findGameById(gameId);
        game.revealSquareAt(row, column);
    }

    private String createRandomBoardDefinition(int rows, int columns, int mines) {
        char[] array = new char[rows * columns];
        Arrays.fill(array, '.');
        StringBuilder s = new StringBuilder(new String(array));
        for (int i = 0; i < mines; i++) {
            s.setCharAt((int) (Math.random() * rows * columns), 'X');
        }
        return s.toString();
    }

    public boolean isOver(int gameId) {
        Game game = gameRepository.findGameById(gameId);
        return game.isOver();
    }

    @Override
    public void flagSquareAt(int row, int column, int gameId) {
        Game game = gameRepository.findGameById(gameId);
        game.flagSquareAt(row, column);
    }

    @Override
    public String getBoard(int gameId) {
        Board board = gameRepository.findGameById(gameId).getBoard();
        board.showAll();
        return board.toString();
    }

}
