package xyz.aaratprasadchopra.ab.matrices;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class LowerTriangle {
    private final List<List<Integer>> matrix;
    @Setter
    private int matrixDim = 5;
    private List<Integer> elementsLT;

    public LowerTriangle() {
        this.matrix = new ArrayList<>();
        this.elementsLT = new ArrayList<>();
        this.generateMatrix();
    }

    private void generateMatrix() {
        var random = new Random();
        for (int i = 0; i < this.matrixDim; i++) {
            var row = new ArrayList<Integer>();
            for (int j = 0; j < matrixDim; j++) {
                row.add(random.nextInt(50));
            }
            this.matrix.add(row);
        }
    }

    /**
     * The row major method adds the element row by row in an array.
     */
    public void rowMajor() {
        for (int i = 0; i < this.matrixDim; i++) {
            for (int j = 0; j <= i; j++) {
                this.elementsLT.add(matrix.get(i).get(j));
            }
        }
    }

    /**
     *
     * @param column The column of the matrix.
     * @param row The row of the matrix.
     * @return Returns the value at the corresponding index.
     */
    public int accessAnElement(int column, int row) {
        /*
            sum of N natural numbers = n(n+1) / 2
            1
            2, 3
            4, 5, 6
            7, 8, 9, 10
        */

        var elementIndex = (column * (column - 1)) / 2 + row - 1;
        return this.elementsLT.get(elementIndex);
    }

    public void display() {
        for (int i = 0; i < this.elementsLT.size(); i++) {
            for (int j = 0; j < this.elementsLT.size(); j++) {
                if (j <= i)
                    System.out.print(this.elementsLT.get(j) + " ");
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        var strBu = new StringBuilder();
        for (int i = 0; i < this.matrixDim; i++) {
            for (int j = 0; j < this.matrixDim; j++) {
                strBu.append(this.matrix.get(i).get(j)).append("\t");
            }
            strBu.append("\n");
        }
        return strBu.toString();
    }
}
