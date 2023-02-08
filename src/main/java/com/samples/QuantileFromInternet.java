package com.samples;


import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class QuantileFromInternet {

    private int[] data;
    private int[] res;
    private int n; // The length of array data
    private int k; // The Kth quantile
    private int t; // The amount in each k set


    public QuantileFromInternet(int[] data, int k) {
        this.data = data;
        this.res = new int[k];
        this.k = k;
        this.n = data.length;
        if (n % k != 0) {
            throw new IllegalArgumentException("The data set can be seprated into k subsets.");
        }
        this.t = n / k;
    }

    public int[] getRes() {
        return res;
    }

    public void calQuantiles(int[] data, int p, int r, int k) {
        int rank = k == 1 ? k * t : k / 2 * t;
        System.out.println("rank...."+ rank + " and K...."+ k);
        int quantile = quickSelect(this.data, p, r, rank);
        res[(rank + p) / t - 1] = quantile;
        if (k == 1) {
            return;
        }
        int q = indexOf(data, p, r, quantile);
        calQuantiles(data, p, q, k / 2);
        calQuantiles(data, q+ 1, r, k - (int)(k / 2));
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        int k = 4;
        QuantileFromInternet quantile = new QuantileFromInternet(data, k);
        quantile.calQuantiles(data, 0, data.length - 1, k);
        printArray(quantile.getRes());
    }

    public static int indexOf(int[] data, int start, int end, int key) {
        for (int i = start; i <= end; i++) {
            if (data[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static void printArray(int[] data) {
        System.out.println("======Results========");
        for (int value : data) {
            System.out.println(value);
        }
        System.out.println("=======END===========");
    }

    private static int quickSelect(int[] input, int lowIndex, int highIndex, int kthIndex ) {
        if (lowIndex == highIndex) {
            return  input[lowIndex]; // base case. When there is only one element
        } else {
            int pivotIndex = randomizedPartition(input, lowIndex, highIndex);
            //+1
            int totalElementsInPartition = pivotIndex - lowIndex + 1;
            if (kthIndex == totalElementsInPartition) {
                return input[pivotIndex];
            }
            else if(kthIndex < totalElementsInPartition) {
                return quickSelect(input, lowIndex, pivotIndex -1, kthIndex);
            } else {
                return quickSelect(input, pivotIndex + 1, highIndex, kthIndex - totalElementsInPartition);
            }
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
