package com.samples.crls.practice;

import java.util.HashMap;
import java.util.Map;

public class Practice {

    public static String matrixMultiplicationParenthesisUsingRecursion(MatrixDimension[] matrixDimensions) {
        matrixMultiplicationParenthesisUsingRecursionInternal(matrixDimensions,
                0, matrixDimensions.length-1);
        return null;
    }

    private static int matrixMultiplicationParenthesisUsingRecursionInternal(
            MatrixDimension[] matrixDimensions, int startIndex, int endIndex) {
        System.out.println("Start  "+ startIndex + " endIndex "+ endIndex);
        if (endIndex - startIndex ==  0) {
            System.out.println("Column  " + matrixDimensions[startIndex].columns);
            return matrixDimensions[startIndex].columns;
        }
        int productOfDimensions = Integer.MAX_VALUE;
        for (int count = startIndex; count < endIndex; count++) {
            System.out.println("In the for loop.....startIndex   "+startIndex );
            productOfDimensions =
            Math.min(productOfDimensions, matrixMultiplicationParenthesisUsingRecursionInternal(matrixDimensions, startIndex, count)
                    * matrixMultiplicationParenthesisUsingRecursionInternal(matrixDimensions, count + 1, endIndex ));
        }
        return productOfDimensions;
    }

    public static int[][] matrixMultiplication(int[][] matrix1, int[][]  matrix2) {
        //Basic check for matrix multiplication
        for(int rows = 0; rows < matrix1.length; rows++) {
            if (matrix1[rows].length != matrix2.length) {
                throw new IllegalArgumentException("Column length of first matrix should be equal to row length");
            }
        }
        //Rows of Matrix 1 and columns of Matrix 2
        int[][] resultMatrix = new int[matrix1.length][matrix2[0].length];
        //Matrix multiplication
        for( int m1Rows=0; m1Rows < matrix1.length; m1Rows++ ) {
            for( int m2Columns=0; m2Columns < matrix2[m1Rows].length; m2Columns++ ) {
                int sumOfACell = 0;
                for(int m1Columns = 0; m1Columns < matrix1[m1Rows].length; m1Columns++) {
                    //Columns in matrix 1 = rows of matrix2
                    sumOfACell = sumOfACell + matrix1[m1Rows][m1Columns] * matrix2[m1Columns][m2Columns];
                }
                resultMatrix[m1Rows][m2Columns] = sumOfACell;
            }
        }

        return resultMatrix;
    }

    public static int getMaxRevenueForRodLengthRegression(RodAttributes[] rodAttributes, int rodLength) {
        if( rodLength == 0) {
            return 0;
        }
        int revenue = Integer.MIN_VALUE;
        for(int count=1; count<= rodLength; count++) {
            revenue = Math.max(revenue, rodAttributes[count -1].profit + getMaxRevenueForRodLengthRegression(rodAttributes, rodLength -count));
        }
        return revenue;
    }

    //Roughly n-square times. When n=4 then time complexity = 17
    public static int getMaxRevenueForRodLengthTopDownMemoization(RodAttributes[] rodAttributes, int rodLength) {
        Map<Integer, Integer> cache = new HashMap<>();
        //Base condition values
        cache.put(0, 0);
        return getMaxRevenueForRodLengthTopDownMemoizationInternal(rodAttributes, rodLength, cache);

    }

    private static int getMaxRevenueForRodLengthTopDownMemoizationInternal(RodAttributes[] rodAttributes,
                                                                          int rodLength, Map<Integer, Integer> cache) {
        //Return from cache
        if(cache.get(rodLength)  != null) {
            System.out.println("Rodlength from cache " + rodLength +  " profit "+ cache.get(rodLength));
            return cache.get(rodLength);
        }

        int revenue = Integer.MIN_VALUE;
        for(int count=1; count<= rodLength; count++) {
            System.out.println("Rodlength " + rodLength +  " Count "+ count);
            revenue = Math.max(revenue, rodAttributes[count -1].profit +
                    getMaxRevenueForRodLengthTopDownMemoizationInternal(rodAttributes, rodLength -count, cache));
        }
        cache.put(rodLength, revenue);
        System.out.println(cache);

        return revenue;
    }

    //Roughly n-square times. Additional n+1 units of storage
    public static int getMaxRevenueForRodLengthBottomUp(RodAttributes[] rodAttributes, int rodLength) {
        int[] table = new int[rodLength + 1];
        //Base condition
        table[0] = 0;
        int revenue = Integer.MIN_VALUE;
        //Go from 1...rod length
        for(int count = 1; count <= rodLength; count ++) {
            revenue = rodAttributes[count -1].profit;
            //The profit table is indexed from 0
            //If we take rod length as 2
            //Then this how the iteration works
            //1 as 2 due to indexing starting from 0.
            //profit_step_1 = max(profit[1], table[0] + profit[1])
            //max(profit_step_1, table[1] + profit[0])
            for(int j = 0; j < count; j++) {
                revenue = Math.max(revenue, table[j] + rodAttributes[count - j -1].profit);
            }
            table[count] = revenue;
        }
        return table[rodLength];

    }

    public static RodSolution[] getSoultionForRodCuttingWithTopdown(RodAttributes[] rodAttributes, int rodLength) {
        RodSolution[] solution = new RodSolution[rodLength + 1];
        //Base condition
        solution[0] = new RodSolution(0, 0);
        int revenue;
        //Go from 1...rod length
        for(int count = 1; count <= rodLength; count ++) {
            revenue = Integer.MIN_VALUE;
            //The profit table is indexed from 0
            //If we take rod length as 2
            //Then this how the iteration works
            //1 as 2 due to indexing starting from 0.
            //profit_step_1 = max(profit[1], table[0] + profit[1])
            //max(profit_step_1, table[1] + profit[0])
            for(int j = 0; j < count; j++) {
                if(revenue < solution[j].revenue + rodAttributes[count - j -1].profit) {
                    revenue = solution[j].revenue + rodAttributes[count - j -1].profit;
                    solution[count] = new RodSolution( revenue, count - j );
//                    solution[count].revenue = revenue;
//                    solution[count].rodLength = j;
                }

            }
        }
        return solution;

    }

    public static int getFibonacciNumberRecursion(int n) {
        //base case
        if(n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        return getFibonacciNumberRecursion(n -1) + getFibonacciNumberRecursion(n-2);
    }

    public static int getFibonacciNumberMemoization(int n) {
        if(n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        Map<Integer, Integer> cache = new HashMap<>();
        //Base condition
        cache.put(0, 0);
        cache.put(1, 1);
        return getFibonacciNumberMemoizationInternal(n, cache);
    }

    private static int getFibonacciNumberMemoizationInternal(int n, Map<Integer, Integer> cache) {
        //Return from cache for both cases and repeated sub-problems solutions.
        if(cache.get(n) != null) {
            return cache.get(n);
        }
        int value = getFibonacciNumberMemoizationInternal(n -1, cache) +
                getFibonacciNumberMemoizationInternal(n -2, cache);
        cache.put(n, value);
        return value;
    }

    public static int getFibonacciNumberBottomup(int n) {
        //base case
        int[] table = new int[n + 1];
        //base cases
        table[0] = 0;
        table[1] = 1;
        for(int counter =2 ; counter <= n; counter++) {
            table[counter] = table[counter -1] + table[counter -2];
        }
        return table[n];
    }
}
