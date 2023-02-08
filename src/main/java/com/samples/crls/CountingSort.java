package com.samples.crls;

public class CountingSort {

    public static int hIndex(int[] citations) {
        int n = citations.length;
        int[] papers = new int[n + 1];
        // counting papers for each citation number
        for (int c: citations)
            papers[Math.min(n, c)]++;
        // finding the h-index
        int k = n;
        for (int s = papers[n]; k > s; s += papers[k])
            k--;
        return k;
    }

    public static void splitZerosAndOnes(int[] input) {
        int[] counterArray = new int[2];
        int[] tempOutput = new int[input.length];

        for(int index=0; index < counterArray.length; index++) {
            counterArray[index] = 0;
        }
        for(int index = 0; index < input.length; index++) {
            counterArray[input[index]]++;
        }
        for(int index=1; index < counterArray.length; index++){
            counterArray[index] = counterArray[index] + counterArray[index -1];
        }

        for(int index = input.length -1; index > 0; index--){
            tempOutput[--counterArray[input[index]]] = input[index];
        }

        for(int index = 0; index < input.length; index++) {
            input[index] =tempOutput[index];
        }

    }

    public static void countingSort(int[] input, int k) {
        int[] counterArray = new int[k + 1];
        int[] output = new int[input.length];
        //initialzie counter array with zero's. In Java we may not need it.
        for(int index = 0; index < counterArray.length; index++) {
            counterArray[index] = 0;
        }
        //count the occurences of each input value
        for(int index = 0; index < input.length; index ++) {
            counterArray[input[index]]++;
        }
        //Increment the counter and convert it to running sum
        for(int index = 1; index < counterArray.length; index++) {
            counterArray[index] = counterArray[index] + counterArray[index -1];
        }
        //place elements in sorted order in output array
        for(int index = input.length -1; index >=0; index--) {
            output[--counterArray[input[index]]] = input[index];
        }
        // C0py output array into input array
        for(int index = 0; index < output.length; index++) {
            input[index] = output[index];
        }
    }
}
