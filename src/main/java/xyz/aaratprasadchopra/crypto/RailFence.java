/*  ASSIGNMENT 3 --> RAIL FENCE CIPHER  */

package xyz.aaratprasadchopra.crypto;

public class RailFence {
    public static void encrypt(String plainText, int depth) {
        if (depth == 1) {
            System.out.println("CAN'T ENCRYPT!");
            return;
        }

        var withoutSpacePT = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++) {
            if (!Character.isAlphabetic(plainText.charAt(i))) {
                continue;
            }
            withoutSpacePT.append(plainText.charAt(i));
        }
        plainText = withoutSpacePT.toString();
        var fence = new int[depth][plainText.length()];
        int column = 0;
        boolean towardsZero = false;

        for (int i = 0; i < plainText.length(); i++) {
            if (depth > 2) {
                if (column == depth) {
                    column -= 2;
                    towardsZero = true;
                }

                if (towardsZero) {
                    fence[column][i] = plainText.charAt(i);
                    column--;
                    if (column == 0)
                        towardsZero = false;
                } else {
                    fence[column][i] = plainText.charAt(i);
                    column++;
                }
            } else {
                if (column == depth) {
                    column -= 2;
                }

                fence[column][i] = plainText.charAt(i);
                column++;
            }
        }

        var cipherText = new StringBuilder();
        for (int i = 0; i < fence.length; i++) {
            for (int j = 0; j < fence[i].length; j++) {
                if (Character.isAlphabetic(fence[i][j])) {
                    cipherText.append((char) fence[i][j]);
                }
            }
        }
        System.out.println(cipherText);
    }
}
