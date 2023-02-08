package com.samples.crls;

public class MaximumSubArray {

    public static void findMaximumSubArray(int[] input) {
        int maxProfit = 0;
        int startIndex = 0;
        int endIndex = 0;
        for(int i=0;i<input.length;i++) {
            for(int j=i+1; j < input.length; j++) {
                int startValue = input[i];
                int nextValue = input[j];
                if(nextValue - startValue > maxProfit) {
                    maxProfit = nextValue - startValue;
                    startIndex = i;
                    endIndex = j;
                }
            }
            System.out.println("startIndex:  "+ startIndex + " endIndex: "+endIndex+ " maxProfit: "+maxProfit);
        }
    }

    public static IndexRangeAndSum findMaximumSubArrayUsingRecursion(int[] input) {
        return findMaxSubArrayInternal(input, 0, input.length -1);
    }

    private static IndexRangeAndSum findMaxSubArrayInternal(int[] input, int low, int high) {
        if(low == high) {
            return new IndexRangeAndSum(low, high, input[low]);
        }
        int mid = (low + high) / 2;
        IndexRangeAndSum leftIndexRangeSum =  findMaxSubArrayInternal(input, low, mid);
        IndexRangeAndSum rightIndexRangeSum = findMaxSubArrayInternal(input, mid + 1, high);
        IndexRangeAndSum crossOverIndexRangeSum =  findCrossOverMaxSubArrayInternal(input, low, mid, high);
        if (leftIndexRangeSum.getRangeSum() >= rightIndexRangeSum.getRangeSum() &&
                leftIndexRangeSum.getRangeSum() >= crossOverIndexRangeSum.getRangeSum()) {
            return leftIndexRangeSum;
        } else if(rightIndexRangeSum.getRangeSum() >= leftIndexRangeSum.getRangeSum() &&
                rightIndexRangeSum.getRangeSum() >= crossOverIndexRangeSum.getRangeSum()) {
            return rightIndexRangeSum;
        } else {
            return crossOverIndexRangeSum;
        }
    }

    private static IndexRangeAndSum findCrossOverMaxSubArrayInternal(int[] input, int low, int mid, int high) {
        int leftSum = Integer.MIN_VALUE;;
        int maxLeft = 0;
        int sum = 0;
        for(int index = mid;  index >= low; index--) {
            sum = sum + input[index];
            if(sum > leftSum) {
                leftSum = sum;
                maxLeft = index;
            }
        }
        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        int maxRight = 0;
        for(int index = mid + 1;  index <= high; index++) {
            sum = sum + input[index];
            if(sum > rightSum) {
                rightSum = sum;
                maxRight = index;
            }
        }

       return new IndexRangeAndSum(maxLeft, maxRight, leftSum + rightSum);
    }
}
