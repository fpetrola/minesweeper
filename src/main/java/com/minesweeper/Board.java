package com.minesweeper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Board {
    private final List<Square> squares = new ArrayList<Square>();
    private final int rows;
    private final int columns;

    public Board(String state, int rows, int columns) {
        this.rows = rows;
        this.columns = columns;

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                squares.add(new Square(row, column, state.charAt(row * this.columns + column)));
            }
        }
    }

    public String toString() {
        return squares.stream().map(s -> s.getValue() + "").collect(Collectors.joining());
    }

    public void hideSquares() {
        squares.stream().forEach(s -> s.hide());
    }

    public Square getSquareAt(int row, int column) {
        return squares.get(row * columns + column);
    }

    public void showAll() {
        squares.stream().forEach(s -> s.show());
    }
}
