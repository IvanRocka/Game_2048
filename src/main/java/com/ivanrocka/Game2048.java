package main.java.com.ivanrocka;

import java.util.Random;

public class Game2048 implements Game{
    SquareBoard board;
    private GameHelper helper;
    private Random random;


    public Game2048(SquareBoard board) {
        this.board = board;
        this.init();
    }

    @Override
    public void init() {
       helper = new GameHelper();
       random = new Random();
    }

    @Override
    public boolean canMove() {
        return (!this.board.availableSpace().isEmpty());
    }

    @Override
    public boolean move(Direction direction) {
        Direction currDirect = Direction.values()[direction];
        switch (direction) {
            case Direction.UP:

        }
    }

    @Override
    public void addItem() {

    }

    @Override
    public Board getGameBoard() {
        return null;
    }

    @Override
    public boolean hasWin() {
        return false;
    }
}
