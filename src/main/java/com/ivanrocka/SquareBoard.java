package main.java.com.ivanrocka;
import main.java.com.ivanrocka.Key;

import java.util.*;

public class SquareBoard extends Board{
    public SquareBoard(int size) {
        super(size,size);

    }

    @Override
    public void fillBoard(List list) {
        ListIterator<Integer> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            for (int i = 0; i < this.width; i++) {
                for (int j = 0; j < this.height; j++) {
                    this.addItem(new Key(i,j), listIterator.next());
                }
            }
        }

    }

    @Override
    public List<Key> availableSpace() {
        List<Key> keySpace = new ArrayList<>(); // создаю список куда буду складывать ключи с пустыми значениями (свободные клетки)
        /** !!!!Comment only for me!!!!
         * Создаю итератор по нашей мапе board, Map.Entry - внутренний интерфейс мапы в котором хранятся пары ключ=значение
         * и для их получения вызываю у board метод entrySet() - возвращающий множество пар
         */
        Iterator<Map.Entry<Key,Integer>> iterator = this.board.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Key,Integer> entry = iterator.next();
            if(entry.getValue() == null) {
                keySpace.add(entry.getKey());
            }
        }
        return keySpace;
    }

    @Override
    public void addItem(Key key, Integer value) {
        this.board.put(key,value);
    }

    @Override
    public Key getKey(int i, int j) {
        /**!!!!Comment only for me!!!!
         * Тут перебор циклом for-each, элементы те же что и в методе выше
         */
        for (Map.Entry<Key,Integer> entry : this.board.entrySet()) {
            if((entry.getKey().getI() == i)&(entry.getKey().getJ() == j)) {
                return entry.getKey();
            }
        }
        return null;
    }

    @Override
    public Integer getValue(Key key) {
        return this.board.get(key);
    }

    @Override
    public List<Key> getColumn(int j) {
        List<Key> columnKeys = new ArrayList<>();
        for (int i = 0; i < this.height; i++) {
            columnKeys.add(this.getKey(i,j));
        }
        return columnKeys;
    }

    @Override
    public List<Key> getRow(int i) {
        List<Key> columnKeys = new ArrayList<>();
        for (int j = 0; j < this.width; j++) {
            columnKeys.add(this.getKey(i,j));
        }
        return columnKeys;
    }

    @Override
    public boolean hasValue(Integer value) {
        return this.board.containsValue(value);
    }

    @Override
    public List<Integer> getValues(List<Key> keys) {
        List<Integer> row_values = new ArrayList<>();
        ListIterator<Key> listIterator = keys.listIterator();
        while (listIterator.hasNext()) {
            row_values.add(this.board.get(listIterator.next()));
        }
        return row_values;
    }

}
