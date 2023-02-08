package com.samples.crls;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCountingSort {

    @Test
    public void testCountingSort() {
        int[] input =  {2, 5, 3, 0, 2, 3, 0, 3};
        int[] output = {0, 0, 2, 2, 3, 3, 3, 5};
        CountingSort.countingSort(input, 5);
        for(int i=0; i< input.length; i++) {
            Assertions.assertEquals(input[i], output[i]);
        }
    }

    @Test
    public void testHIndex() {
        int[] citations = {3,0,6,1,5};
        Assertions.assertEquals(3, CountingSort.hIndex(citations));
    }

    @Test
    public void testSplitZerosAndOnes() {
        int[] input = {0, 1, 0, 1, 0, 1};
        int [] expectedOutput = {0, 0, 0, 1, 1, 1};
        CountingSort.splitZerosAndOnes(input);
        for(int i=0;i<input.length;i ++) {
            Assertions.assertEquals(expectedOutput[i], input[i]);
        }
    }
}
