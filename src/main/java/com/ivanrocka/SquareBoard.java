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
            for (int i = 0; i < (list.size() - 1); i++) {
                for (int j = 0; j < (list.size() - 1); j++) {
                    this.addItem(new Key(i,j), listIterator.next());
                }
            }
        }

    }

    /*
    Возвращает список свободных ключей (i,j) - координат поля
     */
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
        board.put(key,value);
    }

    /*
    Вернуть ключ по координатам
     */
    @Override
    public Key getKey(int i, int j) {
        /**!!!!Comment only for me!!!!
         * Тут перебор циклом for-each, элементы те же что и в методе выше
         */
        for (Map.Entry<Key,Integer> entry : board.entrySet()) {
            if((entry.getKey().getI() == i)&(entry.getKey().getJ() == j)) {
                return entry.getKey();
            }
        }
        return null;
    }
    /*
    Вернуть значение текущего ключа
     */
    @Override
    public Integer getValue(Key key) {

        return board.get(key);
    }

    /*
    Вернуть список ключей в колонке
     */
    @Override
    public List<Key> getColumn(int j) {
        List<Key> columnKeys = new ArrayList<>();
        for (int i = 0; i < this.height; i++) {
            columnKeys.add(this.getKey(i,j));
        }
        return columnKeys;
    }

    /*
    Вернуть список ключей в строке по индексу
     */
    @Override
    public List<Key> getRow(int i) {
        List<Key> columnKeys = new ArrayList<>();
        for (int j = 0; j < this.width; j++) {
            columnKeys.add(this.getKey(i,j));
        }
        return columnKeys;
    }

    /*
    Имеет ли такое поле наша игра
     */
    @Override
    public boolean hasValue(Integer value) {

        return board.containsValue(value);
    }

    /*
    Получить список значений по списку ключей
     */
    @Override
    public List<Integer> getValues(List<Key> keys) {
        List<Integer> row_values = new ArrayList<>();
        ListIterator<Key> listIterator = keys.listIterator();
        while (listIterator.hasNext()) {
            row_values.add(board.get(listIterator.next()));
        }
        return row_values;
    }

}
