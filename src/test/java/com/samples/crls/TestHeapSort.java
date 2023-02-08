package com.samples.crls;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestHeapSort {

    @Test
    public void testMaxHeapify() {
        int[] input = {16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
        Heapsort.maxHeapify(input, input.length, 2);
        Assertions.assertEquals(input[8], 4);
        Assertions.assertEquals(input[3], 8);
        Assertions.assertEquals(input[1], 14);
    }

    @Test
    public void testMaxHeapifyWithoutRecursion() {
        int[] input = {16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
        Heapsort.maxHeapifyWithoutRecursion(input, input.length, 2);
        Assertions.assertEquals(input[8], 4);
        Assertions.assertEquals(input[3], 8);
        Assertions.assertEquals(input[1], 14);
    }

    @Test
    public void testMinHeapify() {
        int[] input = {16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
        Heapsort.minHeapify(input, input.length,3);
        Assertions.assertEquals(input[6], 10);
        Assertions.assertEquals(input[2], 16);
        Assertions.assertEquals(input[0], 3);
    }


    @Test
    public void testBuildMaxHeapify() {
        int[] input = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        Heapsort.buildMaxHeap(input);
        Assertions.assertEquals(input[0], 16);
        Assertions.assertEquals(input[1], 14);
        Assertions.assertEquals(input[2], 10);
        Assertions.assertEquals(input[3], 8);
        Assertions.assertEquals(input[4], 7);
        Assertions.assertEquals(input[5], 9);
        Assertions.assertEquals(input[6], 3);
        Assertions.assertEquals(input[7], 2);
        Assertions.assertEquals(input[8], 4);
        Assertions.assertEquals(input[9], 1);
    }

    @Test
    public void testBuildMinHeapify() {
        int[] input = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        Heapsort.buildMinHeap(input);
        Assertions.assertEquals(input[0], 1);
        Assertions.assertEquals(input[1], 4);
        Assertions.assertEquals(input[2], 3);
        Assertions.assertEquals(input[3], 2);
        Assertions.assertEquals(input[4], 7);
        Assertions.assertEquals(input[5], 9);
        Assertions.assertEquals(input[6], 10);
        Assertions.assertEquals(input[7], 14);
        Assertions.assertEquals(input[8], 8);
        Assertions.assertEquals(input[9], 16);
    }

    @Test
    public void testHeapSort() {
        int[] input  = {16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
        int[] output = {1,2, 3, 4, 7, 8,  9, 10, 14, 16};
        Heapsort.heapSort(input);
        for(int i=0; i< input.length; i++) {
            Assertions.assertEquals(input[i], output[i]);
        }
    }
}
