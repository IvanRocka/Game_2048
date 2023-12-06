package main.java.com.ivanrocka;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class GameHelper {
    public List<Integer> moveAndMergeEqual(List<Integer> list) {
        Integer previousValue = null;
        Integer currentValue = null;
        List<Integer> listNull = new ArrayList<>();
        if (checkIsEmpty(list)) {
            return list;
        }
        else {
            var listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                currentValue = listIterator.next();
                //Если текущее значение null то удалим его из общего списка, потом добавим кол-во null в конец
                if (currentValue == null) {
                    listIterator.remove();
                    listNull.add(null);
                }
                else {
                    // Если это не первый элемент списка, то проверим его на равенство предыдущему
                    // и если равен, то объединяем в один
                    if(previousValue != null) {
                        if(currentValue==previousValue) {
                            listIterator.set(currentValue+previousValue);
                            // Установим предыдущий элемент листа в null
                            list.set(listIterator.previousIndex(), null);
                        }
                        // По идее тут же ссылка обновится после set() и я уже положу в previousValue объединенныое значение!?
                        previousValue = currentValue;
                    }
                    // Если же это первое значение в списке, то просто обновлю previousValue
                    else {
                        previousValue = currentValue;
                    }
                }
            }
            //Прошли по всему списку и добавляем кол-во null значений в конец
            list.addAll(listNull);
        }
        return list;
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
