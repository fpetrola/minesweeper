package com.minesweeper;

import org.junit.Assert;
import org.junit.Test;

public class MinesweeperGamePlayTest {
    @Test
    public void boardCanBeCreated() {
        String initialBoardState=
                        ".X." +
                        "X.." +
                        "..X" ;

        Board board = new Board(initialBoardState);

        Assert.assertEquals(initialBoardState, board.toString());
    }

    @Test
    public void boardSquaresCanBeHide() {
        String initialBoardState=
                        ".X." +
                        "X.." +
                        "..X" ;

        String hiddenBoardState=
                        "..." +
                        "..." +
                        "..." ;

        Board board = new Board(initialBoardState);
        board.hideSquares();

        Assert.assertEquals(hiddenBoardState, board.toString());
    }
}
