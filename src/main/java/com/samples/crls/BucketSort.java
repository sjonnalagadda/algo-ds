package com.samples.crls;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BucketSort {

    private static final int R = 256;

    public static void bucketSort(float[] input, int bucketSize) {
        List<LinkedList<Float>> buckets = new ArrayList();

        for (int index = 0; index < bucketSize; index++) {
            buckets.add(new LinkedList<>());
        }

        for(int index = 0; index < input.length; index++) {
            buckets.get((int)Math.floor(bucketSize * input[index])).add(input[index]);
        }

        for(int index=0; index < bucketSize; index++) {
            Collections.sort(buckets.get(index));
        }

        int sortedIndex = 0;

        for(int index = 0; index < bucketSize; index++) {
            List<Float> elements = buckets.get(index);
            for(int elementsIndex = 0; elementsIndex < elements.size(); elementsIndex++) {
                input[sortedIndex++] = elements.get(elementsIndex);
            }
        }
    }

    public static void sortVariableLengthStringInLinearTime(String[] input) {
        List<List<String>> buckets = new ArrayList<>();
        int numberOfInputs = input.length;
        String[] aux = new String[numberOfInputs];
        sortInternal(input, aux, 0, numberOfInputs -1, 0);
    }

    private static void sortInternal(String[] input, String[] auxillary, int low, int high, int position) {
        if(low < high) {
            int[] count = new int[R + 2];
            //Compute frequencies
            for(int i = low; i <= high; i++) {
                int index = charAt(input[i], position);
                count[index + 2]++;
            }
            //Transform counts to indices
            for(int r=0; r < R + 1; r++) {
                count[r + 1] = count[r] + count[r + 1];
            }
            //distribute
            for(int i = low; i<= high; i++) {
                int index = charAt(input[i], position);
                auxillary[count[index + 1]++] = input[i];
            }
            //Copy back
            for(int i = low; i <= high; i++) {
                input[i] = auxillary[i - low];
            }
            //Recursively sort for each character value
            for(int r=0; r < R; r++) {
                sortInternal(input, auxillary, low + count[r], low+count[r+1]-1, position+1);
            }
        }
    }

    private static int charAt(String anElement, int position) {
        if(position < anElement.length()) {
            return anElement.charAt(position);
        } else {
            return -1;
        }
    }

    private static void sortInternal(List<String> elements, int low, int high,  int position) {
        if(low < high -1) {
            int[] countArr = new int[26 + 1];
            String[] output = new String[elements.size()];

            for(int index = 0; index < countArr.length; index++) {
                countArr[index] = 0;
            }
            //find the counts based on digits at the position
            for(int index = low; index <= high; index++) {
                if(checkCharExists(elements.get(index), position)) {
                    //The index is starting at zero. Need to
                    // accomodate strings that are smaller thant the position
                    int bucketIndex = getBucketIndex(elements.get(index).charAt(position));
                    countArr[++bucketIndex]++;
                } else {
                    countArr[0] =  countArr[0] + 1; // The string has no more characters
                }
            }

            int elementsReachedEnd = low + countArr[0];

            //find the actual final position of each element to be placed at.
            for(int index =1;  index < countArr.length; index++) {
                countArr[index] = countArr[index] + countArr[index -1];
            }

            //Create output sorted array (It is only sorted based on current pass digit location)
            for(int index = high; index >=low; index--) {
                if(checkCharExists(elements.get(index), position)) {
                    //The index is starting at zero. Need to
                    // accomodate strings that are smaller thant the position
                    int bucketIndex = getBucketIndex(elements.get(index).charAt(position));
                    output[--countArr[++bucketIndex] + low] = elements.get(index);
                }
                else {
                    output[--countArr[0] + low] = elements.get(index);
                }
            }
            //Copy output array to original array
            for(int index = low; index <= high; index++) {
                elements.set(index, output[index]);
            }

            sortInternal(elements, elementsReachedEnd, high,  ++position);
        }
    }

    private static boolean checkCharExists(String s, int d) {
        if(d <= s.length() -1) {
            return true;
        } else {
            return false;
        }
    }


    private static int getBucketIndex(char c) {
        switch(c) {
            case 'a':
                  return 0;
            case 'b':
                return 1;
            case 'c':
                return 2;
            case 'd':
                return 3;
            case 'e':
                return 4;
            case 'f':
                return 5;
            case 'g':
                return 6;
            case 'h':
                return 7;
            case 'i':
                return 8;
            case 'j':
                return 9;
            case 'k':
                return 10;
            case 'l':
                return 11;
            case 'm':
                return 12;
            case 'n':
                return 13;
            case 'o':
                return 14;
            case 'p':
                return 15;
            case 'q':
                return 16;
            case 'r':
                return 17;
            case 's':
                return 18;
            case 't':
                return 19;
            case 'u':
                return 20;
            case 'v':
                return 21;
            case 'w':
                return 22;
            case 'x':
                return 23;
            case 'y':
                return 24;
            case 'z':
                return 25;
            default:
                throw new IllegalArgumentException("Invalid character" + c);
        }
    }



    public static void sortVariableLengthRecordsInLinearTime(int[] input, int maxDigits) {
        List<List<Integer>> buckets = new ArrayList<>(maxDigits);

        for (int index = 0; index < maxDigits; index++) {
            buckets.add(new ArrayList<>());
        }
        for (int index = 0; index < input.length; index++) {
            buckets.get(getBucketNumber(input[index])).add(input[index]);
        }
        //Radix sort each bucket
        int numberOfDigits = 1;
        for (int index = 0; index < maxDigits; index++) {
            radixSort(buckets.get(index), numberOfDigits);
            numberOfDigits = numberOfDigits * 10;
        }

        //Collect them back and put them back.
        int sortedIndex = 0;
        for(int index = 0; index < maxDigits; index++) {
            List<Integer> bucket = buckets.get(index);
            for(int buckeIndex = 0; buckeIndex < bucket.size(); buckeIndex++) {
                input[sortedIndex++] = bucket.get(buckeIndex);
            }
        }
    }

    private static void radixSort(List<Integer> input, int maxDigits) {
        for(int postion = 1; maxDigits / postion > 0; postion = postion * 10) {
            countingSort(input, postion);
        }
    }

    private static void countingSort(final List<Integer> input, int position) {
        int[] counterArr = new int[10];
        int[] output = new int[input.size()];
        //Initialize count array to all zero's

        for(int index = 0; index < counterArr.length; index++) {
            counterArr[index] = 0;
        }
        //find the counts based on digits at the position
        for(int index = 0; index < input.size(); index++) {
            counterArr[(input.get(index) / position)%10]++;
        }
        //find the actual final position of each element to be placed at.
        for(int index =1;  index < counterArr.length; index++) {
            counterArr[index] = counterArr[index] + counterArr[index -1];
        }
        //Create output sorted array (It is only sorted based on current pass digit location)
        for(int index = input.size() -1; index >=0; index--) {
            output[--counterArr[(input.get(index) / position)%10]] = input.get(index);
        }
        //Copy output array to original array
        for(int index = 0; index < output.length; index++) {
            input.set(index, output[index]);
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

    private static int getBucketNumber(int value) {
        if( value < 10) {
            return 0;
        } else if(value < 100) { //100
            return 1;
        } else if (value < 1000) { // 1 thousand
            return 2;
        } else if (value < 10000) { // 10 thousand
            return 3;
        } else if (value < 100000){ // 100 thousand
            return 4;
        } else if (value < 1000000){ // 1 million
            return 5;
        } else if (value < 10000000){ // 10 million
            return 6;
        } else if (value < 100000000){ //100 million
            return 7;
        }else if (value < 1000000000){ // billion
            return 8;
        } else {
            return 9;
        }
    }
}
