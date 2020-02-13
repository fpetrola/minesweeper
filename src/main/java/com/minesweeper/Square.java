package com.minesweeper;

import java.util.Set;

public class Square {
    private final int row;
    private final int column;
    private char value;
    private boolean hidden;
    private Set<Square> adjacentSquares;
    private boolean flag;

    public Square(int row, int column, char value) {
        this.row = row;
        this.column = column;
        this.value = value;
    }

    public char getValue() {
        return flag ? '?' : (hidden ? '.' : value);
    }

    public void hide() {
        hidden = true;
    }

    public void show() {
        hidden = false;
    }

    public boolean isMine() {
        return value == 'X';
    }

    public boolean isHidden() {
        return hidden;
    }

    public Set<Square> getAdjacentSquares() {
        return adjacentSquares;
    }

    public void setValue(char value) {
        this.value = value;
    }

    public void setAdjacentSquares(Set<Square> adjacentSquares) {
        this.adjacentSquares = adjacentSquares;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public boolean hasFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
