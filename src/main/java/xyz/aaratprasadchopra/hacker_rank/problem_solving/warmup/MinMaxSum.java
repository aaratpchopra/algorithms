package xyz.aaratprasadchopra.hacker_rank.problem_solving.warmup;

import java.util.List;

public class MinMaxSum {

    public static void miniMaxSum(List<Integer> arr) {
        int minimum = Integer.MAX_VALUE;
        int maximum = Integer.MIN_VALUE;
        long minC = 0;
        long maxC = 0;

        for (int i = 0; i < arr.size(); i++) {
            if (minimum > arr.get(i))
                minimum = arr.get(i);
        }

        for (int i = 0; i < arr.size(); i++) {
            if (maximum < arr.get(i))
                maximum = arr.get(i);
        }

        if (minimum == maximum) {
            for (int i = 0; i < arr.size() - 1; i++) {
                minC += arr.get(i);
            }

            for (int i = 0; i < arr.size() - 1; i++) {
                maxC += arr.get(i);
            }
        } else {
            for (int i = 0; i < arr.size(); i++) {
                if (minimum == arr.get(i))
                    continue;
                minC += arr.get(i);
            }

            for (int i = 0; i < arr.size(); i++) {
                if (maximum == arr.get(i))
                    continue;
                maxC += arr.get(i);
            }
        }

        System.out.println(maxC + " " + minC);
    }
}
