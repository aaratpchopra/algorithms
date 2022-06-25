package xyz.aaratprasadchopra.FCC_10_common;

public class FirstAndLast {
    public static void firstLast(int[] sortedArray, int target) {

        int low = 0;
        int mid = sortedArray.length / 2;
        int high = sortedArray.length;

        while (low <= high) {
            if (target < sortedArray[mid]) {
                high = mid;
                mid = (high - low) / 2;
            } else if (target > sortedArray[mid]) {
                low = mid;
                mid = mid + (high + low) / 2 - 1;
            } else {
                System.out.println("FOUND");
                return;
            }
        }

    }
}
