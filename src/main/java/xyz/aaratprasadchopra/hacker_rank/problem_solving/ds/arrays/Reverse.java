package xyz.aaratprasadchopra.hacker_rank.problem_solving.ds.arrays;

import java.util.List;

public class Reverse {
    public static void reverse(List<Integer> list) {
        // [1, 2, 3, 4] --> [4, 2, 3, 1] --> [4, 3, 2, 1]
        int left = 0;
        int right = list.size() - 1;
        for (int i = 0; i < list.size() / 2; i++) {
            int leftBackup = list.get(left);
            list.set(left, list.get(right));
            list.set(right, leftBackup);
            left++;
            right--;
        }
        System.out.println(list);
    }
}
