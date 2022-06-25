package xyz.aaratprasadchopra.neet_code.arrays_and_hashing;

import java.util.HashMap;

public class ContainsDuplicateTwo {
    public static boolean containsDuplicate(int[] nums) {
        // [1, 2, 3, 1, 1] --> True
        // [1, 2, 3, 4] --> False

        var hashMap = new HashMap<Integer, Integer>();

        for (int i : nums) {
            if (hashMap.containsKey(i)) {
                var curVal = hashMap.get(i);
                curVal++;
                hashMap.put(i, curVal);
            } else {
                hashMap.put(i, 1);
            }
        }
        for (int i : nums) {
            if (hashMap.get(i) > 1)
                return true;
        }
        return false;
    }
}
