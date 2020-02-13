package com.minesweeper;

import java.util.Set;

public class Game {
    private Board board;

    public Game(Board board) {
        this.board = board;
    }

    public void revealSquareAt(int row, int column) {
        Square square = board.getSquareAt(row, column);
        if (square.isMine()) {
            board.showAll();
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
}
