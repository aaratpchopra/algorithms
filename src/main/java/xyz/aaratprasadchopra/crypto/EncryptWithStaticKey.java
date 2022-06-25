/*  ASSIGNMENT 1 --> CLASSICAL SUBSTITUTION METHOD  */

package xyz.aaratprasadchopra.crypto;

public class EncryptWithStaticKey {
    public static void encrypt_static_key(String plainText) {
        System.out.println(encrypt_static_key_logic(plainText));
    }

    public static void encrypt_static_key(String plainText, boolean isCaps) {
        System.out.println(
                isCaps ? encrypt_static_key_logic(plainText) : encrypt_static_key_logic(plainText).toLowerCase());
    }

    private static String encrypt_static_key_logic(String plainText) {
        String ALPHABET = "aBcDeFgHiJkLmNoPqRsTuVwXyZ";
        StringBuilder alphabet = new StringBuilder(ALPHABET.toUpperCase());
        StringBuilder encryptedText = new StringBuilder();
        plainText = plainText.toUpperCase();
        int key = 3;
        String substring = alphabet.substring(0, key);
        alphabet.append(substring);
        String asString = alphabet.toString();
        asString = asString.substring(key);

        char[] ptAsArray = plainText.toCharArray();

        for (char c : ptAsArray) {
            int atIndex = alphabet.indexOf(String.valueOf(c));
            encryptedText.append(asString.charAt(atIndex));
        }
        return encryptedText.toString();
    }
}
