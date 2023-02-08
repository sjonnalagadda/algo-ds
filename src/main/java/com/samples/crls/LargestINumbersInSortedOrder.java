package com.samples.crls;

public class LargestINumbersInSortedOrder {

    public static int[] getILargestElements(int[] input, int i) {
        int[] auxArr =   new int[input.length];
        mergeSort(input, 0, input.length -1, auxArr);
        int[] output = new int[i];
        int count = 0;
        for(int index = input.length -i ; index < input.length; index++) {
            output[count++] = input[index];
        }
        return output;
    }

    private static void mergeSort(int[] input, int low, int high, int[] auxArr) {
        if(low < high) {
            int mid = (low + high) / 2;
            mergeSort(input, low, mid, auxArr);
            mergeSort(input, mid + 1, high, auxArr);
            merge(input, low, mid, high, auxArr);
        }
    }

    private static void merge(int[] input, int low, int mid, int high, int[] auxArr)  {

        for(int index = low; index <= high; index++) {
            auxArr[index] = input[index];
        }

        int leftStart = low;
        int rightStart = mid + 1;
        int currentIndex = low;

        while(leftStart <= mid && rightStart <= high) {
            if(auxArr[leftStart] <= auxArr[rightStart]) {
                input[currentIndex] = auxArr[leftStart];
                leftStart++;
            } else {
                input[currentIndex] = auxArr[rightStart];
                rightStart++;
            }
            currentIndex++;
        }
        //copy remaining left array
        int remaining = mid - leftStart;
        for(int index = 0; index <= remaining; index++) {
            input[currentIndex + index] = auxArr[leftStart + index];
        }
    }
}
