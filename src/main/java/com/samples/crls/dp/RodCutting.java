package com.samples.crls.dp;

import java.util.HashMap;
import java.util.Map;

public class RodCutting {

    static int findMaxRevenueBruteForce(Map<Integer, Integer> prices, int rodLength) {
        if(rodLength == 0) {
            return 0;
        }
        int revenue = Integer.MIN_VALUE;
        for(int i=1; i<= rodLength; i++) {
            revenue = Math.max(revenue, prices.get(i) + findMaxRevenueBruteForce(prices, rodLength -i));
        }
        return revenue;
    }

    static int topDownMemoizationRodCutting(Map<Integer, Integer> prices, int rodLength) {
        Map<Integer, Integer> revenueMemoizationTable = new HashMap();
        //Base base
        return topDownMemoizationRodCuttingInternal(prices, rodLength, revenueMemoizationTable);
    }

    private static int topDownMemoizationRodCuttingInternal(Map<Integer, Integer> prices, int rodLength,
                                                            Map<Integer, Integer> revenueMemoizationTable) {
        if (revenueMemoizationTable.containsKey(rodLength)) {
            return revenueMemoizationTable.get(rodLength);
        }
        int revenue = Integer.MIN_VALUE;
        if(rodLength == 0) {
            revenue = 0;
        } else {
            for(int i=1; i<= rodLength; i++) {
                revenue = Math.max(revenue, prices.get(i) +  topDownMemoizationRodCuttingInternal(prices,
                        rodLength -i, revenueMemoizationTable));
            }
        }
        revenueMemoizationTable.put(rodLength, revenue);
        return revenue;
    }

    static int BottomUpMemoizationRodCutting(Map<Integer, Integer> prices, int rodLength) {
        Map<Integer, Integer> revenueMemoizationTable = new HashMap();
        //0 inch has 0 revenue
        revenueMemoizationTable.put(0, 0);
        for(int j=1; j<= rodLength; j++) {
            int revenue = Integer.MIN_VALUE;
            for(int i=1; i<= j; i++) {
                revenue = Math.max(revenue, prices.get(i) +  revenueMemoizationTable.get(j-i));
            }
            revenueMemoizationTable.put(j, revenue);
        }
        return revenueMemoizationTable.get(rodLength);
    }

    static int BottomUpMemoizationRodCuttingWithCost(Map<Integer, Integer> prices, Map<Integer, Integer> cost, int rodLength) {
        Map<Integer, Integer> revenueMemoizationTable = new HashMap();
        //0 inch has 0 revenue
        revenueMemoizationTable.put(0, 0);
        for(int j=1; j<= rodLength; j++) {
            int revenue = Integer.MIN_VALUE;
            for(int i=1; i<= j; i++) {
                revenue = Math.max(revenue, prices.get(i) +  revenueMemoizationTable.get(j-i) - cost.get(i));
            }
            revenueMemoizationTable.put(j, revenue);
        }
        return revenueMemoizationTable.get(rodLength);
    }

    static void printRodCutSolution(Map<Integer, Integer> prices, int rodLength) {
        RodCutResult result = BottomUpMemoizationRodCuttingWithResult(prices, rodLength);
        System.out.println(String.format("%d is revenue for rod length f %d", result.revenue, rodLength));
        //print which length rods compose solution
        while(rodLength > 0) {
            System.out.println(result.revenueToRodLengthMap.get(rodLength));
            rodLength = rodLength - result.revenueToRodLengthMap.get(rodLength);
        }
    }

    private static RodCutResult BottomUpMemoizationRodCuttingWithResult(Map<Integer, Integer> prices, int rodLength) {
        Map<Integer, Integer> revenueMemoizationTable = new HashMap();
        //0 inch has 0 revenue
        revenueMemoizationTable.put(0, 0);
        Map<Integer, Integer> revenueToRodLengthMap = new HashMap<>();

        for(int j=1; j<= rodLength; j++) {
            int revenue = Integer.MIN_VALUE;
            for(int i=1; i<= j; i++) {
                if(revenue <   prices.get(i) +  revenueMemoizationTable.get(j-i)) {
                    revenue = prices.get(i) +  revenueMemoizationTable.get(j-i);
                    //Mapping the rod length to max revenue
                    revenueToRodLengthMap.put(j, i);
                }
            }
            revenueMemoizationTable.put(j, revenue);
        }
        RodCutResult rodCutResult = new RodCutResult();
        rodCutResult.revenue = revenueMemoizationTable.get(rodLength);
        rodCutResult.revenueToRodLengthMap = revenueToRodLengthMap;
        return rodCutResult;
    }

    static void printRobCuttingSolutionWithTopDownMemoization(Map<Integer, Integer> prices, int rodLength) {
        Map<Integer, Integer> revenueMemoizationTable = new HashMap();
        //Base base

        Map<Integer, Integer> revenueToRodLengthMap = new HashMap<>();
        int revenue = topDownMemoizationRodCuttingSolutionInternal(prices, rodLength, revenueMemoizationTable, revenueToRodLengthMap);
        System.out.println(String.format("%d is revenue for rod length f %d", revenue, rodLength));
        //print which length rods compose solution
        while(rodLength > 0) {
            System.out.println(revenueToRodLengthMap.get(rodLength));
            rodLength = rodLength - revenueToRodLengthMap.get(rodLength);
        }
    }

    private static int topDownMemoizationRodCuttingSolutionInternal(Map<Integer, Integer> prices, int rodLength,
                                                            Map<Integer, Integer> revenueMemoizationTable,
                                                                             Map<Integer, Integer> revenueToRodLengthMap) {
        if (revenueMemoizationTable.containsKey(rodLength)) {
            return revenueMemoizationTable.get(rodLength);
        }
        int revenue = Integer.MIN_VALUE;
        if(rodLength == 0) {
            revenue = 0;
        } else {
            for(int i=1; i<= rodLength; i++) {

                int revenueForThisLength = topDownMemoizationRodCuttingSolutionInternal(prices,
                        rodLength -i, revenueMemoizationTable, revenueToRodLengthMap);
                if(revenue < revenueForThisLength + prices.get(i)) {
                    revenue = revenueForThisLength + prices.get(i);
                    revenueToRodLengthMap.put(rodLength, i);
                }
            }
        }
        revenueMemoizationTable.put(rodLength, revenue);
        return revenue;
    }
}
