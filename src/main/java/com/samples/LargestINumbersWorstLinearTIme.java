package com.samples;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class KeyAndValue {
    private int key;
    private int value;

    KeyAndValue(int key, int value)  {
        this.key = key;
        this.value = value;
    }

    int getKey() {
        return this.key;
    }

    int getValue() {
        return this.value;
    }
}

public class LargestINumbersWorstLinearTIme {

    private int[] values;

    public LargestINumbersWorstLinearTIme(int[] input) {
        this.values = input;
    }

    public int[] getIMaxElementLinearTime(int maxElements) {
        KeyAndValue keyAndValue = getIthMax(0, this.values.length -1, this.values.length - maxElements + 1);
        Arrays.sort(this.values, keyAndValue.getKey(), this.values.length -1);
        int[] output = new int[maxElements];
        int count = 0;
        for(int idx = keyAndValue.getKey() ; idx < this.values.length; idx++) {
            output[count++] = this.values[idx];
        }
        return output;
    }

    private KeyAndValue getIthMax(int lowIdx, int highIdx, int kthLargest) {
        if(lowIdx == highIdx) {
            return new KeyAndValue(lowIdx, this.values[lowIdx]);
        } else {
            int pivotIdx = randomParition(lowIdx, highIdx);
            int currentPosIdx = pivotIdx - lowIdx + 1;
            if(currentPosIdx == kthLargest) {
                return new KeyAndValue(currentPosIdx, this.values[currentPosIdx]);
            } else if(currentPosIdx < kthLargest) {
                return getIthMax(lowIdx, pivotIdx -1, kthLargest);
            } else {
                return getIthMax(pivotIdx + 1, kthLargest - pivotIdx, kthLargest);
            }
        }
    }

    private int randomParition(int lowIdx, int highIdx) {
//        List<Integer> randomInputs = Arrays.asList(lowIdx, highIdx);
//        Random rand = new Random();
//        int randomIdx= rand.nextInt(randomInputs.size());
//        swap(randomInputs.get(randomIdx), highIdx);
        return partition(lowIdx, highIdx);
    }

    private int partition(int lowIdx, int highIdx) {
        int pivot = this.values[highIdx];
        int pivotIdx = lowIdx -1;
        for(int idx = lowIdx; idx <= highIdx -1; idx++) {
            if(this.values[idx] <= pivot){
                pivotIdx = pivotIdx + 1;
                swap(idx, pivotIdx);
            }
        }
        pivotIdx = pivotIdx + 1;
        swap(highIdx, pivotIdx);
        return pivotIdx;
    }

    private void swap(int pos1, int pos2) {
        int temp = this.values[pos1];
        this.values[pos1] = this.values[pos2];
        this.values[pos2] = temp;
    }
}
