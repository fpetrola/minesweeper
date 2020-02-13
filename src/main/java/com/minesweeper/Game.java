package com.minesweeper;

public class Game {
    private Board board;

    public Game(Board board) {
        this.board = board;
    }

    public void revealSquareAt(int row, int column) {
        if (board.thereIsMineAt(row, column)) {
            board.showAll();
        }
    }
}
