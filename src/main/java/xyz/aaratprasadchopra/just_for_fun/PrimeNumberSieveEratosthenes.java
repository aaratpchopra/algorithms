package xyz.aaratprasadchopra.just_for_fun;

import java.util.Arrays;

public class PrimeNumberSieveEratosthenes {
    public static void listPrimeNumbers(int till) {
        till -= 1;
        var numbers = new int[till];
        var arePrimes = new boolean[till];
        Arrays.fill(arePrimes, true);

        for (int i = 0, j = 2; i < till; i++, j++) {
            numbers[i] = j;
        }

        for (int i = 0; i < numbers.length - 1; i++) {

            int j = i + 1;
            int isFact = j;

            for (; j < numbers.length; j++) {
                if (numbers[j] % numbers[i] == 0 && arePrimes[isFact]) {
                    arePrimes[isFact] = false;
                }
                isFact++;
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            if (arePrimes[i]) {
                System.out.print(numbers[i] + " ");
            }
        }
        System.out.println();
    }
}
