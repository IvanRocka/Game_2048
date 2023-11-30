package main.java.ivanrocka.com;
public interface Game {
    public void init();
    public boolean canMove();
    public boolean move(Direction direction);
    public void addItem();
    Board getGameBoard();
    public boolean hasWin();
}
