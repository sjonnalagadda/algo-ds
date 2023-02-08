package com.samples.crls.dp;

import java.util.HashMap;
import java.util.Map;

public class FibonacciNumber {

    static int calculateFibonacci(int n) {
        if(n == 0) {
            return 0;
        } else if(n == 1) {
            return 1;
        }
        return calculateFibonacci(n-1) + calculateFibonacci(n-2);
    }

    static int calculateFibonacciUsingMemoization(int n) {

        return calculateFibonacciUsingMemoizationInternal(n, new HashMap<>());
    }

    private static int calculateFibonacciUsingMemoizationInternal(int n, Map<Integer, Integer> memTable) {
        if(n == 0) {
            return 0;
        } else if(n == 1) {
            return 1;
        }
        if(memTable.containsKey(n)) {
            return memTable.get(n);
        }
        memTable.put(n, calculateFibonacciUsingMemoizationInternal(n -1, memTable) +
                calculateFibonacciUsingMemoizationInternal(n -2, memTable));
        return memTable.get(n);
    }
}
