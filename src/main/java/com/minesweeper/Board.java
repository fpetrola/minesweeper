package com.minesweeper;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<Square> squares = new ArrayList<Square>();
    private String state;
    private final int rows;
    private final int columns;
    private String stringRepresentation;

    public Board(String state, int rows, int columns) {
        this.state = state;
        this.rows = rows;
        this.columns = columns;
        this.stringRepresentation = state;

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                squares.add(new Square(row, column, getSquareValueAt(row, column)));
            }
        }
    }

    public String toString() {
        return stringRepresentation;
    }

    public void hideSquares() {
        stringRepresentation = state.replace("X", ".");
    }

    public boolean thereIsMineAt(int row, int column) {
        return getSquareValueAt(row, column) == 'X';
    }

    private char getSquareValueAt(int row, int column) {
        return state.charAt(row * columns + column);
    }

    public void showAll() {
        stringRepresentation = state;
    }
}
