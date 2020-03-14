package src.hust.soict.danghh.helper;

import java.util.ArrayList;

public class InsertionSort implements NumberSorter {
    @Override
    public void sort(ArrayList<Integer> arr) {
        for (int i = 1; i < arr.size(); ++i) {
            int key = arr.get(i);
            int j = i - 1;
            while (j >= 0 && arr.get(j) > key) {
                arr.set(j + 1, arr.get(j));
                j = j - 1;
            }
            arr.set(j + 1, key);
        }
    }
}
