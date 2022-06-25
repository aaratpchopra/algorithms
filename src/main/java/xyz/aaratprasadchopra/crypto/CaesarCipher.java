/*  ASSIGNMENT 2 --> CAESAR CIPHER  */

package xyz.aaratprasadchopra.crypto;

public class CaesarCipher {
    public static void caesarCipher(String word, int key) {
        System.out.println(cipher(word, key));
    }

    private static String cipher(String word, int key) {
        String ALPHABET = "aBcDeFgHiJkLmNoPqRsTuVwXyZ";
        StringBuilder cypheredText = new StringBuilder();
        word = word.toUpperCase();
        ALPHABET = ALPHABET.toUpperCase();
        String alphabetBackup = ALPHABET;

        StringBuilder alphabets = new StringBuilder(ALPHABET);
        ALPHABET = ALPHABET.substring(0, key);
        alphabets = alphabets.append(ALPHABET);
        String finalStr = alphabets.substring(key);
        char[] charWord = word.toCharArray();

        for (char ch : charWord) {
            int index = alphabetBackup.indexOf(ch);
            cypheredText.append(finalStr.charAt(index));
        }
        return cypheredText.toString();
    }
}
