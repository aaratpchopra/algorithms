package xyz.aaratprasadchopra.neet_code.arrays_and_hashing;

import java.util.HashMap;

public class TwoSums {
    public static int[] twoSum(int[] nums, int target) {
        var hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            if (hashMap.containsKey(diff)) {
                return new int[] { hashMap.get(diff), i };
            }

            hashMap.put(nums[i], i);

        }
        return new int[] {};
    }
}
