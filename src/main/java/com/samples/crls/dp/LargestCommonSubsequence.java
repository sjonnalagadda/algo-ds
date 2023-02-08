package com.samples.crls.dp;


import java.util.Stack;

public class LargestCommonSubsequence {

    public static int lcsRecursion( String firstInput, String secondInput) {
        return lcsRecursionInternal(0, 0, firstInput, secondInput);
    }
    private static int lcsRecursionInternal(int firstInputIndex, int secondInputIndex, String firstInput, String secondInput) {
        if(firstInputIndex == firstInput.length()  || secondInputIndex == secondInput.length()) {
            return 0;
        } else if(firstInput.charAt(firstInputIndex) == secondInput.charAt(secondInputIndex)) {
            return 1 + lcsRecursionInternal(firstInputIndex + 1, secondInputIndex + 1, firstInput, secondInput);
        } else {
            return Math.max(lcsRecursionInternal(firstInputIndex + 1, secondInputIndex, firstInput, secondInput),
                    lcsRecursionInternal(firstInputIndex, secondInputIndex + 1, firstInput, secondInput));
        }
    }

    public static int lcsRecursionUsingMemoization( String firstInput, String secondInput) {
        final int[][] lcsTable = new int[firstInput.length() + 1][secondInput.length() + 1];
        for(int i =0; i <lcsTable.length; i++) {
            for(int j = 0; j < lcsTable[i].length; j++) {
                lcsTable[i][j] = -1;
            }
        }
        return lcsRecursionInternalUsingMemoization(0, 0, firstInput, secondInput, lcsTable);
    }
    private static int lcsRecursionInternalUsingMemoization(int firstInputIndex, int secondInputIndex, String firstInput, String secondInput,int[][] lcsTable) {
        if(lcsTable[firstInputIndex][secondInputIndex] > -1) {
            return lcsTable[firstInputIndex][secondInputIndex];
        }
        if(firstInputIndex == firstInput.length()  || secondInputIndex == secondInput.length()) {
            return lcsTable[firstInputIndex][secondInputIndex] = 0;
        }
        if(firstInput.charAt(firstInputIndex) == secondInput.charAt(secondInputIndex)) {
          return lcsTable[firstInputIndex][secondInputIndex] =  1 + lcsRecursionInternalUsingMemoization(firstInputIndex + 1, secondInputIndex + 1, firstInput, secondInput, lcsTable);
        } else {
            return lcsTable[firstInputIndex][secondInputIndex] =Math.max(lcsRecursionInternalUsingMemoization(firstInputIndex + 1, secondInputIndex, firstInput, secondInput, lcsTable),
                    lcsRecursionInternalUsingMemoization(firstInputIndex, secondInputIndex + 1, firstInput, secondInput, lcsTable));
        }
    }

    public static int lcsUsingBottomUp( String firstInput, String secondInput) {
        final int[][] lcsTable = new int[firstInput.length() + 1][secondInput.length() + 1];
        lcsInternalUsingBottomUp( firstInput, secondInput, lcsTable);
        return lcsTable[firstInput.length()][secondInput.length()];
    }

    private static void lcsInternalUsingBottomUp(String firstInput, String secondInput, int[][] lcsTable) {
        for(int i = 0; i<=firstInput.length(); i++) {
            lcsTable[i][0] = 0;
        }
        for(int j = 0; j <= secondInput.length(); j++) {
            lcsTable[0][j] = 0;
        }
        for(int i=1; i<= firstInput.length(); i++) {
            for(int j =1; j <= secondInput.length(); j++) {
                if(firstInput.charAt(i-1) == secondInput.charAt(j-1)) {
                    lcsTable[i][j] = 1 + lcsTable[i-1][j -1];
                } else {
                    lcsTable[i][j] = Math.max(lcsTable[i-1][j], lcsTable[i][j -1]);
                }
            }
        }
    }

    public static String printlcs( String firstInput, String secondInput) {
        final int[][] lcsTable = new int[firstInput.length() + 1][secondInput.length() + 1];
        lcsInternalUsingBottomUp( firstInput, secondInput, lcsTable);
        int i = firstInput.length();
        int j = secondInput.length();
        //There is largest common subsequence
        if(lcsTable[firstInput.length()][secondInput.length()] > 0) {
            Stack<Character> stack = new Stack<>();
            while ( i >0 && j > 0) {
                if (lcsTable[i-1][j-1] +1 == lcsTable[i][j]) {
                    stack.push(firstInput.charAt(i -1));
                    i = i -1;
                    j = j -1;
                } else if(lcsTable[i-1][j] == lcsTable[i][j]) {
                    i = i -1;
                } else {
                    j = j -1;
                }
            }
            StringBuilder sb = new StringBuilder();
            while(!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            return sb.toString();
        } else {
            return "";
        }

    }
}
