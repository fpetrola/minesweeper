package com.minesweeper;

public class Board {
    private String state;

    public Board(String state, int rows, int columns) {
        this.state = state;
    }

    public String toString() {
        return state;
    }

    public void hideSquares() {
        state= state.replace("X", ".");
    }
}
