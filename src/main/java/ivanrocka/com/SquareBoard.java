package main.java.ivanrocka.com;

import java.security.Key;
import java.util.List;

public class SquareBoard extends Board{
    public SquareBoard(int size) {
        super(size,size);

    }

    @Override
    public void fillBoard(List list) {

    }

    @Override
    public List availableSpace() {
        return null;
    }

    @Override
    public void addItem(Key key, Integer value) {

    }

    @Override
    public Key getKey(int i, int j) {
        return null;
    }

    @Override
    public Integer getValue(Key key) {
        return null;
    }

    @Override
    public List getColumn(int j) {
        return null;
    }

    @Override
    public List getRow(int i) {
        return null;
    }

    @Override
    public boolean hasValue(Integer value) {
        return false;
    }

    @Override
    public List<Integer> getValues(List<Key> keys) {
        return null;
    }
}
