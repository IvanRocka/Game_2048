package main.java.com.ivanrocka;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class GameHelper {
    public List<Integer> moveAndMergeEqual(List<Integer> list) {
        Integer nextValue = null;
        Integer currentValue = null;
        List<Integer> result = new ArrayList<>();
        int count_Null_value = 0;
        if (checkIsEmpty(list)) {
            return list;
        }
        else {
            var listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                currentValue = listIterator.next();
                //Если текущее значение null то удалим его из общего списка, потом добавим кол-во null в конец
                if (currentValue == null) {
                    count_Null_value++;
                }
                else {
                    // Если есть следующий элемент
                    if (listIterator.hasNext()) {
                        // Проверим на наличие null в след элемента
                        nextValue = listIterator.next();
                        if (nextValue != null) {
                            if (currentValue.equals(nextValue)) {
                                result.add(currentValue + nextValue);
                                count_Null_value++;
                            } else {
                                result.add(currentValue);
                            }
                        }
                    }
                    // Если же это первое значение в списке или конец списка, то просто добавлю его в result
                    else {
                        result.add(currentValue);
                    }
                }
            }
            //Прошли по всему списку и добавляем кол-во null значений в конец
            while (count_Null_value > 0) {
                result.add(null);
                count_Null_value--;
            }
        }
        return result;
    }

    public boolean checkIsEmpty(List<Integer> list) {
        Iterator<Integer> iterator = list.iterator();
        int count_Null = 0;
        while (iterator.hasNext()) {
            if (iterator.next() == null) {
                count_Null++;
            }
        }
        return count_Null==list.size();
    }
}
