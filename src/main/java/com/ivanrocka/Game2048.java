package main.java.com.ivanrocka;

import java.util.*;

public class Game2048 implements Game{
    SquareBoard board;
    private GameHelper helper = new GameHelper();
    private Random random = new Random();


    public Game2048(SquareBoard board) {
        this.board = board;
        this.init();
    }

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

                for(int idx = 0; idx < board.height; idx++) {
                    List<Integer> boardValues = board.getValues(board.getColumn(idx));
                    Collections.reverse(boardValues);
                    board.fillBoard(helper.moveAndMergeEqual(boardValues));
                }
                break;
            case LEFT:
                for(int idx = 0; idx < board.height; idx++) {
                    board.fillBoard(helper.moveAndMergeEqual(board.getValues(board.getRow(idx))));
                }
                break;
            case RIGHT:
                for(int idx = 0; idx < board.height; idx++) {
                    List<Integer> boardValues = board.getValues(board.getRow(idx));
                    Collections.reverse(boardValues);
                    board.fillBoard(helper.moveAndMergeEqual(boardValues));
                }
                break;

        }
        return false;
    }

    @Override
    public void addItem() {
        List<Key> emptySpaces = board.availableSpace();
        board.addItem(emptySpaces.get(random.nextInt(emptySpaces.size()-1)), 2);
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
