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
}
