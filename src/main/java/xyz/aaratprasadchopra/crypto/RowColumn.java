/*  ASSIGNMENT 3 --> SIMPLE COLUMNAR CIPHER  */

package xyz.aaratprasadchopra.crypto;

import java.util.ArrayList;
import java.util.List;

public class RowColumn {
    public static void encrypt(String plainText) {
        encrypt(plainText, 1);
    }

    public static void encrypt(String plainText, int level) {
        plainText = plainText.toUpperCase();
        var withoutSpacesPT = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++) {
            if (Character.isAlphabetic(plainText.charAt(i)))
                withoutSpacesPT.append(plainText.charAt(i));
        }

        plainText = withoutSpacesPT.toString();
        var factors = factors(plainText.length());
        var randomCol = (int) (Math.random() * factors.size());
        var randomRow = (int) (Math.random() * factors.size());

        while (factors.get(randomCol) * factors.get(randomRow) <= plainText.length()) {
            randomCol = (int) (Math.random() * factors.size());
            randomRow = (int) (Math.random() * factors.size());
        }

        var columns = factors.get(randomCol);
        var rows = factors.get(randomRow);
        var matrix = new char[columns][rows];
        var indexPT = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (indexPT == plainText.length())
                    break;
                else {
                    matrix[i][j] = plainText.charAt(indexPT);
                    indexPT++;
                }
            }
        }

        var indexCol = 0;
        var cypherText = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            while (Character.isAlphabetic(matrix[indexCol][i])) {
                cypherText.append(matrix[indexCol][i]);
                indexCol++;
            }
            indexCol = 0;
        }
        System.out.println(cypherText);
    }

    private static List<Integer> factors(int lengthPT) {
        var factors = new ArrayList<Integer>();

        for (int i = 2; i < lengthPT; i++) {
            if (lengthPT % i == 0)
                factors.add(i);
        }
        return factors;
    }
}
