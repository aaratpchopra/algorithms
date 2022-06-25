/*  ASSIGNMENT 4 --> POLYALPHABETIC CIPHER (Vigenère Cipher)  */

package xyz.aaratprasadchopra.crypto;

public class Polyalphabetic {
    private final static String ALPHABETS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void encrypt(String plainText, String key) {
        encrypt(false, plainText, key);
    }

    public static void encrypt(boolean useVernamCipher, String plainText, String key) {
        plainText = plainText.toUpperCase();
        key = key.toUpperCase();

        if (plainText.length() > key.length())
            key = generateKey(plainText, key);

        var encryptedText = new StringBuilder();

        for (int i = 0; i < plainText.length(); i++) {
            if (!Character.isAlphabetic(plainText.charAt(i))) {
                encryptedText.append(plainText.charAt(i));
                continue;
            }

            if (!useVernamCipher) {
                int c = (ALPHABETS.indexOf(plainText.charAt(i)) + ALPHABETS.indexOf(key.charAt(i))) % 26;
                encryptedText.append(ALPHABETS.charAt(c));
            } else {
                int c = ALPHABETS.indexOf(plainText.charAt(i)) ^ ALPHABETS.indexOf(key.charAt(i));
                encryptedText.append(ALPHABETS.charAt(c));
            }
        }

        System.out.println(encryptedText);
    }

    private static String generateKey(String plainText, String key) {
        var keyBuilder = new StringBuilder();
        var keyArr = key.split("");

        for (int i = 0, j = 0; i < plainText.length(); j++, i++) {
            if (!Character.isAlphabetic(plainText.charAt(i))) {
                keyBuilder.append(plainText.charAt(i));
                j = j - 1;
                continue;
            }

            keyBuilder.append(keyArr[j]);
            if (j == keyArr.length - 1)
                j = -1;
        }
        return keyBuilder.toString();
    }
}
