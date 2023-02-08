package com.samples.crls.dp;

public class MatrixDimensions {
    int rows;
    int columns;
    int[][] matrix;

    MatrixDimensions(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.matrix =  new int[rows][columns];
    }
}
