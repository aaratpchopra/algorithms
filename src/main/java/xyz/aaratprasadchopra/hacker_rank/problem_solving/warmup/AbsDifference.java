package xyz.aaratprasadchopra.hacker_rank.problem_solving.warmup;

import java.util.List;

public class AbsDifference {
    public static int diagonalDifference(List<List<Integer>> arr) {
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.get(i).size(); j++) {
                if (i == j) {
                    sum1 += arr.get(i).get(j);
                }
            }
        }
        System.out.println();
        for (int i = 0; i < arr.size(); i++) {
            int j = arr.get(i).size() - 1 - i;
            sum2 += arr.get(i).get(j);
        }

        return Math.abs(sum1 - sum2);
    }
}
