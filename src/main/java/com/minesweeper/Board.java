package com.minesweeper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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

        squares.stream().forEach(s -> s.setAdjacentSquares(getAdjacentSquaresOf(s)));
    }

    private Set<Square> getAdjacentSquaresOf(Square square) {
        Set<Square> adjacentSquares = new HashSet<>();

        addAdjacentSquare(square, adjacentSquares);

        return adjacentSquares;
    }

    private void addAdjacentSquare(Square square, Set<Square> adjacentSquares) {
        int row = square.getRow() - 1;
        int column = square.getColumn() - 1;

        if (row >= 0 && column >= 0 && row < rows && column < columns)
            adjacentSquares.add(getSquareAt(row, column));
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
