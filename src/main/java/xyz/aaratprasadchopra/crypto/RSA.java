package xyz.aaratprasadchopra.crypto;

import java.util.Random;

public class RSA {
    private static int FI_FUNC = 0;
    private static int COMMON_PUBLIC_KEY = 0;
    private static int ENCRYPTED_KEY = 0;
    private static int DECRYPTION_KEY = 0;
    private static String encryptedText = null;

    public static String encrypt(int plainNumber) {
        encryptionKey();
        var encryption = ((long) Math.pow(plainNumber, ENCRYPTED_KEY)) % COMMON_PUBLIC_KEY;
        encryptedText = Long.toString(encryption);
        return encryptedText;
    }

    public static String decrypt() {
        if (encryptedText == null)
            return "ENCRYPT A NUMBER FIRST!";

        decryptionKey();
        long encryptedNumber = Long.parseLong(encryptedText);
        long decryption = ((long) Math.pow(encryptedNumber, DECRYPTION_KEY)) % COMMON_PUBLIC_KEY;
        return Long.toString(decryption);
    }

    private static void decryptionKey() {
        for (int i = 1; i <= FI_FUNC; i++) {
            DECRYPTION_KEY = (i * ENCRYPTED_KEY) % FI_FUNC;
            if (DECRYPTION_KEY == 1)
                break;
        }
    }

    public static void encryptionKey() {
        int p = randomPrime()[0];
        int q = randomPrime()[1];

        var n = new java.math.BigInteger(Integer.toString(p)).multiply(new java.math.BigInteger(Integer.toString(q)));

        System.out.println(p | q);

        int e = 0;

        int fi = (p - 1) * (q - 1);

        for (int i = 2; i <= fi; i++) {
            int gcd = GCD(fi, i);
            if (gcd == 1) {
                e = i;
                break;
            }
        }

        // RSA.COMMON_PUBLIC_KEY = n;
        RSA.ENCRYPTED_KEY = e;
        RSA.FI_FUNC = fi;
    }

    public static int GCD(int a, int b) {
        if (a == b)
            return a;

        if (b > a)
            return GCD(a, b - a);
        return GCD(a - b, b);
    }

    public static int[] randomPrime() {
        var random = new Random();

        var prime1 = random.nextInt(Integer.MAX_VALUE);
        var prime2 = random.nextInt(Integer.MAX_VALUE);

        var isNotPrime1 = true;
        var isNotPrime2 = true;
        var counter = 2;

        while (isNotPrime1) {
            if (prime1 % counter == 0 && counter != prime1) {
                prime1 = random.nextInt(Integer.MAX_VALUE);
                counter = 2;
            }

            if (counter == prime1 - 1)
                isNotPrime1 = false;
            counter++;
        }

        while (isNotPrime2) {
            if (prime2 % counter == 0 && counter != prime2) {
                prime2 = random.nextInt(Integer.MAX_VALUE);
                counter = 2;
            }

            if (counter == prime2 - 1)
                isNotPrime2 = false;
            counter++;
        }

        return new int[] { prime1, prime2 };
    }
}
