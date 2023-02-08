package com.samples.crls.practice;

import org.junit.jupiter.api.Test;

public class TestPractice {

    @Test
    public void testPractice() {
        System.out.println(Practice.getFibonacciNumberRecursion(6));
    }

    @Test
    public void testPracticeMemoization() {
        System.out.println(Practice.getFibonacciNumberMemoization(6));
    }

    @Test
    public void testPracticeBottomup() {
        System.out.println(Practice.getFibonacciNumberBottomup(6));
    }

    @Test
    public void testRodCuttingRecursion() {
        System.out.println(Practice.getMaxRevenueForRodLengthRegression(createRodCuttingAttributes(), 4));
    }

    @Test
    public void testRodCuttingTopDownMemoization() {
        System.out.println(Practice.getMaxRevenueForRodLengthTopDownMemoization(createRodCuttingAttributes(), 4));
    }

    @Test
    public void testRodCuttingBottomUP() {
        System.out.println(Practice.getMaxRevenueForRodLengthBottomUp(createRodCuttingAttributes(), 4));
    }

    @Test
    public void testRodCuttingBottomUP1() {
        System.out.println(Practice.getMaxRevenueForRodLengthBottomUp(createRodCuttingAttributes(), 7));
    }

    @Test
    public void testRodCuttingBottomUPSolution() {
        int rodLength = 7;
        RodSolution[] solution = Practice.getSoultionForRodCuttingWithTopdown(createRodCuttingAttributes(), rodLength);
        while(rodLength > 0) {
            System.out.println(solution[rodLength].rodLength);
            rodLength = rodLength - solution[rodLength].rodLength;
        }
        rodLength = 4;
        RodSolution[] solution1 = Practice.getSoultionForRodCuttingWithTopdown(createRodCuttingAttributes(), rodLength);
        while(rodLength > 0) {
            System.out.println(solution1[rodLength].rodLength);
            rodLength = rodLength - solution1[rodLength].rodLength;
        }
    }

    @Test
    public void testMatrixMultiplication() {
        int[][] matrix1 = new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        int[][] matrix2 = new int[][]{{2, 2, 2}, {2, 2, 2}, {2, 2, 2}};
        int[][] resultMatrix = Practice.matrixMultiplication(matrix1, matrix2);
        for( int rows = 0; rows < resultMatrix.length; rows++ ) {
            for(int columns = 0; columns < resultMatrix[rows].length; columns++) {
                System.out.print(resultMatrix[rows][columns] + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void testMatrixMultiplication1() {
        int[][] matrix1 = new int[][]{{1, 1}, {2, 2}};
        int[][] matrix2 = new int[][]{{2}, {2}};
        int[][] resultMatrix = Practice.matrixMultiplication(matrix1, matrix2);
        for( int rows = 0; rows < resultMatrix.length; rows++ ) {
            for(int columns = 0; columns < resultMatrix[rows].length; columns++) {
                System.out.print(resultMatrix[rows][columns] + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void testMatrixMultiplicationsParenthesisUsingRecursion() {
        MatrixDimension[] matrixDimensions = new MatrixDimension[]{
                new MatrixDimension(30, 35),
                new MatrixDimension(35, 15),
                new MatrixDimension(15, 5),
                new MatrixDimension(5, 10),
        };
        Practice.matrixMultiplicationParenthesisUsingRecursion(matrixDimensions);
    }

    private static RodAttributes[] createRodCuttingAttributes() {
       return new RodAttributes[] {new RodAttributes(1, 1),
                new RodAttributes(2, 5), new RodAttributes(3, 8),
                new RodAttributes(4, 9), new RodAttributes(5, 10),
                new RodAttributes(6, 17), new RodAttributes(7,17),
                new RodAttributes(8, 20), new RodAttributes(9, 24),
                new RodAttributes(10, 30)};

    }
}
