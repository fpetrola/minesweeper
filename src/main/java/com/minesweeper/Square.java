package com.minesweeper;

public class Square {
    private final int row;
    private final int column;
    private final char value;

    public Square(int row, int column, char value) {
        this.row = row;
        this.column = column;
        this.value = value;
    }

    public char getValue() {
        return value;
    }
}
