package com.samples.crls;

import java.util.Optional;

public class Sorting {

    public static void insertionSortAscending(int[] input) {
        for(int offsetIndex = 1;offsetIndex <input.length; offsetIndex++) {
            int elementToCompare = input[offsetIndex];
            int maxIndexOfElementsToCompare = offsetIndex -1;
            while(maxIndexOfElementsToCompare >= 0 &&
                    input[maxIndexOfElementsToCompare] > elementToCompare) {
                input[maxIndexOfElementsToCompare + 1] =
                        input[maxIndexOfElementsToCompare];
                maxIndexOfElementsToCompare--;
            }
            input[maxIndexOfElementsToCompare + 1] = elementToCompare;
        }
    }

    public static void insertionSortDescending(int[] input) {
        for( int offsetIndex= 1; offsetIndex < input.length; offsetIndex++) {
            int elementToCompare = input[offsetIndex];
            int maxIndexOfElementsToCompare = offsetIndex -1;
            while(maxIndexOfElementsToCompare >= 0 &&
                    input[maxIndexOfElementsToCompare] < elementToCompare) {
                input[maxIndexOfElementsToCompare + 1] =
                        input[maxIndexOfElementsToCompare];
                maxIndexOfElementsToCompare--;
            }
            input[maxIndexOfElementsToCompare + 1] = elementToCompare;
        }
    }

    public static void selectionSort(int[] input) {
        for(int offsetIndex = 0;offsetIndex < input.length; offsetIndex++) {
            //Assume the
            int minIndex = offsetIndex;
            for (int searchIndex = offsetIndex + 1; searchIndex <input.length; searchIndex++) {
                if(input[searchIndex] < input[minIndex]) {
                    minIndex = searchIndex;
                }
            }
            //swap
            int minIndexElement = input[minIndex];
            input[minIndex] = input[offsetIndex];
            input[offsetIndex] = minIndexElement;

        }
    }

    public static void mergeSort(int[] input) {
        int[] helperArray = new int[input.length];
        mergeSort(input, helperArray, 0, input.length - 1);
    }

    private static void mergeSort(int[] input, int[] helperArray, int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;
            //divide
            mergeSort(input, helperArray,  low, middle);
            mergeSort(input, helperArray, middle +1 , high);
            merge(input, helperArray, low, middle, high);
        }
    }

    private static void merge(int[] input, int[] helperArray,
                              int low, int middle, int high) {

        // To adjust main array into sorted order,
        // copy elements into proper place.
        for(int index = low; index <=high; index++) {
            helperArray[index] = input[index];
        }

        //Left sub-array stating point
        int helperLeft = low;
        //Right sub-array stating point
        int helperRight = middle +1;
        //
        int current = low;

        //From two sub-arrays copy into main array in sorted order.
        while(helperLeft <= middle && helperRight <= high) {
            if (helperArray[helperLeft] <= helperArray[helperRight]) {
                input[current] = helperArray[helperLeft];
                helperLeft++;
            } else {
                input[current] = helperArray[helperRight];
                helperRight++;
            }
            current++;
        }

        //Copy remaining elements from left subarray.
        // We don't have to copy right sub-array because it is already part
        //of main array.
        int remaining = middle - helperLeft;
        for (int i=0; i <= remaining; i++) {
            input[current + i] = helperArray[helperLeft + i];
        }
    }

    public static void mergeSortWithDynamicAuxiliarySpace(int[] input) {
        mergeSortWithDynamicAuxiliarySpace(input, 0, input.length - 1);
    }

    private static void mergeSortWithDynamicAuxiliarySpace(int[] input, int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;
            //divide
            mergeSortWithDynamicAuxiliarySpace(input,  low, middle);
            mergeSortWithDynamicAuxiliarySpace(input, middle +1 , high);
            mergeWithDynamicAuxiliarySpace(input, low, middle, high);
        }
    }
    private static void mergeWithDynamicAuxiliarySpace(int[] input,
                              int low, int middle, int high) {
        int leftArraySize = middle - low + 1;
        int rightArraySize = high - middle;
        int[] leftArray = new int[leftArraySize + 1];
        int[] rightArray = new int[rightArraySize + 1];

        //Split into two arrays
        for(int index = 0; index < leftArraySize; index++) {
            leftArray[index] = input[low + index];
        }

        for(int index = 0; index < rightArraySize; index++) {
            rightArray[index] = input[middle + 1 + index];
        }
        leftArray[leftArraySize] = Integer.MAX_VALUE;
        rightArray[rightArraySize] = Integer.MAX_VALUE;

        //Now adjust the elements to put in sort order.
        int leftIndex = 0;
        int rightIndex = 0;
        for (int index = low; index <= high; index++) {
            if ( leftArray[leftIndex] <= rightArray[rightIndex] ) {
                input[index] = leftArray[leftIndex];
                leftIndex++;
            } else {
                input[index] = rightArray[rightIndex];
                rightIndex++;
            }
        }
    }

    public static Optional<Integer> recursiveBinarySearch(int[] sortedArray, int searchNumber) {
        return recursiveSearch(sortedArray, 0, sortedArray.length -1, searchNumber);
    }

    private static Optional<Integer> recursiveSearch(int[] sortedArray,
                                                     int low, int high,
                                                     int searchNumber) {
        if(low > high) {
            return Optional.empty();
        }
        int middle = (low + high) / 2;
        if (sortedArray[middle] == searchNumber) {
            return Optional.of(middle);
        } else if (searchNumber < sortedArray[middle]) {
            return recursiveSearch(sortedArray, low, middle - 1, searchNumber);
        } else {
            return recursiveSearch(sortedArray, middle + 1, high, searchNumber);
        }
    }

    public static Optional<Integer>  iterativeBinarySearch(int[] sortedArray, int searchNumber) {
        int low = 0;
        int high = sortedArray.length -1;
        while(low <= high) {
            int middle = low + high / 2;
            if (sortedArray[middle] == searchNumber) {
                return Optional.of(middle);
            } else if (searchNumber < sortedArray[middle]) {
                high = middle -1;
            } else {
                low = middle + 1;
            }
        }
        return Optional.empty();
    }

    public static Optional<SumOfTwoIndexes> determineTwoElementsForTheSum(int[] input, int sumOfTwoNumbers) {
        mergeSort(input);
        for (int index = 0; index <= input.length -1; index++) {
            int numberToFind = sumOfTwoNumbers - input[index];
            Optional<Integer> indexOfSearchedNumber = recursiveSearch(input,
                    0, input.length -1 , numberToFind);
            if(indexOfSearchedNumber.isPresent()) {
                return Optional.of(new SumOfTwoIndexes(index, indexOfSearchedNumber.get()));
            }
        }
        return Optional.empty();
    }

    public static void bubbleSort(int[] input) {
        int inputLength = input.length -1;
        for(int index =0; index <= inputLength; index++) {
            for(int cmpIndex = 0; cmpIndex <= inputLength - index -1; cmpIndex++) {
                if (input[cmpIndex] > input[cmpIndex + 1]) {
                    //swap
                    int temp = input[cmpIndex];
                    input[cmpIndex] = input[cmpIndex + 1];
                    input[cmpIndex + 1] = temp;
                }
            }
        }
    }

    public static int calculateInversions(int[] input) {
        return countInversions(input, 0, input.length -1);
    }

    private static int countInversions(int[] input, int low, int high) {
        int inversions = 0;
        if (low < high) {
            int middle = (low + high) / 2;

            //printArray(input);
            inversions +=  countInversions(input, low, middle);
            inversions +=  countInversions(input, middle +1 , high);
            inversions +=  mergeInversions(input, low, middle, high);
        }
        return inversions;
    }
    private static void printArray(int[] input) {
        for(int i=0; i < input.length; i ++) {
            System.out.print(input[i]);
            if (i !=  input.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println();
    }

    private static int mergeInversions(int[] input, int low, int middle, int high) {
        int leftArrSize = middle - low + 1;
        int rightArrSize = high - middle;

        int[] leftArray = new int[leftArrSize + 1];
        int[] rightArray = new int[rightArrSize + 1];

        //Split into two arrays
        for(int index = 0; index < leftArrSize; index++) {
            leftArray[index] = input[low + index];
        }

        for(int index = 0; index < rightArrSize; index++) {
            rightArray[index] = input[middle + 1 + index];
        }
        leftArray[leftArrSize] = Integer.MAX_VALUE;
        rightArray[rightArrSize] = Integer.MAX_VALUE;

        //Now adjust the elements to put in sort order.
        int leftIndex = 0;
        int rightIndex = 0;
        int inversions = 0;
        for (int index = low; index <= high; index++) {
            if ( leftArray[leftIndex] <= rightArray[rightIndex] ) {
                input[index] = leftArray[leftIndex];
                leftIndex++;
            } else {
                input[index] = rightArray[rightIndex];
                rightIndex++;
                inversions = inversions + leftArrSize - leftIndex;
            }
        }
        return inversions;
    }
}
