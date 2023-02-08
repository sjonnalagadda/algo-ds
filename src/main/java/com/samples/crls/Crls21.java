package com.samples.crls;

public class Crls21 {

    public static Integer findIndexOfANumber(int[] input, int valueToFind) {
        for(int i=0;i< input.length; i++) {
            if(input[i] == valueToFind) {
                return i;
            }
        }
        return null;
    }

    public static int[] addTwoBinaryNumbers(int[] operand1, int[] operand2) {
        int[] output = new int[operand1.length + 1];
        int carry = 0;
        for(int i=0; i< operand1.length; i++) {
            output[i] = (operand1[i] + operand2[i] + carry) / 2;
            carry = (operand1[i] + operand2[i] + carry) % 2 ;
            output[i+1] = carry;
        }
        return output;
    }
}
