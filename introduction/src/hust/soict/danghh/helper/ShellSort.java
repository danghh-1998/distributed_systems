package src.hust.soict.danghh.helper;

import java.util.ArrayList;

public class ShellSort implements NumberSorter {
    @Override
    public void sort(ArrayList<Integer> arr) {
        int n = arr.size();
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i += 1) {
                int temp = arr.get(i);
                int j;
                for (j = i; j >= gap && arr.get(j - gap) > temp; j -= gap)
                    arr.set(j, arr.get(j - gap));
                arr.set(j, temp);
            }
        }
    }
}
