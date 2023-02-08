package com.samples.crci;

public class BigO {

    /**
     * The recursive call take time O(n) and space O(n)
     * on thread callstack.
     * @param n
     * @return
     */
    static int sum(int n) {
        if (n <= 0) {
            return 0;
        }
        return n + sum(n -1);
    }

    /**
     * Since this is not a recursive call the space
     * complexity is O(1) and time complexity is O(n).
     * Due to for loop.
     * @param n
     * @return
     */
    static int partialSumSequence(int n) {
        int sum = 0;
        for(int i=0; i< n; i++) {
            sum += pairSum(n, n+1);
        }
        return sum;
    }

    static int pairSum(int a, int b) {
        return a + b;
    }

    /**
     * Which one is faster ?
     *   1. whichOneIsFasterMethod1
     *   2. whichOneIsFasterMethod2
     * Having two for loops does not mean it is O(2N).
     * We don't know to assembly code is done.
     * For all intents and purposes, it is O(N).
     * What is important is O(N
     *
     * @param input
     */
    static void whichOneIsFasterMethod1(int[] input) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        for (int aNumber: input) {
            if(aNumber < min) {
                min = aNumber;
            }
            if(aNumber > max) {
                max = aNumber;
            }
        }
    }

    static void whichOneIsFasterMethod2(int[] input) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        for (int aNumber: input) {
            if(aNumber < min) {
                min = aNumber;
            }
        }
        for (int aNumber: input) {
            if(aNumber > max) {
                max = aNumber;
            }
        }
    }

    /**
     * The time complexity is O( A + B)
     *
     * If the algorithm is of the form do this, then, when
     * you are all done, do that.
     * @param arrA
     * @param arrB
     */
    static void addingRuntimes(int[] arrA, int[] arrB) {
        for(int aInput: arrA) {
            System.out.println(aInput);
        }
        for(int bInput: arrB) {
            System.out.println(bInput);
        }
    }

    /**
     * The time complexity is O( A * B)
     *
     * If the algorithm is of the form do this, for each time
     * you do that.
     *
     * @param arrA
     * @param arrB
     */
    static void multiplyingRuntimes(int[] arrA, int[] arrB) {
        for(int aInput: arrA) {
            for(int bInput: arrB) {
                System.out.println(aInput + " " + bInput );
            }
        }
     }

    /**
     * What is the runtime of this code ?
     * Time complexity
     *     O(N) for first for loop
     *     O(N) for second for loop
     *     Strictly speaking it is O(N) + O(N) = O(2N).
     *     Dropping constants it is O(N)
     *     Type of algorithmL The algorithm is of the form do this, then, when you are all done, do that.
     * Space complexity
     *     O(N) for array
     *     O(1) for sum variable
     *     O(1) for product variable
     *     O(N) + O(1) + (1)
     *     Dropping constants it is O(N)
     * @param input
     */
    static void foo(int[] input) {
        int sum = 0;
        int product = 1;
        for(int index=0; index < input.length; index++) {
            sum += input[index];
        }
        for(int index=0; index < input.length; index++) {
             product *= input[index];
        }
    }

    /**
     * Time complexity
     *   The inner loop is executed O(N) iterators and it is called N times.
     *   Therefore, the runtime is O(N^2). Order of N squared.
     * Space complexity
     *   O(N) for array
     * @param input
     */
    static void printPairs(int[] input) {
        for(int firstIndex=0; firstIndex < input.length; firstIndex++) {
            for(int secondIndex=0; secondIndex < input.length; secondIndex++) {
                System.out.println(input[firstIndex] + "" + input[secondIndex]);
            }
        }
    }

    /**
     * Time complexity
     *   The outer for loop has time complexity of O(N)
     *   The inner loop for every iteration of outer creates a sequence
     *   n-1, n-2, n-3,.....3,2,1.
     *   When written in opposite order it is 1,2,3,4,5.....n-2, n-1.
     *   The sum of n numbers can be derived from formula n (a1 + an) / 2.
     *   Here a1 = 1 and an = n-1 and w have n-1. The net result is (n-1) (n-1 + 1) /2.
     *   The final value becomes n(n-1)/2.
     * Space complexity
     *   O(N) for array
     * @param input
     */

    static void printUnOrderedPairs(int[] input) {
        for(int firstIndex=0; firstIndex < input.length; firstIndex++) {
            for(int secondIndex= firstIndex + 1; secondIndex < input.length; secondIndex++) {
                System.out.println(input[firstIndex] + "" + input[secondIndex]);
            }
        }
    }

    /**
     * The time complexity is O( A * B)
     *
     * If the algorithm is of the form do this, for each time
     * you do that.
     *
     * @param arrA
     * @param arrB
     */
    static void printUnOrderPairs(int[] arrA, int[] arrB) {
        for(int firstIndex=0; firstIndex < arrA.length; firstIndex++) {
            for(int secondIndex= 0; secondIndex < arrB.length; secondIndex++) {
                if (arrA[firstIndex] < arrB[secondIndex] ) {
                    System.out.println(arrA[firstIndex] + "," + arrB[secondIndex]);
                }
            }
        }
    }

    /**
     * The time complexity is O( A * B)
     * An extra constant of 10,000 does not matter.
     *
     * If the algorithm is of the form do this, for each time
     * you do that.
     *
     * @param arrA
     * @param arrB
     */
    static void printUnOrderPairsVariant(int[] arrA, int[] arrB) {
        for(int firstIndex=0; firstIndex < arrA.length; firstIndex++) {
            for(int secondIndex= 0; secondIndex < arrB.length; secondIndex++) {
                for (int thirdIndex =0; thirdIndex < 10000; thirdIndex ++) {
                    System.out.println(arrA[firstIndex] + "," + arrB[secondIndex]);

                }
            }
        }
    }

}
