package xyz.aaratprasadchopra.just_for_fun;

import java.util.Arrays;

/**
 * A 8 By 8 matrix containing value of times to of the previous one!
 */
public class PreviousTimesTwo {
    public static void riceDoubling() {
        var matrix = new long[8][8];
        long value = 1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = value;
                value *= 2;
            }
        }
        System.out.println(Arrays.toString(matrix));
    }
}
