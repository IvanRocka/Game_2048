package main.java.com.ivanrocka;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class GameHelper {
    public List<Integer> moveAndMergeEqual(List<Integer> list) {
        Integer nextValue = null;
        var current_idx = 0;
        var next_idx = 0;
        Integer currentValue = null;
        List<Integer> result = new ArrayList<>();

        if (checkIsEmpty(list)) {
            return list;
        }
        while (current_idx < list.size()) {
            currentValue = list.get(current_idx);
            if (currentValue == null) {
                current_idx++;
                continue;
            }
            next_idx = current_idx + 1;
            while (next_idx < list.size() && list.get(next_idx) == null) {
                next_idx++;
            }
            if (next_idx < list.size() && currentValue.equals(list.get(next_idx))) {
                result.add(currentValue * 2);
                current_idx = next_idx + 1;
            } else {
                result.add(currentValue);
                current_idx = next_idx;
            }
        }
        while (result.size() < list.size()) {
            result.add(null);
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
