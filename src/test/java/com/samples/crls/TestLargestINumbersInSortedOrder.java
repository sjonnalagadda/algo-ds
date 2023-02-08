package com.samples.crls;

import com.samples.LargestINumbersWorstLinearTIme;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestLargestINumbersInSortedOrder {

    @Test
    public void testILargerNumbersUsingMergeSort() {
        int[] input = {5, 6,  7,  1, 4, 3, 2};
        int[] expected = {5, 6, 7};
        int[] output = LargestINumbersInSortedOrder.getILargestElements(input, 3);
        for(int i=0; i< output.length; i++) {
            Assertions.assertEquals(expected[i], output[i]);
        }
    }

    @Test
    public void testILargerNumbersUsingHeapExtractMax() {
        int[] input = {5, 6,  7,  1, 4, 3, 2};
        int[] output = new int[3];
        int[] expected = {5, 6, 7};
        LargestINumbersMaxHeap largestINumbersMaxHeap = new LargestINumbersMaxHeap(input);
        for(int index = expected.length -1; index >= 0; index--) {
            output[index]= largestINumbersMaxHeap.extractMax();
        }
        for(int i=0; i< output.length; i++) {
            Assertions.assertEquals(expected[i], output[i]);
        }
    }

    @Test
    public void testILargerNumbersUsingQuickSelect() {
        int[] input = {5, 6,  7,  1, 4, 3, 2};
        int[] expected = {5, 6, 7};
        int[] output = new LargestINumbersWorstLinearTIme(input).getIMaxElementLinearTime( 3);
        for(int i=0; i< output.length; i++) {
            Assertions.assertEquals(expected[i], output[i]);
        }
    }

}
