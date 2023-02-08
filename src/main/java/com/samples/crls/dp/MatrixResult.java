package com.samples.crls.dp;

public class MatrixResult {
    int[][] multiplicationCountTable;
    int[][] solutionTable;

    MatrixResult(int numberOfMatrices) {
        multiplicationCountTable = new int[numberOfMatrices][numberOfMatrices];
        solutionTable = new int[numberOfMatrices][numberOfMatrices];
    }

}
