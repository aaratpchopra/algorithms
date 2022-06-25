package xyz.aaratprasadchopra.ab.matrices;

import java.util.ArrayList;
import java.util.List;

public class Diagonal {
    private final List<Integer> data = new ArrayList<>();
    private int sizeMN = 10; // The MxN, where M and N is ALWAYS same! 5x5, 2x2, etc.
    private int value = 1;

    /**
     * Default Value is 10.
     * @param size Matrix Size.
     */
    public void setSizeMN(int size) {
        this.sizeMN = size;
    }

    public void fillingData() {
        for (int i = 0; i < this.sizeMN; i++) {
            for (int j = 0; j < this.sizeMN; j++) {
                if (i == j) {
                    this.data.add(this.value);
                    this.value++;
                }
            }
        }
    }

    public void displayData() {
        for (int i = 0; i < this.sizeMN; i++) {
            for (int j = 0; j < this.sizeMN; j++) {
                if (i == j) {
                    System.out.print(this.data.get(i) + " ");
                } else {
                    System.out.print(0 + " ");
                }
            }
            System.out.println();
        }
    }

    public void manualFillingData(int i, int j, int value) {
        if (i == j) {
            this.data.set(i - 1, value);
        }
    }

    public List<Integer> getDataList() { return this.data; }
}
