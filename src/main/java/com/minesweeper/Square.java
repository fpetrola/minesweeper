package com.minesweeper;

public class Square {
    private final int row;
    private final int column;
    private final char value;
    private boolean hidden;

    public Square(int row, int column, char value) {
        this.row = row;
        this.column = column;
        this.value = value;
    }

    public char getValue() {
        return hidden ? '.' : value;
    }

    public void hide() {
        hidden = true;
    }

    public void show() {
        hidden= false;
    }

    public boolean isMine() {
        return getValue() == 'X';
    }
}
