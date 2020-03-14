package src.hust.soict.danghh.helper;

import java.util.ArrayList;

public class SelectionSorter implements NumberSorter{
    public void sort(ArrayList<Integer> arr) {
        for (int i = 0; i < arr.size() - 1; i++) {
            int min_index = i;
            for (int j = i + 1; j < arr.size(); j ++){
                if (arr.get(j) < arr.get(min_index)){
                    min_index = j;
                }
            }

            int temp = arr.get(i);
            arr.set(i, arr.get(min_index));
            arr.set(min_index, temp);
        }
    }
}
