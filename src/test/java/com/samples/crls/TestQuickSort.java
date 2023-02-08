package com.samples.crls;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestQuickSort {

    @Test
    public void testQuickSortUsingLomutoPartition() {
        int[] input = {5, 2, 4, 6, 1, 3};
        int [] expectedOutput = {1, 2, 3, 4, 5, 6};
        QuickSort.quickSortLomuto(input);
        for(int i=0;i<input.length;i ++) {
            Assertions.assertEquals(expectedOutput[i], input[i]);
        }
    }

    @Test
    public void testSplitZerosAndOnes() {
        int[] input = {0, 1, 0, 1, 0, 1};
        int [] expectedOutput = {1, 1, 1, 0, 0, 0};
        QuickSort.splitZerosAndOnes(input);
        for(int i=0;i<input.length;i ++) {
            Assertions.assertEquals(expectedOutput[i], input[i]);
        }
    }

    @Test
    public void testQuickSortWithTailRecursion() {
        int[] input = {5, 2, 4, 6, 1, 3};
        int [] expectedOutput = {1, 2, 3, 4, 5, 6};
        QuickSort.quickSortWithTailRecursion(input);
        for(int i=0;i<input.length;i ++) {
            Assertions.assertEquals(expectedOutput[i], input[i]);
        }
    }

    @Test
    public void testQuickSortUsingHoaresPartition() {
        int[] input = {2, 8, 7, 1, 3, 5, 6, 4};
        int [] expectedOutput = {1, 2, 3, 4, 5, 6, 7, 8};
        QuickSort.quickSortHoares(input);
        for(int i=0;i<input.length;i ++) {
            Assertions.assertEquals(expectedOutput[i], input[i]);
        }
    }

    @Test
    public void mergeTwoSortedArrays() {
        int[] arr1 = {1, 4, 7, 9};
        int[] arr2 = {2, 3, 5, 6, 8, 0, 0, 0, 0};

        int firstArrayElementMaxIndex = arr1.length - 1;
        int secondArrayMaxIndex = arr2.length  - arr1.length -1 ;
        int finished  = arr2.length -1;

        while (firstArrayElementMaxIndex >= 0 && secondArrayMaxIndex >= 0) {
            arr2[finished--] = (arr1[firstArrayElementMaxIndex] > arr2[secondArrayMaxIndex]) ?
                    arr1[firstArrayElementMaxIndex--] : arr2[secondArrayMaxIndex--];
        }

        while (firstArrayElementMaxIndex >= 0) { //only need to combine with remaining nums2, if any
            arr2[finished--] = arr1[firstArrayElementMaxIndex--];
        }
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        for(int i=0; i< expected.length; i++) {
            Assertions.assertEquals(expected[i], arr2[i]);
        }
    }

    @Test
    public void createSortedArrayOfSqauredArray() {
       int[] expected = {100, 100, 400, 400, 625, 900};
       int[] actual = QuickSort.squareOfSortedArray(new int[]{-30, -20, -10, 10, 20, 25});
        for(int i=0; i<expected.length; i++) {
            Assertions.assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void createSortedArrayOfSqauredArray2() {
        int[] expected = {0,1,9,16,100};
        int[] actual = QuickSort.squareOfSortedArray(new int[]{-4,-1,0,3,10});
        for(int i=0; i<expected.length; i++) {
            Assertions.assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void testGroupingEvenOddNumber() {
        int[] expected = {1, 5, 3, 4, 2, 6};
        int[] input = {1, 2, 3, 4, 5, 6};
        QuickSort.groupTheNumbersEvenAndOdd(input);
        for(int i=0; i<expected.length; i++) {
            Assertions.assertEquals(expected[i], input[i]);
        }
    }

    @Test
    public void testDutchNationalProblem() {
        char[] expected = {'R', 'R', 'G', 'G', 'G', 'G', 'B', 'B'};
        char[] input =    {'G', 'B', 'G', 'G', 'R', 'B', 'R', 'G'};
        QuickSort.dutchNationalFlagProblem(input);
        for(int i=0; i<expected.length; i++) {
            Assertions.assertEquals(expected[i], input[i]);
        }
    }
}
