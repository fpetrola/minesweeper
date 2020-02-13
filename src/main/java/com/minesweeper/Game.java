package com.minesweeper;

import java.util.Set;

public class Game {
    private Board board;
    private boolean over;

    public Game(Board board) {
        this.board = board;
    }

    public void revealSquareAt(int row, int column) {
        Square square = board.getSquareAt(row, column);
        if (!square.hasFlag())
            if (square.isMine()) {
                board.showAll();
                over = true;
            } else
                revealAdjacentSquares(square);
    }

    private void revealAdjacentSquares(Square square) {
        if (!square.isMine() && square.isHidden()) {
            square.show();

            Set<Square> adjacentSquares = square.getAdjacentSquares();
            long count = adjacentSquares.stream().filter(s -> s.isMine()).count();

            if (count == 0) {
                square.setValue(' ');
                adjacentSquares.stream().forEach(s -> revealAdjacentSquares(s));
            } else
                square.setValue(Character.forDigit((int) count, 10));
        }
    }

    public boolean isOver() {
        return over;
    }

    public void flagSquareAt(int row, int column) {
        Square squareAt = board.getSquareAt(row, column);
        squareAt.setFlag(true);
    }
}
