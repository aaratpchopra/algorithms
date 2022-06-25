package xyz.aaratprasadchopra.hacker_rank.problem_solving.warmup;

import java.util.List;

public class BirthdayCandles {
    public static int birthdayCakeCandles(List<Integer> candles) {
        int maximum = Integer.MIN_VALUE;
        int highUnit = 0;

        for (int i = 0; i < candles.size(); i++) {
            if (maximum < candles.get(i))
                maximum = candles.get(i);
        }

        for (int i = 0; i < candles.size(); i++) {
            if (maximum == candles.get(i))
                highUnit++;
        }
        // System.out.println(highUnit);
        return highUnit;
    }
}
