package xyz.aaratprasadchopra.hacker_rank.problem_solving.warmup;

import java.util.List;

public class CalculateRatio {
    public static void plusMinus(List<Integer> arr) {
        double plusC = 0;
        double minusC = 0;
        double zeroC = 0;

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) > 0) {
                plusC++;
            } else if (arr.get(i) < 0) {
                minusC++;
            } else {
                zeroC++;
            }
        }
        double ratioPlus = plusC / arr.size();
        double ratioMinus = minusC / arr.size();
        double ratioZero = zeroC / arr.size();
        System.out.format("%.6f\n%.6f\n%.6f\n", ratioPlus, ratioMinus, ratioZero);
    }
}
