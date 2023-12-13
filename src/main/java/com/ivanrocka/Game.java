package main.java.com.ivanrocka;
public interface Game {
    public void init();
    public boolean canMove();
    public boolean move(Direction direction);
    public void addItem() throws NotEnoughSpace;
    Board getGameBoard();
    public boolean hasWin();
}
