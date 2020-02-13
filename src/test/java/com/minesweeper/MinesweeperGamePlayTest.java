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

        Board board = new Board(initialBoardState, 3, 3);

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

        Board board = new Board(initialBoardState, 3, 3);
        board.hideSquares();

        Assert.assertEquals(hiddenBoardState, board.toString());
    }


    @Test
    public void revealingMineSquareShowsAllSquares() {
        String initialBoardState=
                        ".X." +
                        "X.." +
                        "..X" ;

        String hiddenBoard=
                        ".X." +
                        "X.." +
                        "..X" ;

        Board board= new Board(initialBoardState, 3, 3);
        board.hideSquares();

        Game game = new Game(board);
        game.revealSquareAt(0, 1);

        Assert.assertEquals(hiddenBoard, board.toString());
    }
}
