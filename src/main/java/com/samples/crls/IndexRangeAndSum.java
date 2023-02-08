package com.samples.crls;

public class IndexRangeAndSum {

    private int leftIndex;
    private int rightIndex;
    private int rangeSum;

    public IndexRangeAndSum(int leftIndex, int rightIndex, int rangeSum) {
        this.leftIndex = leftIndex;
        this.rightIndex = rightIndex;
        this.rangeSum = rangeSum;
    }

    public int getLeftIndex() {
        return leftIndex;
    }

    public int getRangeSum() {
        return rangeSum;
    }

    public int getRightIndex() {
        return rightIndex;
    }
}
