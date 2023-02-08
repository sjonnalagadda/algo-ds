package com.samples.crls;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestBucketSort {

    @Test
    public void testBucketSort() {
        float[] input  = {0.78f, 0.17f, 0.39f, 0.26f, 0.72f, 0.94f, 0.21f, 0.12f, 0.23f, 0.68f };
        float[] output = {0.12f, 0.17f, 0.21f, 0.23f, 0.26f, 0.39f, 0.68f, 0.72f, 0.78f, 0.94f };
        BucketSort.bucketSort(input, 10);
        for(int i=0; i< input.length; i++) {
            Assertions.assertEquals(input[i], output[i]);
        }
    }

    @Test
    public void testBucketSortWithVariableLength() {
        int[] input  = {10000, 1, 99, 10, 999, 768, 1000, 9999, 888, 8769, 100};
        int[] output = {1, 10, 99, 100, 768, 888, 999, 1000, 8769, 9999, 10000};
        BucketSort.sortVariableLengthRecordsInLinearTime(input,5);
        for(int i=0; i< input.length; i++) {
            Assertions.assertEquals(input[i], output[i]);
        }
    }

    @Test
    public void testStringSortLinearTimeBySedgwick() {
        String[] input  = {"she", "sells", "seashells", "by",
                          "the", "seashore", "the", "shells",
                          "she", "sells", "are", "surely",
                          "seashells"};
//        String[] output  = {"are", "by", "seashells", "seashells",
//                            "the", "seashore", "the", "shells",
//                            "seashore", "sells", "sells", "shells",
//                            "surely", "the"};
        //String[] input  = {"are", "ate", "ab", "abc", "a", "abcdef", "a", "ab"};
        BucketSort.sortVariableLengthStringInLinearTime(input);
        System.out.println("wait");
//        MsdStringSort.sort(input);
//        for(int i=0; i< input.length; i++) {
//            Assertions.assertEquals(input[i], output[i]);
//        }

    }
}
