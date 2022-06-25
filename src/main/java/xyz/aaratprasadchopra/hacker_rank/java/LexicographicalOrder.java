package xyz.aaratprasadchopra.hacker_rank.java;

import java.util.Arrays;
import java.util.Scanner;

public class LexicographicalOrder {

    public static void sortAlphabets() {
        String[] alpha = { "d", "x", "a", "e" };

    }

    public static void sortLexicographically() {
        Scanner scan = new Scanner(System.in);
        String word = "welcometojava";
        String[] splitWord = word.split("");
        String[] substringWords = new String[splitWord.length - 2];

        for (int i = 0; i < splitWord.length - 2; i++) {
            substringWords[i] = word.substring(i, i + 3);
        }
        System.out.println(Arrays.toString(substringWords));
        int smallest = 0;
        for (int i = 0; i < substringWords.length - 1; i++) {
            System.out.print(substringWords[i].compareTo(substringWords[i + 1]) + "\t");
        }

        System.out.println(smallest);

        String alpha = "MNOPQERSTUVABCDWXYZFGHIJKL";
        String alpha2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String[] alpha2Arr = alpha2.split("");
        String[] sortedArr = new String[26];

        for (int i = 0; i < alpha2Arr.length - 1; i++) {

        }
        // System.out.println("ava".compareTo("com"));
        // System.out.println("AVA".compareTo("WEL"));
        // System.out.println("AVA".compareTo("COM"));
        // System.out.println("WEL".compareTo("AVA"));
        // System.out.println(Arrays.toString(sortedArr));
    }
}
