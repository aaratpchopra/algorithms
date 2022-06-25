/*  ASSIGNMENT 5 -->  RSA (Rivest, Shamir, Adleman) ALGORITHM  */

package xyz.aaratprasadchopra.crypto;

import java.math.BigDecimal;
import java.math.BigInteger;

public class RSA_2 {
    public static void encrypt() {
        int randomPrime1, randomPrime2, publicKey, fi, decryptionKey = 0, encryptionKey;

        // The number to be encrypted and decrypted
        int msg = 12;
        double c;
        BigInteger msgback;

        randomPrime1 = 3;

        randomPrime2 = 11;
        publicKey = randomPrime1 * randomPrime2;
        fi = (randomPrime1 - 1) * (randomPrime2 - 1);

        for (encryptionKey = 2; encryptionKey < fi; encryptionKey++) {

            if (gcd(encryptionKey, fi) == 1) {
                break;
            }
        }
        System.out.println("the value of e = " + encryptionKey);
        for (int i = 0; i <= 9; i++) {
            int x = 1 + (i * fi);

            if (x % encryptionKey == 0) {
                decryptionKey = x / encryptionKey;
                break;
            }
        }
        System.out.println("the value of d = " + decryptionKey);
        c = (Math.pow(msg, encryptionKey)) % publicKey;
        System.out.println("Encrypted message is : " + c);

        // converting int value of n to BigInteger
        BigInteger N = BigInteger.valueOf(publicKey);

        // converting float value of c to BigInteger
        BigInteger C = BigDecimal.valueOf(c).toBigInteger();
        msgback = (C.pow(decryptionKey)).mod(N);
        System.out.println("Decrypted message is : "
                + msgback);
    }

    private static int gcd(int e, int z) {
        if (e == 0)
            return z;
        else
            return gcd(z % e, e);
    }
}
