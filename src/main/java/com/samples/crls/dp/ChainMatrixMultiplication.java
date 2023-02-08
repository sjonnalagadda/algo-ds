package com.samples.crls.dp;

public class ChainMatrixMultiplication {


    static void printMatrixParenthesis(MatrixDimensions[] matricesDimensions) {
        MatrixResult matrixResult = getMatrixMultiplicationOrder(matricesDimensions);
        printInternal(matrixResult.solutionTable, 0, matricesDimensions.length -1);

    }

    private static void printInternal(int[][] solutionTable, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            System.out.print("A"+(startIndex+1));
        } else {
            System.out.print("(");
            printInternal(solutionTable, startIndex, solutionTable[startIndex][endIndex]);
            printInternal(solutionTable, solutionTable[startIndex][endIndex] + 1, endIndex);
            System.out.print(")");
        }

    }

    private static MatrixResult getMatrixMultiplicationOrder(MatrixDimensions[] matricesDimensions) {
        MatrixResult matrixResult = new MatrixResult(matricesDimensions.length);
        for(int i=0; i<matricesDimensions.length;i++) {
            matrixResult.multiplicationCountTable[i][i] = 0;
        }
        for(int column=1; column<matricesDimensions.length; column++) {
           for(int row = 0; row <= matricesDimensions.length - column -1; row++ ) {
               int subMatrixEndERange = row  + column;
               //Set it negative number
               matrixResult.multiplicationCountTable[row][subMatrixEndERange] = Integer.MAX_VALUE;
               for(int k = row; k < subMatrixEndERange; k++) {
                   int cost = matrixResult.multiplicationCountTable[row][k] + matrixResult.multiplicationCountTable[k + 1][subMatrixEndERange] +
                           (matricesDimensions[row].rows * matricesDimensions[k].columns * matricesDimensions[subMatrixEndERange].columns);
                   if(cost < matrixResult.multiplicationCountTable[row][subMatrixEndERange]) {
                       matrixResult.multiplicationCountTable[row][subMatrixEndERange] = cost;
                       matrixResult.solutionTable[row][subMatrixEndERange] = k;
                   }
               }
               //when multiplying just two matrices, there is no min
           }
        }
        return matrixResult;
    }

    static int[][] multiplyMatrix(MatrixDimensions[] matricesDimensions) {
        MatrixResult matrixResult = getMatrixMultiplicationOrder(matricesDimensions);
        return multiplyMatrixInternal(matrixResult.solutionTable, matricesDimensions, 0, matricesDimensions.length -1);
    }

    static int[][] multiplyMatrixInternal(int[][] solutionTable, MatrixDimensions[] matricesDimensions, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            return matricesDimensions[startIndex].matrix;
        } else if(startIndex + 1 == endIndex) {
            return multiplyMatrix(matricesDimensions[startIndex].matrix, matricesDimensions[endIndex].matrix);
        } else {
            int[][] resultMatrix1 = multiplyMatrixInternal(solutionTable, matricesDimensions, startIndex, solutionTable[startIndex][endIndex]);
            int[][] resultMatrix2 =  multiplyMatrixInternal(solutionTable, matricesDimensions, solutionTable[startIndex][endIndex] + 1, endIndex);
            return multiplyMatrix(resultMatrix1,  resultMatrix2);
        }
    }

    private static int[][] multiplyMatrix(int[][] matrixA, int[][] matrixB) {
        if(matrixA[0].length != matrixB.length) {
            throw new RuntimeException("Column length of Matrix A should be same as Row length of  Matrix B");
        }
        int[][] resultMatrix = new int[matrixA.length][matrixB[0].length];
        for(int i=0; i<matrixA.length; i++) {
            for(int j=0; j<matrixB[i].length; j++) {
                resultMatrix[i][j] = 0;
                for(int k =0; k< matrixA[i].length; k++) {
                    resultMatrix[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        return resultMatrix;
    }

    /**
     * Big-O (2 power (n-1)).
     * @return
     */
    static MatrixResult matrixChainOrderRecursion(MatrixDimensions[] matricesDimensions) {
        MatrixResult matrixResult = new MatrixResult(matricesDimensions.length);
        matrixChainOrderRecursionInternal(matricesDimensions, matrixResult,
                0, matricesDimensions.length -1);
        printInternal(matrixResult.solutionTable, 0, matricesDimensions.length -1);
        return  matrixResult;
    }


    private static int matrixChainOrderRecursionInternal(MatrixDimensions[] matricesDimensions, MatrixResult matrixResult,
                                                    int startIndex, int endIndex ) {
        if (startIndex == endIndex) {
            return 0;
        }
        matrixResult.multiplicationCountTable[startIndex][endIndex] = Integer.MAX_VALUE;
        for(int k = startIndex; k < endIndex; k++) {
            int q = matrixChainOrderRecursionInternal(matricesDimensions, matrixResult, startIndex, k)
                    + matrixChainOrderRecursionInternal(matricesDimensions, matrixResult, k + 1, endIndex) +
                    matricesDimensions[startIndex].rows * matricesDimensions[k].columns * matricesDimensions[endIndex].columns;
            if(q < matrixResult.multiplicationCountTable[startIndex][endIndex]) {
                matrixResult.multiplicationCountTable[startIndex][endIndex] = q;
                matrixResult.solutionTable[startIndex][endIndex] = k;
            }
        }
        return matrixResult.multiplicationCountTable[startIndex][endIndex];
    }

    /**
     * Big-O (Order of n cubed.).
     * @return
     */
    static MatrixResult matrixChainOrderWithMemoization(MatrixDimensions[] matricesDimensions) {
        MatrixResult matrixResult = new MatrixResult(matricesDimensions.length);
        for(int i = 0; i <matricesDimensions.length; i++) {
            for(int j = 0; j<matricesDimensions.length; j++) {
                matrixResult.multiplicationCountTable[i][j] = Integer.MAX_VALUE;
            }
        }
        matrixChainOrderRecursionWithMemoizationInternal(matricesDimensions, matrixResult,
                0, matricesDimensions.length -1);
        printInternal(matrixResult.solutionTable, 0, matricesDimensions.length -1);

        return  matrixResult;
    }

    private static int matrixChainOrderRecursionWithMemoizationInternal(MatrixDimensions[] matricesDimensions,
                                                                        MatrixResult matrixResult,
                                                         int startIndex, int endIndex ) {
        if(matrixResult.multiplicationCountTable[startIndex][endIndex] < Integer.MAX_VALUE) {
            return matrixResult.multiplicationCountTable[startIndex][endIndex];
        }
        if(startIndex == endIndex) {
            return 0;
        } else {
            for(int k = startIndex; k< endIndex; k++) {
                int q = matrixChainOrderRecursionWithMemoizationInternal(matricesDimensions, matrixResult, startIndex, k)
                        + matrixChainOrderRecursionWithMemoizationInternal(matricesDimensions, matrixResult, k + 1, endIndex) +
                        matricesDimensions[startIndex].rows * matricesDimensions[k].columns *
                                matricesDimensions[endIndex].columns;
                if(q < matrixResult.multiplicationCountTable[startIndex][endIndex]) {
                    matrixResult.multiplicationCountTable[startIndex][endIndex] = q;
                    matrixResult.solutionTable[startIndex][endIndex] = k;
                }
            }
        }
        return matrixResult.multiplicationCountTable[startIndex][endIndex];
    }
}
