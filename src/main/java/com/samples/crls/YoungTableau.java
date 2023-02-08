package com.samples.crls;

public class YoungTableau {

    private static final int UNFILLED_CELL_VAL = Integer.MAX_VALUE;
    private int[][] youngTableau;
    private int rows;
    private int columns;

    public YoungTableau(int rows, int columns) {
        this.youngTableau = new int[rows][columns];
        this.rows = rows -1;
        this.columns = columns -1;
        for(int rowNumber =0; rowNumber <= this.rows; rowNumber++) {
            for(int colNumber=0; colNumber <= this.columns; colNumber++) {
                this.youngTableau[rowNumber][colNumber] = UNFILLED_CELL_VAL;
            }
        }
    }

    public int extractMin() {
        if(this.youngTableau[0][0] == UNFILLED_CELL_VAL) {
            throw new IllegalStateException("Young Tableau is not filled");
        }
        return extractMin(0, 0);
    }

    public int extractMin(int rowNumber, int columnNumber) {
        int min = this.youngTableau[rowNumber][columnNumber];
        //Look ahead for unfilled rows. don't venture into unfilled territory. Kind of base case.
        if((rowNumber == this.rows && columnNumber == this.columns) ||
                (rowNumber == this.rows && this.youngTableau[rowNumber][columnNumber+1] == UNFILLED_CELL_VAL) ||
                (columnNumber == this.columns && this.youngTableau[rowNumber + 1][columnNumber] == UNFILLED_CELL_VAL) ||
                (this.youngTableau[rowNumber+1][columnNumber] == UNFILLED_CELL_VAL &&
                (columnNumber+1 <= this.columns && this.youngTableau[rowNumber][columnNumber+1] == UNFILLED_CELL_VAL))) {
            this.youngTableau[rowNumber][columnNumber] = UNFILLED_CELL_VAL;
            return min;
        }
        if (columnNumber + 1 <= this.columns && rowNumber + 1 <= this.rows &&
                this.youngTableau[rowNumber][columnNumber + 1]
                <=  this.youngTableau[rowNumber + 1][columnNumber]) { // row, column + 1;
            //Swap
            this.youngTableau[rowNumber][columnNumber] = this.youngTableau[rowNumber][columnNumber + 1];
            this.youngTableau[rowNumber][columnNumber + 1] = min;
            return extractMin(rowNumber, columnNumber + 1);
        } else { //row + 1, column
            //Swap
            this.youngTableau[rowNumber][columnNumber] = this.youngTableau[rowNumber + 1][columnNumber];
            this.youngTableau[rowNumber + 1][columnNumber] = min;
            return extractMin(rowNumber + 1, columnNumber);
        }
    }

    void feedData(int rowNumber, int columnNumber, int value) {
        this.youngTableau[rowNumber][columnNumber] = value;
    }

}
