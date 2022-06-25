package xyz.aaratprasadchopra;

import xyz.aaratprasadchopra.ab.matrices.Diagonal;
import xyz.aaratprasadchopra.ab.matrices.LowerTriangle;
import xyz.aaratprasadchopra.ab.trees.BinaryTree;

import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {

        var diagonal = new Diagonal();
        diagonal.fillingData();
        System.out.println(diagonal.getDataList());
        diagonal.manualFillingData(1, 1, 100);
        System.out.println(diagonal.getDataList());

        var lowerTriangular = new LowerTriangle();
        lowerTriangular.rowMajor();
        System.out.println(lowerTriangular.getElementsLT());
        System.out.println(lowerTriangular.accessAnElement(3, 2));
        System.out.println(lowerTriangular);

        var bt = new BinaryTree<>();
//        bt.constructTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
//        bt.preOrder();
//        bt.preOrderItr();
//        System.out.println();
//        bt.inOrder();
//        bt.inOrderItr();
//        System.out.println();
//        bt.postOrder();
//        bt.postOrderItr();
    }
}
