package main.java.com.ivanrocka;

import java.util.*;

public class Game2048 implements Game{
    public static final int GAME_SIZE = 4;
    private Board<Key,Integer> board = new SquareBoard<>(GAME_SIZE);
    private GameHelper helper = new GameHelper();
    private Random random = new Random();


    public Game2048(Board<Key,Integer> board) {
        this.board = board;
    }
    public Game2048() {}

    @Override
    public void init() {
        board.fillBoard(Arrays.asList(2,4));
    }

    /*
    Проверка наличия свободной ячейки в игровом поле
     */
    @Override
    public boolean canMove() {

        return (!board.availableSpace().isEmpty());
    }

    /*
     Игровой ход в указанном направлении
     */
    @Override
    public boolean move(Direction direction) {
        switch (direction) {
            case UP:
                for(int idx = 0; idx < board.height; idx++) {
                    board.fillBoard(helper.moveAndMergeEqual(board.getValues(board.getColumn(idx))));
                }
                break;
            case DOWN:

                for(int idx = board.getHeight(); idx > 0; idx--) {
                    board.fillBoard(helper.moveAndMergeEqual(board.getValues(board.getColumn(idx))));
                }
                break;
            case LEFT:
                for(int idx = 0; idx < board.width; idx++) {
                    board.fillBoard(helper.moveAndMergeEqual(board.getValues(board.getRow(idx))));
                }
                break;
            case RIGHT:
                for(int idx = board.getWidth(); idx > 0; idx--) {
                    board.fillBoard(helper.moveAndMergeEqual(board.getValues(board.getRow(idx))));
                }
                break;

        }
        try {
            addItem();
        } catch (NotEnoughSpace notEnoughSpace) {
            System.out.println(notEnoughSpace.getMessage());
        }
        return true;
    }

    @Override
    public void addItem() throws NotEnoughSpace {
        List<Key> emptySpaces = board.availableSpace();
        if (emptySpaces.isEmpty()) {
            throw new NotEnoughSpace("There are no empty place on the board");
        }
        if (random.nextFloat() > 0.9) {
            board.addItem(emptySpaces.get(random.nextInt(emptySpaces.size() - 1)), 4);
        } else {
            board.addItem(emptySpaces.get(random.nextInt(emptySpaces.size() - 1)), 2);
        }
    }

    @Override
    public Board getGameBoard() {

        return board;
    }

    @Override
    public boolean hasWin() {
        return board.hasValue(2048);
    }
}
