package xyz.aaratprasadchopra.leet_code.easy;

import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        // [2, 7, 11, 15] --> Target: 9
        // [3, 2, 4] --> Target: 6
        int[] indices = new int[2];
        var hm = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            hm.put(i, nums[i]);
        }

        return new int[] { 0 };
    }
}
