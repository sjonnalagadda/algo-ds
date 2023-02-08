package com.samples.crls;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

class KthQuantile {
    private int index;
    private int value;

    KthQuantile(int index, int value) {
        this.index = index;
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public int getValue() {
        return value;
    }
}

public class MediansAndOrderStatistics {


    public static int medianOfTwoSortedArrays(int[] leftInput, int[] rightInput) {
        return medianOfTwoSortedArraysInternal(leftInput, 0, leftInput.length -1,
                rightInput, 0, rightInput.length -1, rightInput.length);
    }

    public static int medianOfTwoSortedArraysInternal(int[] leftInput, int leftLow, int leftHigh, int[] rightInput,
                                               int rightLow, int rightHigh, int remainingElements) {
        if(remainingElements == 1) {
            return Math.min(leftInput[leftLow], rightInput[rightLow]);
        }

        int leftNumberOfElements = leftHigh - leftLow + 1;
        int rightNumberOfElements = rightHigh - rightLow + 1;


        int leftMid = leftLow + (leftNumberOfElements %2 == 0 ? leftNumberOfElements / 2 : leftNumberOfElements / 2 + 1)  - 1;
        int rightMid = rightLow + (rightNumberOfElements %2 == 0 ? rightNumberOfElements / 2 : rightNumberOfElements / 2 + 1) -1;

        if(leftInput[leftMid] < rightInput[rightMid]) {
            return medianOfTwoSortedArraysInternal(leftInput, leftMid + 1, leftHigh, rightInput,
            rightLow, rightMid - 1, remainingElements/2);
        } else {
            return medianOfTwoSortedArraysInternal(leftInput, leftLow, leftMid -1, rightInput,
                    rightMid  + 1, rightHigh, remainingElements/2);
        }
    }

    public static int[] nearToMedian(int[] input, int k) {
        int[] output = new int[k];
        int[] intermediate = new int[input.length];
        KthQuantile median = quickSelect(input, 0, input.length -1, input.length %2 == 0 ? input.length / 2 : input.length / 2 + 1);
        for(int index = 0; index < input.length; index++) {
            intermediate[index] = Math.abs(input[index] - median.getValue());
        }
        KthQuantile kthQuantile = quickSelect(intermediate, 0, input.length -1, k);

        for(int j = 0,  index = 0; index < input.length; index++) {
            if(j < output.length && Math.abs(input[index] - median.getValue()) <= kthQuantile.getValue()) {
                output[j++] = input[index];
            }
        }
        return output;
    }


    public static int[] kQuantiles(int[] input, int k) {
        if(k == 1) {
            throw new IllegalArgumentException("There no need to divide in any number of sets");
        }
        if(input.length % k !=  0) {
            throw new IllegalArgumentException("Can't divide into equal sized sets");
        }
        int[] kQuantiles = new int[k-1];
        kQuantilesInternal(input, 0, input.length -1, kQuantiles, k, input.length / k);
        return kQuantiles;
    }

    private static void kQuantilesInternal(int[] input, int lowIndex, int highIndex, int[] kQuantiles, int k, int groupSize) {
        if(k == 1 ) {
            return;
        }
        //Lower bound and upperBound
        int rank = k == 1 ? k * groupSize : k/2 * groupSize;
        KthQuantile kthQuantile = quickSelect(input, lowIndex, highIndex, rank);
        kQuantiles[kthQuantile.getIndex()/groupSize] = kthQuantile.getValue();
        kQuantilesInternal(input, lowIndex, kthQuantile.getIndex() , kQuantiles, k/2, groupSize);
        kQuantilesInternal(input, kthQuantile.getIndex() + 1 , highIndex ,  kQuantiles, k - (k/2), groupSize);
    }

    private static KthQuantile quickSelect(int[] input, int lowIndex, int highIndex, int kthIndex) {
        if (lowIndex == highIndex) {
            return new KthQuantile(lowIndex, input[lowIndex]); // base case. When there is only one element
        } else {
            int pivotIndex = randomizedPartition(input, lowIndex, highIndex);
            //+1
            int totalElementsInPartition = pivotIndex - lowIndex + 1;
            if (kthIndex == totalElementsInPartition) {
                return new KthQuantile(pivotIndex, input[pivotIndex]);
            }
            else if(kthIndex < totalElementsInPartition) {
                return quickSelect(input, lowIndex, pivotIndex -1, kthIndex);
            } else {
                return quickSelect(input, pivotIndex + 1, highIndex, kthIndex - totalElementsInPartition);
            }
        }
    }


    public static int minimum(int[] input) {
        int min = input[0];
        for(int index=0; index < input.length; index++) {
            if(input[index] < min) {
                min = input[index];
            }
        }
        return min;
    }

    public static int maximum(int[] input) {
        int max = input[0];
        for(int index=0; index < input.length; index++) {
            if(input[index] > max) {
                max = input[index];
            }
        }
        return max;
    }



    public static int findIthSmallestElement(int[] input, int ithSmallest) {
        return findIthSmallestElementInternal(input, 0, input.length -1, ithSmallest);
    }

    private static int findIthSmallestElementInternal(int[] input, int lowIndex, int highIndex, int ithSmallest) {
        if (lowIndex == highIndex) {
            return input[lowIndex]; // base case. When there is only one element
        } else {
            int pivotIndex = randomizedPartition(input, lowIndex, highIndex);
            //+1
            int totalElementsInPartition = pivotIndex - lowIndex + 1;
            if (ithSmallest == totalElementsInPartition) {
                return input[pivotIndex];
            }
            else if(ithSmallest < totalElementsInPartition) {
                return findIthSmallestElementInternal(input, lowIndex, pivotIndex -1, ithSmallest);
            } else {
                return findIthSmallestElementInternal(input, pivotIndex + 1, highIndex,
                        ithSmallest - totalElementsInPartition);
            }
        }
    }


    public static int[] findSimulataneousMinAndMax(int[] input) {
        int numberOfElement = input.length;
        int currentMin, currentMax;
        int index;
        int[] output = new int[2];
        if (numberOfElement % 2 == 0) { // even
            index = 2;
            if(input[0] < input[1]) {
                currentMin = input[0];
                currentMax = input[1];
            } else {
                currentMin = input[1];
                currentMax = input[0];
            }
        } else {
            index = 1;
            currentMin = input[0];
            currentMax = input[0];
        }
        for(; index <= input.length - 2; index = index + 2) {
            int firstElement = input[index];
            int secondElement = input[index + 1];
            if(firstElement < secondElement) {
                if(firstElement < currentMin) {
                    currentMin =  firstElement;
                }
            } else {
                if(secondElement > currentMax) {
                    currentMax =  secondElement;
                }
            }
        }
        output[0] = currentMin;
        output[1] = currentMax;
        return output;
    }

    public static int findIthSmallestElementInLinearTime(int[] input, int ithSmallest) {
        return findIthSmallestElementInLinearTime(input, 0, input.length -1, ithSmallest, false );
    }

    private static int findIthSmallestElementInLinearTime(int[] input, int lowIndex, int highIndex,
                                                          int ithSmallest, boolean forMedians) {
        if(lowIndex == highIndex) {
            return input[lowIndex];
        } else {
            //Trying to get reasonable split with a goal to find proper pivot element
            int numberOfElements = highIndex - lowIndex + 1;
            int numberOfMultiplesOfFive = numberOfElements / 5;
            int numberOfRemainingElements = numberOfElements % 5;
            int[] medians = new int[numberOfMultiplesOfFive + (numberOfRemainingElements > 0 ? 1 : 0)];
            int medianCount = 0;
            if(numberOfMultiplesOfFive > 0) {
                for(int index = lowIndex; index <  numberOfMultiplesOfFive * 5;  ) {
                    medians[medianCount++] = getMedian(input, index, (index + 5 -1));
                    index = index == 0 ?  5 : index + 5;
                }
            }
            if(numberOfRemainingElements > 0) {
                int startIndex = numberOfMultiplesOfFive == 0 ? 0 : (numberOfMultiplesOfFive * 5) ;
                medians[medianCount++] = getMedian(input, startIndex, (startIndex + numberOfRemainingElements -1));
            }
            //find median-of-medians, So, we can use as a pivot
            int medianOfMedians = findIthSmallestElementInLinearTime(medians, 0, medians.length -1,
                    medianCount/2, true);
            if(forMedians) {
                return medianOfMedians;
            }
            int pivot = createPartition(input, lowIndex, highIndex, medianOfMedians);
            int ithIdx = pivot - lowIndex + 1;
            if(ithIdx == ithSmallest) {
                return input[pivot];
            } else if (ithIdx < ithSmallest) {
                return findIthSmallestElementInLinearTime(input, lowIndex, pivot -1 , ithSmallest, false);
            } else {
                return findIthSmallestElementInLinearTime(input, pivot +1, highIndex , ithSmallest - ithIdx, false);
            }
        }
    }

    private static int createPartition(int[] input, int lowIndex, int highIndex, int medianValue) {
        //find index of median
        int medianIndex = 0;
        for(int index = lowIndex; index <= highIndex; index++) {
            if(medianValue == input[index]) {
                medianIndex = index;
                break;
            }
        }
        //put median at the end and select as a pivot
        swap(input, medianIndex, highIndex);
        int pivot = input[highIndex];

        int pivotIndex = -1;
        for(int index = lowIndex; index <= highIndex -1; index++) {
            if(input[index] <= pivot) {
                pivotIndex = pivotIndex + 1;
                swap(input, pivotIndex, index);
            }
        }
        pivotIndex = pivotIndex + 1;
        //Put the pivot element in proper positions
        swap(input, pivotIndex, highIndex);
        return pivotIndex;
    }

    private static void swap(int[] input, int idx1, int idx2) {
        int temp = input[idx1];
        input[idx1] = input[idx2];
        input[idx2] = temp;
    }

    private static int getMedian(int[] input, int lowIndex, int highIndex) {
        for (int index = lowIndex + 1; index <= highIndex; index++) {
            int valueToCompare = input[index];
            int maxElementsToCompare = index -1;
            while (maxElementsToCompare >= lowIndex && input[maxElementsToCompare] > valueToCompare) {
                input[maxElementsToCompare + 1] =
                        input[maxElementsToCompare];
                maxElementsToCompare--;
            }
            input[maxElementsToCompare + 1] = valueToCompare;
        }
        return input[(highIndex + lowIndex) /2];
    }



    public static void randomizedQuickSort(int[] input) {
        randomizedQuickSort(input, 0, input.length -1);
    }

    private static void randomizedQuickSort(int[] input, int low, int high) {
        if(low < high) {
            int pivot = randomizedPartition(input, low, high);
            randomizedQuickSort(input, low, pivot -1);
            randomizedQuickSort(input, pivot + 1, high);
        }
    }

    private static int randomizedPartition(int[] input, int low, int high) {
        List<Integer> inputs = Arrays.asList(low, high);
        Random rand = new Random();
        int randomIndex = rand.nextInt(inputs.size());
        int radomEleIdx = inputs.get(randomIndex);
        //Swap
        int temp = input[radomEleIdx];
        input[radomEleIdx] = input[high];
        input[high] = temp;
        //Partition based on pivot
        return partition(input, low, high);
    }

    private static int partition(int[] input, int low, int high) {
        int pivot = input[high];
        int paritionIndex = low -1;
        for(int index = low; index <= high -1; index++) {
            if(input[index] <= pivot) {
                paritionIndex = paritionIndex + 1;
                //Swap
                int temp = input[paritionIndex];
                input[paritionIndex] = input[index];
                input[index] = temp;
            }
        }
        paritionIndex = paritionIndex + 1;
        //Swap
        int temp = input[paritionIndex];
        input[paritionIndex] = pivot;
        input[high] = temp;
        return paritionIndex;
    }


}

