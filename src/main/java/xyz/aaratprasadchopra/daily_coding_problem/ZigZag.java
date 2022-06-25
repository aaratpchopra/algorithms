package xyz.aaratprasadchopra.daily_coding_problem;

public class ZigZag {
    public static void zigZag(String word, int columns) {
        String[] wordArr = word.split("");
        var matrix = new String[columns][wordArr.length];
        boolean isDesc = false;
        int indexColumn = 0;

        for (int i = 0; i < wordArr.length; i++) {
            if (indexColumn == columns) {
                isDesc = true;
                indexColumn -= 2;
            }

            if (indexColumn < 0) {
                isDesc = false;
                indexColumn += 2;
            }

            if (!isDesc) {
                matrix[indexColumn][i] = wordArr[i];
                indexColumn++;
            } else {
                matrix[indexColumn][i] = wordArr[i];
                indexColumn--;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == null) {
                    System.out.print("  ");
                    continue;
                }
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
