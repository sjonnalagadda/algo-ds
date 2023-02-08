package com.samples.crls;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TestMediansAndOrderStatistics {

    @Test
    public void testForMinimum() {
        int[] input = {4,7,1,2,6,5};
        Assertions.assertEquals(1, MediansAndOrderStatistics.minimum(input));
    }

    @Test
    public void testForMaximum() {
        int[] input = {4,7,1,2,6,5};
        Assertions.assertEquals(7, MediansAndOrderStatistics.maximum(input));
    }

    @Test
    public void testFIndMaximumMinimumSimultaneously() {
        int[] input = {4,7,1,2,6,5};
        int[] output = MediansAndOrderStatistics.findSimulataneousMinAndMax(input);
        Assertions.assertEquals(1,output[0]);
        Assertions.assertEquals(7,output[1]);
    }

    @Test
    public void testFindIthSmallest() {
        int[] input = {4,7,1,2,6,5};
        int ithSmallestValue = MediansAndOrderStatistics.findIthSmallestElement(input, 3);
        Assertions.assertEquals(4,ithSmallestValue);
    }

    @Test
    public void testFindIthSmallestInLinearTIme() {
        int[] input = {4,7,1,2,6,5};
        int ithSmallestValue = MediansAndOrderStatistics.findIthSmallestElementInLinearTime(input, 3);
        Assertions.assertEquals(4,ithSmallestValue);
    }

    @Test
    public void testFindIthSmallestInLinearTImeForLargerNumbers() {
        int[] input = {4, 7, 1, 2, 3, 5, 6, 9, 8, 10, 12, 11, 13, 16, 15, 14, 20,18, 19, 17, 21};
        int ithSmallestValue = MediansAndOrderStatistics.findIthSmallestElementInLinearTime(input, 13);
        Assertions.assertEquals(13, ithSmallestValue);
    }

    @Test
    public void testFindIthSmallestInLinearTImeForLargerNumbers2() {
        int[] input = {4, 7, 1, 2, 3, 5, 6, 9, 8, 10, 12, 11, 13, 16, 15, 14, 20,18, 19, 17, 21};
        int ithSmallestValue = MediansAndOrderStatistics.findIthSmallestElementInLinearTime(input, 13);
        Assertions.assertEquals(15, ithSmallestValue);
    }

    @Test
    public void testUsingRandomizedQuickSort() {
        int[] input = {5, 2, 4, 6, 1, 3};
        int [] expectedOutput = {1, 2, 3, 4, 5, 6};
        MediansAndOrderStatistics.randomizedQuickSort(input);
        for(int i=0;i<input.length;i ++) {
            Assertions.assertEquals(expectedOutput[i], input[i]);
        }
    }

    @Test
    public void testKQuantiles() {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        MediansAndOrderStatistics.kQuantiles(input, 8);
    }

    @Test
    public void testKQuantilesNotSorted() {
        int[] input = {8, 7, 6, 5, 4, 3, 2, 1, 16, 15, 14, 13, 12, 11, 10, 9};
        System.out.println(Arrays.toString(MediansAndOrderStatistics.kQuantiles(input, 8)));
    }

    @Test
    public void testKQuantilesAsGroupOfFour() {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        System.out.println( Arrays.toString(MediansAndOrderStatistics.kQuantiles(input, 4)));
    }

    @Test
    public void testKQuantilesAsGroupOfFThree() {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println( Arrays.toString(MediansAndOrderStatistics.kQuantiles(input, 3)));
    }

    @Test
    public void testFindIthSmallestInLinearTImeForLargerNumbers3() {
        int[] input = {3, 2, 1, 7, 6, 5, 4, 9, 8, 12, 11, 10, 14, 13, 16, 15};
        int ithSmallestValue = MediansAndOrderStatistics.findIthSmallestElement(input, 8);
        Assertions.assertEquals(8, ithSmallestValue);
    }

    @Test
    public void testNearToMedian() {
        int[] input = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(MediansAndOrderStatistics.nearToMedian(input, 3)));
    }

    @Test
    public void testMedianOfTwoSortedArrays() {
        int[] leftArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] rightArray = {11, 12, 13, 14, 15, 16, 17, 18, 19};
        Assertions.assertEquals(9, MediansAndOrderStatistics.medianOfTwoSortedArrays(leftArray, rightArray));
    }

    @Test
    public void testMedianOfTwoSortedArraysEvens() {
        int[] leftArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] rightArray = {11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        Assertions.assertEquals(10, MediansAndOrderStatistics.medianOfTwoSortedArrays(leftArray, rightArray));
    }

    @Test
    public void testMedianOfTwoSortedArrays1() {
        int[] leftArray = {11, 12, 13, 14, 15, 16, 17, 18, 19};
        int[] rightArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Assertions.assertEquals(9, MediansAndOrderStatistics.medianOfTwoSortedArrays(leftArray, rightArray));
    }


    private void printDetails(int[] input, int k) {
        int num = input.length / k;
        int mod = input.length % k;
        int position[] = new int[k];
        for(int i=0; i < mod; i++) {
            position[i] = position[i] + 1;
        }
        for(int i=0; i < k; i++) {
            position[i] = position[i] + 1;
        }

    }

    @Test
    public void mathTest() {
        System.out.println(Math.ceil(7/2));
        System.out.println(Math.floor(7/2));
        System.out.println(Math.round(7/2));
    }
}
