package com.samples.crls.dp;

import org.junit.jupiter.api.Test;

public class TestChainMatrixMultiplication {

    @Test
    public void testMatrixMultiplicationOrder() {
        MatrixDimensions[] matricesDimensions = {new MatrixDimensions(30, 35),
                new MatrixDimensions(35, 15),  new MatrixDimensions(15, 5),
                new MatrixDimensions(5, 10), new MatrixDimensions(10, 20),
                new MatrixDimensions(20, 25)};
        ChainMatrixMultiplication.printMatrixParenthesis(matricesDimensions);
    }

    @Test
    public void testMatrixMultiplicationOrderWithMemoization() {
        MatrixDimensions[] matricesDimensions = {new MatrixDimensions(30, 35),
                new MatrixDimensions(35, 15),  new MatrixDimensions(15, 5),
                new MatrixDimensions(5, 10), new MatrixDimensions(10, 20),
                new MatrixDimensions(20, 25)};
        ChainMatrixMultiplication.matrixChainOrderWithMemoization(matricesDimensions);
    }

    @Test
    public void testMatrixMultiplicationOrderRecursion() {
        MatrixDimensions[] matricesDimensions = {new MatrixDimensions(30, 35),
                new MatrixDimensions(35, 15),  new MatrixDimensions(15, 5),
                new MatrixDimensions(5, 10), new MatrixDimensions(10, 20),
                new MatrixDimensions(20, 25)};
        ChainMatrixMultiplication.matrixChainOrderRecursion(matricesDimensions);
    }

    @Test
    public void testMatrixMultiplicationOrder1() {
        MatrixDimensions[] matricesDimensions = {new MatrixDimensions(5, 10),
                new MatrixDimensions(10, 3),  new MatrixDimensions(3, 12),
                new MatrixDimensions(12, 5), new MatrixDimensions(5, 50),
                new MatrixDimensions(50, 6)};
        ChainMatrixMultiplication.printMatrixParenthesis(matricesDimensions);
    }

    @Test
    public void testMatrixMultiplication() {
        MatrixDimensions[] matricesDimensions = {new MatrixDimensions(2, 4),
                new MatrixDimensions(4, 2)};
        matricesDimensions[0].matrix = new int[][]{{1,2, 3, 4}, {5, 6, 7, 8}};
        matricesDimensions[1].matrix = new int[][]{{1,2}, {3,4}, {5,6}, {7,8} };

        int[][] resultMatrix = ChainMatrixMultiplication.multiplyMatrix(matricesDimensions);
        for(int i=0; i<resultMatrix.length; i++) {
            for(int j=0; j<resultMatrix[i].length; j++) {
                System.out.print(resultMatrix[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
