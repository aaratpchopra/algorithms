/*  ASSIGNMENT 2 --> MODIFIED CAESAR CIPHER  */

package xyz.aaratprasadchopra.crypto;

import java.util.Scanner;

public class ModifiedCaesarCipher {
    private static final Scanner scan = new Scanner(System.in);

    public static void modifiedCaesarCypher() {
        System.out.println("Enter Word and Key:\n");
        String word = scan.nextLine();
        int key = scan.nextInt();
        System.out.println(cypher(word, key));
    }

    private static String cypher(String word, int key) {
        String ALPHABET = "aBcDeFgHiJkLmNoPqRsTuVwXyZ";
        StringBuilder cypheredText = new StringBuilder();
        ALPHABET = ALPHABET.toUpperCase();
        StringBuilder alphabetBackup = new StringBuilder(ALPHABET);
        word.toUpperCase();
        String alphaBackup = ALPHABET;
        word = word.toUpperCase();

        ALPHABET = ALPHABET.substring(0, key);
        alphabetBackup = alphabetBackup.append(ALPHABET);
        String finalAlpha = alphabetBackup.substring(key);
        // System.out.println(finalAlpha);

        for (char ch : word.toCharArray()) {
            if (!Character.isLetterOrDigit(ch)) {
                cypheredText.append(ch);
                continue;
            }
            int index = alphaBackup.indexOf(ch);
            cypheredText.append(finalAlpha.charAt(index));
        }

        return cypheredText.toString();
    }

}
