package com.samples.crls;

import java.util.HashMap;
import java.util.Map;

public class RadixSort {

    public static void radixSortOfStrings(String[] input) {
        int max = input[0].length();
        for(int position = max -1; position >=0; position--) {
            countingSortStrings(input, 26, position);
        }

    }

    private static void countingSortStrings(String[] input, int counterArraySize, int position) {
        int[] counterArray = new int[counterArraySize];
        String[] outputArray = new String[input.length];
        //Initialize count array to all zero's
        for(int index = 0; index < counterArraySize; index++) {
            counterArray[index] = 0;
        }
        Map<Character, Integer> alphabetsToIndexMappings = alphabetsToCharMapping();
        //find the counts based on digits at the position
        for(int index = 0; index < input.length; index++) {
            counterArray[alphabetsToIndexMappings.get(input[index].charAt(position))]++;
        }
        //find the actual final position of each element to be placed at.
        for(int index =1;  index < counterArraySize; index++) {
            counterArray[index] = counterArray[index] + counterArray[index -1];
        }
        //Create output sorted array (It is only sorted based on current pass digit location)
        for(int index = input.length -1; index >=0; index--) {
            outputArray[--counterArray[alphabetsToIndexMappings.get(input[index].charAt(position))]] = input[index];
        }
        //Copy output array to original array
        for(int index = 0; index < input.length; index++) {
            input[index] = outputArray[index];
        }
    }

    private static Map<Character, Integer> alphabetsToCharMapping() {
        Map<Character, Integer> alphabetsToInt = new HashMap<>();
        alphabetsToInt.put('A', 0);
        alphabetsToInt.put('B', 1);
        alphabetsToInt.put('C', 2);
        alphabetsToInt.put('D', 3);
        alphabetsToInt.put('E', 4);
        alphabetsToInt.put('F', 5);
        alphabetsToInt.put('G', 6);
        alphabetsToInt.put('H', 7);
        alphabetsToInt.put('I', 8);
        alphabetsToInt.put('J', 9);
        alphabetsToInt.put('K', 10);
        alphabetsToInt.put('L', 11);
        alphabetsToInt.put('M', 12);
        alphabetsToInt.put('N', 13);
        alphabetsToInt.put('O', 14);
        alphabetsToInt.put('P', 15);
        alphabetsToInt.put('Q', 16);
        alphabetsToInt.put('R', 17);
        alphabetsToInt.put('S', 18);
        alphabetsToInt.put('T', 19);
        alphabetsToInt.put('U', 20);
        alphabetsToInt.put('V', 21);
        alphabetsToInt.put('W', 22);
        alphabetsToInt.put('X', 23);
        alphabetsToInt.put('Y', 24);
        alphabetsToInt.put('Z', 25);
        return alphabetsToInt;
    }

    public static void radixSort(int[] input) {
        int max = getMax(input);
        for(int position = 1; max / position > 0; position = position * 10) {
            countingSort(input, 10, position);
        }
    }

    private static int getMax(int[] input) {
        int max = input[0];
        for(int i=1; i<input.length; i++) {
            if(input[i] > max) {
                max = input[i];
            }
        }
        return max;
    }

    private static void countingSort(int[] input, int counterArraySize, int position) {
        int[] counterArray = new int[counterArraySize];
        int[] outputArray = new int[input.length];
        //Initialize count array to all zero's
        for(int index = 0; index < counterArraySize; index++) {
            counterArray[index] = 0;
        }
        //find the counts based on digits at the position
        for(int index = 0; index < input.length; index++) {
            counterArray[(input[index] / position)%10]++;
        }
        //find the actual final position of each element to be placed at.
        for(int index =1;  index < counterArraySize; index++) {
            counterArray[index] = counterArray[index] + counterArray[index -1];
        }
        //Create output sorted array (It is only sorted based on current pass digit location)
        for(int index = input.length -1; index >=0; index--) {
            outputArray[--counterArray[(input[index] / position)%10]] = input[index];
        }
        //Copy output array to original array
        for(int index = 0; index < input.length; index++) {
            input[index] = outputArray[index];
        }
    }
}
