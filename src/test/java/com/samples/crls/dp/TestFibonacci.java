package com.samples.crls.dp;

import org.junit.jupiter.api.Test;

public class TestFibonacci {

    @Test
    public void testFibonacci() {
        System.out.println(FibonacciNumber.calculateFibonacci(9));
    }

    @Test
    public void testFibonacciMemoization() {
        System.out.println(FibonacciNumber.calculateFibonacciUsingMemoization(9));
    }
}
