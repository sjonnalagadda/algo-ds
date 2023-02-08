package com.samples.crls.dp;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class TestRodCutting {

    @Test
    public void testRobCuttingBruteForce() {
        System.out.println(RodCutting.findMaxRevenueBruteForce(createPricesTable(), 4));
    }

    @Test
    public void testRobCuttingMemoization() {
        System.out.println(RodCutting.topDownMemoizationRodCutting(createPricesTable(), 4));
    }

    @Test
    public void testRobCuttingBottomUp() {
        System.out.println(RodCutting.BottomUpMemoizationRodCutting(createPricesTable(), 4));
    }

    @Test
    public void testPrintRobCuttingBottomUp() {
        RodCutting.printRodCutSolution(createPricesTable(), 7);
    }

    @Test
    public void testRobCuttingBottomUpWithPrices() {
        System.out.println(RodCutting.BottomUpMemoizationRodCuttingWithCost(createPricesTable(), createCostTable(), 4));
    }

    @Test
    public void testRobCuttingTopDownWithPrices() {
        RodCutting.printRobCuttingSolutionWithTopDownMemoization(createPricesTable(), 7);
    }

    private Map<Integer, Integer> createPricesTable() {
        Map<Integer, Integer> prices = new HashMap<>();
        prices.put(1, 1);
        prices.put(2, 5);
        prices.put(3, 8);
        prices.put(4, 9);
        prices.put(5, 10);
        prices.put(6, 17);
        prices.put(7, 17);
        prices.put(8, 20);
        prices.put(9, 24);
        prices.put(10, 30);
        return prices;
    }

    private Map<Integer, Integer> createCostTable() {
        Map<Integer, Integer> cost = new HashMap<>();
        cost.put(1, 1);
        cost.put(2, 5);
        cost.put(3, 8);
        cost.put(4, 9);
        cost.put(5, 10);
        cost.put(6, 17);
        cost.put(7, 17);
        cost.put(8, 20);
        cost.put(9, 24);
        cost.put(10, 30);
        return cost;
    }
}
