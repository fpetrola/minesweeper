package com.minesweeper;

public class Board {
    private String state;
    private final int rows;
    private final int columns;
    private String stringRepresentation;

    public Board(String state, int rows, int columns) {
        this.state = state;
        this.rows = rows;
        this.columns = columns;
        this.stringRepresentation = state;
    }

    public String toString() {
        return stringRepresentation;
    }

    public void hideSquares() {
        stringRepresentation = state.replace("X", ".");
    }

    public boolean thereIsMineAt(int row, int column) {
        return state.charAt(row * columns + column) == 'X';
    }

    public void showAll() {
        stringRepresentation = state;
    }
}
