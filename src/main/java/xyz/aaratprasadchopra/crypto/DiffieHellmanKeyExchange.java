/*  ASSIGNMENT 5 -->  DIFFIE HELLMAN KEY EXCHANGE ALGORITHM  */

package xyz.aaratprasadchopra.crypto;

import java.math.BigInteger;
import java.util.Random;

public class DiffieHellmanKeyExchange {

    public static void didKeyExchange(BigInteger party1, BigInteger party2) throws Exception {
        var random = new Random();
        var randomNumber = random.nextInt(10);

        var party1RandomNumber = randomNumber;
        randomNumber = random.nextInt(10);
        var party2RandomNumber = randomNumber;

        var s1 = party1.pow(party1RandomNumber).mod(party2);
        var s2 = party1.pow(party2RandomNumber).mod(party2);

        var key1 = s2.pow(party1RandomNumber).mod(party2);
        var key2 = s1.pow(party2RandomNumber).mod(party2);

        System.out.print(key1 + "\t" + key2);
        System.out.println();
    }
}