package xyz.aaratprasadchopra.leet_code.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> container = new ArrayList<>();

        possibleCombinations(Arrays.asList(-1, 0, -1));

        for (int i = 0; i < 1; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> set = Arrays.asList(nums[i], nums[j], nums[k]);
                        if (!container.contains(set))
                            container.add(set);
                        else
                            continue;
                    } else
                        continue;
                }
            }
        }
        System.out.println(container);
        return container;
    }

    private static List<List<Integer>> possibleCombinations(List<Integer> set) {
        List<List<Integer>> combinations = new ArrayList<>();
        int index = 0;

        System.out.println(combinations);
        return combinations;
    }
}
