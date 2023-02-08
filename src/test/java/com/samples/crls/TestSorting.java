package com.samples.crls;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class TestSorting {

    @Test
    public void testInsertionSortAscending() {
        int[] input = {5, 2, 4, 6, 1, 3};
        int [] expectedOutput = {1, 2, 3, 4, 5, 6};
        Sorting.insertionSortAscending(input);
        for(int i=0;i<input.length;i ++) {
            Assertions.assertEquals(expectedOutput[i], input[i]);
        }
    }

    @Test
    public void testInsertionDescending() {
        int[] input = {5, 2, 4, 6, 1, 3};
        int [] expectedOutput = {6,5, 4, 3, 2, 1};
        Sorting.insertionSortDescending(input);
        for(int i=0;i<input.length;i ++) {
            Assertions.assertEquals(expectedOutput[i], input[i]);
        }
    }

    @Test
    public void testSelectionSort() {
        int[] input = {5, 2, 4, 6, 1, 3};
        int [] expectedOutput = {1, 2, 3, 4, 5, 6};
        Sorting.selectionSort(input);
        for(int i=0;i<input.length;i ++) {
            Assertions.assertEquals(expectedOutput[i], input[i]);
        }
    }

    @Test
    public void testMergeSort() {
        int[] input = {5, 2, 4, 6, 1, 3};
        int [] expectedOutput = {1, 2, 3, 4, 5, 6};
        Sorting.mergeSort(input);
        for(int i=0;i<input.length;i ++) {
            Assertions.assertEquals(expectedOutput[i], input[i]);
        }
    }

    @Test
    public void testmergeSortWithDynamic() {
        int[] input = {5, 2, 4, 6, 1, 3};
        int [] expectedOutput = {1, 2, 3, 4, 5, 6};
        Sorting.mergeSortWithDynamicAuxiliarySpace(input);
        for(int i=0;i<input.length;i ++) {
            Assertions.assertEquals(expectedOutput[i], input[i]);
        }
    }

    @Test
    public void testBinarySearch() {
        int[] input = {1};
        Assertions.assertFalse(Sorting.recursiveBinarySearch(input, 2).isPresent());
    }

    @Test
    public void testBinarySearchExists() {
        int[] input = {1};
        Assertions.assertTrue(Sorting.recursiveBinarySearch(input, 1).isPresent());
    }

    @Test
    public void testBinarySearchWithManyInput() {
        int[] input = {1, 2, 3, 4, 5, 6};
        Assertions.assertTrue(Sorting.recursiveBinarySearch(input, 6).isPresent());
    }


    @Test
    public void testIterativeBinarySearch() {
        int[] input = {1};
        Assertions.assertFalse(Sorting.iterativeBinarySearch(input, 2).isPresent());
    }

    @Test
    public void testIterativeBinarySearchExists() {
        int[] input = {1};
        Assertions.assertTrue(Sorting.iterativeBinarySearch(input, 1).isPresent());
    }

    @Test
    public void testIterativeBinarySearchWithManyInput() {
        int[] input = {1, 2, 3, 4, 5, 6};
        Assertions.assertTrue(Sorting.recursiveBinarySearch(input, 6).isPresent());
    }

    @Test
    public void testDetermineTwoElementsForTheSum10() {
        int[] input = {5, 2, 4, 6, 1, 3};
        //int[] afterSorting = {1, 2, 3, 4, 5, 6};
        Optional<SumOfTwoIndexes>  sumOfTwoIndexes = Sorting.determineTwoElementsForTheSum(input, 10);
        Assertions.assertTrue(sumOfTwoIndexes.isPresent());
        Assertions.assertEquals(sumOfTwoIndexes.get().getFirstIndex(), 3);
        Assertions.assertEquals(sumOfTwoIndexes.get().getSecondIndex(), 5);
    }

    @Test
    public void testDetermineTwoElementsForTheSum11() {
        int[] input = {5, 2, 4, 6, 1, 3};
        //int[] afterSorting = {1, 2, 3, 4, 5, 6};
        Optional<SumOfTwoIndexes>  sumOfTwoIndexes = Sorting.determineTwoElementsForTheSum(input, 11);
        Assertions.assertTrue(sumOfTwoIndexes.isPresent());
        Assertions.assertEquals(sumOfTwoIndexes.get().getFirstIndex(), 4);
        Assertions.assertEquals(sumOfTwoIndexes.get().getSecondIndex(), 5);
    }

    @Test
    public void testDetermineTwoElementsForTheSum4() {
        int[] input = {5, 2, 4, 6, 1, 3};
        //int[] afterSorting = {1, 2, 3, 4, 5, 6};
        Optional<SumOfTwoIndexes>  sumOfTwoIndexes = Sorting.determineTwoElementsForTheSum(input, 4);
        Assertions.assertTrue(sumOfTwoIndexes.isPresent());
        Assertions.assertEquals(sumOfTwoIndexes.get().getFirstIndex(), 0);
        Assertions.assertEquals(sumOfTwoIndexes.get().getSecondIndex(), 2);
    }

    @Test
    public void testDetermineTwoElementsForTheSum24() {
        int[] input = {5, 2, 4, 6, 1, 3};
        //int[] afterSorting = {1, 2, 3, 4, 5, 6};
        Optional<SumOfTwoIndexes>  sumOfTwoIndexes = Sorting.determineTwoElementsForTheSum(input, 24);
        Assertions.assertFalse(sumOfTwoIndexes.isPresent());
    }

    @Test
    public void testBubbleSort() {
        int[] input = {5, 2, 4, 6, 1, 3};
        int [] expectedOutput = {1, 2, 3, 4, 5, 6};
        Sorting.bubbleSort(input);
        for(int i=0;i<input.length;i ++) {
            Assertions.assertEquals(expectedOutput[i], input[i]);
        }
    }

    @Test
    public void testInversions() {
        int[] input = {2, 3, 8, 6, 1};
        // i < j and a[i] > a[j]
        //(2,1), (3,1), (8,6), (8,1), (6,1)
        int inversionCount = Sorting.calculateInversions(input);
        Assertions.assertEquals(5, inversionCount);
    }

    @Test
    public void testInversionsSecondExample() {
        int[] input = {5, 2, 4, 6, 1, 3};
        // i < j and a[i] > a[j]
        // (5, 2), (5, 4), (5, 1), (5, 3)
        // (2, 1)
        // (4, 1), (4, 3)
        // (6, 1), (6, 3)
        int inversionCount = Sorting.calculateInversions(input);
        Assertions.assertEquals(9, inversionCount);
    }
}
