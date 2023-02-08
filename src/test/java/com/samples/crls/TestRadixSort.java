package com.samples.crls;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TestRadixSort {

    @Test
    public void testRadixSort() {
        int[] input =    {432, 8, 530, 90, 88, 23, 11, 45, 677, 199};
        int[] expected = {8, 11, 23, 45, 88, 90, 199, 432, 530, 677};
        RadixSort.radixSort(input);
        for (int i = 0; i < input.length; i++) {
            Assertions.assertEquals(expected[i], input[i]);
        }
    }

    @Test
    public void testRadixSortWithStrings() {
        String[] input =    {"COW", "DOG", "SEA", "RUG",
                             "ROW", "MOB", "BOX", "TAB",
                             "BAR", "EAR", "TAR", "DIG",
                             "BIG", "TEA", "NOW", "FOX"};
        String[] expected = {"BAR", "BIG", "BOX", "COW",
                             "DIG", "DOG", "EAR", "FOX",
                             "MOB", "NOW", "ROW", "RUG",
                             "SEA", "TAB", "TAR", "TEA"};
        RadixSort.radixSortOfStrings(input);
        for (int i = 0; i < input.length; i++) {
            Assertions.assertEquals(expected[i], input[i]);
        }
    }
}
