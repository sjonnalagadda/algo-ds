package com.samples.crls;

public class QuickSort {


    public static void quickSortWithTailRecursion(int[] input) {
        quickSortWithTailRecursionInternal(input, 0, input.length -1);
    }

    public static void quickSortWithTailRecursionInternal(int[] input, int low, int high) {
        while(low < high) {
            int pivot = lomutoPartition(input, low, high);
            quickSortWithTailRecursionInternal(input, low, pivot -1);
            low = pivot + 1;
        }
    }

    public static void quickSortLomuto(int[] input) {
        quickSortInternal(input, 0, input.length -1);
    }

    public static void splitZerosAndOnes(int[] input) {
        int left = -1;
        int right = input.length;
        while(left <= right) {
            do{
                left++;
            } while(input[left]  != 0);
            do{
                right--;
            } while(input[right]  != 1);

            if(left <= right ) {
                //swap to build two partitions. Left to pivot will be smaller. Right to pivot will be bigger.
                int temp = input[left];
                input[left] = input[right];
                input[right] = temp;
            }
        }
    }

    public static void dutchNationalFlagProblem(char[] input) {
        int redIndex = -1;
        int greenIndex = -1;
        for(int i=0; i< input.length;i++) {
            if (input[i] == 'R') {
                redIndex++;
                greenIndex++;
                swap(input, greenIndex, i);
                swap(input, greenIndex, redIndex);
            } else if (input[i] == 'G') {
                greenIndex++;
                //swap
                swap(input, greenIndex, i);
            } else { // Blue
                //Nothing to do
            }
        }
    }

    private static void swap(char[] input, int index1, int index2) {
        char temp = input[index1];
        input[index1] =  input[index2];
        input[index2] =  temp;
    }

    public static void groupTheNumbersEvenAndOdd(int[] input) {
        int left = -1;
        int right = input.length;
        while(left <= right) {
            do{
                left++;
            } while(input[left] % 2 != 0);
            do{
                right--;
            } while(input[right] % 2 == 0);

            if(left <= right ) {
                //swap to build two partitions. Left to pivot will be smaller. Right to pivot will be bigger.
                int temp = input[left];
                input[left] = input[right];
                input[right] = temp;
            }
        }
    }

    public static int[] squareOfSortedArray(int[] sortedArray) {
        int left = 0;
        int right = sortedArray.length -1;
        int[] result = new int[sortedArray.length];
        for (int i = sortedArray.length -1; i >= 0; i--) {
            int square;
            if (Math.abs(sortedArray[left]) < Math.abs(sortedArray[right])) {
                square = sortedArray[right];
                right--;
            } else {
                square = sortedArray[left];
                left++;
            }
            result[i] = square * square;
        }
        return result;
    }

    private static void quickSortInternal(int[] input, int low, int high) {
        if(low < high) {
            int pivot = lomutoPartition(input, low, high);
            quickSortInternal(input, low, pivot -1);
            quickSortInternal(input, pivot  + 1, high);
        }
    }

    private static int lomutoPartition(int[] input, int low, int high) {
        int pivot = input[high];
        int pivotIndex = low -1;
        for(int index=low; index <= high -1; index++) {
            if(input[index] <= pivot) {
                pivotIndex = pivotIndex+1;
                //swap to build two partitions. Left to pivot will be smaller. Right to pivot will be bigger.
                int temp = input[pivotIndex];
                input[pivotIndex] = input[index];
                input[index] = temp;
            }
        }
        //Move the the pivot to its position
        pivotIndex = pivotIndex + 1;
        input[high] = input[pivotIndex];
        input[pivotIndex] = pivot;
        return pivotIndex;
    }

    public static void quickSortHoares(int[] input) {
        quickSortInternalHoares(input, 0, input.length -1);
    }

    private static void quickSortInternalHoares(int[] input, int low, int high) {
        if(low < high) {
            int pivot = hoaresPartition(input, low, high);
            quickSortInternalHoares(input, low, pivot);
            quickSortInternalHoares(input, pivot  + 1, high);
        }
    }

    private static int hoaresPartition(int[] input, int low, int high) {
        int pivot = input[low];
        int leftIndex = low - 1;
        int rightIndex = high + 1;

        while (true) {
            //Keep going until an element greater than
            //pivot is found.
            do {
                leftIndex++;
            } while (input[leftIndex] < pivot);

            //Keep going we until an element less than
            //pivot is found
            do {
                rightIndex--;
            } while (input[rightIndex] > pivot);

            if(leftIndex < rightIndex) {
                int temp = input[leftIndex];
                input[leftIndex] = input[rightIndex];
                input[rightIndex] = temp;
                //swap to build two partitions. Left to pivot will be smaller. Right to pivot will be bigger.
            } else {
                return rightIndex;
            }
        }
    }
}
