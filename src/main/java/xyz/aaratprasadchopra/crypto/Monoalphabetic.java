/*  ASSIGNMENT 4 --> MONOALPHABETIC CIPHER  */

package xyz.aaratprasadchopra.crypto;

import java.util.ArrayList;
import java.util.Random;

public class Monoalphabetic {
    private final static String ALPHABETS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void encrypt(String plainText) {
        plainText = plainText.toUpperCase();
        var alphaCharArr = ALPHABETS.toCharArray();
        var letterUsed = new ArrayList<Integer>();
        var random = new Random();
        var plainTextBuilder = new StringBuilder(plainText);

        for (int i = 0; i < plainText.length(); i++) {
            if (!Character.isAlphabetic(plainText.charAt(i)))
                continue;

            var rand = random.nextInt(26);
            if (letterUsed.contains(rand)) {
                System.out.println("SAME, CHANGING!");
                while (true) {
                    rand = random.nextInt(26);
                    if (!letterUsed.contains(rand))
                        break;
                }
            }
            var replaceChar = alphaCharArr[rand];
            plainTextBuilder.setCharAt(i, replaceChar);
            letterUsed.add(rand);
        }

        System.out.print(letterUsed + "\t");
        System.out.println(letterUsed.size());
        System.out.println(plainTextBuilder);
    }
}
