package com.samples.crls;

import org.junit.jupiter.api.Test;

public class TestMaximumSubArray {

    @Test
    public void findMaxSubArray() {
        int[] input = {100, 113, 110, 85,
                       105, 102, 86, 63,
                       81, 101, 94, 106,
                       101, 79, 94, 90, 97};
        MaximumSubArray.findMaximumSubArray(input);
    }

    @Test
    public void findMaxSubArray1() {
        int[] input = {10, 11, 7, 10, 6};
        MaximumSubArray.findMaximumSubArray(input);
    }

    @Test
    public void findMaxSubArrayR() {
        int[] input = {100, 113, 110, 85,
                105, 102, 86, 63,
                81, 101, 94, 106,
                101, 79, 94, 90, 97};
        int[] delta = {13, -3, -25, 20,
                      -3, -16, -23, 18,
                      20, -7, 12, -5,
                      -22, 15, -4, 7};
        IndexRangeAndSum indexRangeAndSum = MaximumSubArray.findMaximumSubArrayUsingRecursion(delta);
        System.out.println(indexRangeAndSum.getRangeSum());
    }
}
