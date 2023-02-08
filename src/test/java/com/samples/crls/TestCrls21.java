package com.samples.crls;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCrls21 {

    @Test
    public void testFindNumber() {
        int[] input = {5, 2, 4, 6, 1, 3};
        Assertions.assertEquals(3, Crls21.findIndexOfANumber(input, 6));
        Assertions.assertNull(Crls21.findIndexOfANumber(input, 7));
    }

    @Test
    public void testAdditionOfTwoBinaryNumbers() {
        int[] operand1 = {1, 0, 1, 1, 0, 1, 1, 1};
        int[] operand2 = {1, 0, 1, 1, 0, 1, 1, 1};
        int[] expectedResult =   {1, 0, 1, 1, 0, 1, 1, 1, 0};
        int[] actualResult = Crls21.addTwoBinaryNumbers(operand1, operand2);
        for(int i=0; i<expectedResult.length; i++) {
            Assertions.assertEquals(expectedResult[i], actualResult[i]);
        }
    }
}
