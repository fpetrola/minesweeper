package com.minesweeper;

import java.util.Arrays;
import java.util.Set;

public class Square {
    private final int row;
    private final int column;
    private char value;
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
        return value == 'X';
    }

    public boolean isHidden() {
        return hidden;
    }

    public Set<Square> getAdjacentSquares() {
        return null;
    }

    public void setValue(char value) {
        this.value = value;
    }
}
