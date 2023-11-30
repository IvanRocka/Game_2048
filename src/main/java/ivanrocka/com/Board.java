package main.java.ivanrocka.com;

import java.security.Key;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Board {
    private int weight, height;
    private Map board = new HashMap<>();

    public Board(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }
//    public Board() {
//
//    }
    public abstract void fillBoard(List list);

    public  abstract  List availableSpace();

    public abstract void addItem(Key key, Integer value);
    public  abstract Key getKey(int i, int j);
    public abstract Integer getValue(Key key);
    public abstract List getColumn(int j);
    public abstract  List getRow(int i);
    public abstract boolean hasValue(Integer value);
    public abstract List<Integer> getValues(List<Key> keys);
}
