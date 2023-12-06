package main.java.com.ivanrocka;

import java.util.Arrays;

public class TestClass {
    public static void main(String[] args) {
        SquareBoard board = new SquareBoard(4);
        Game game2048 = new Game2048(board);
        System.out.println(game2048.canMove());
    }
}
