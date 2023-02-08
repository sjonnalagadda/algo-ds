package com.samples.crls.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestLargestCommonSubsequence {

    @Test
    public void testLCSUsingRecursion() {
        Assertions.assertEquals(2, LargestCommonSubsequence.lcsRecursion("bd", "abcd"));
    }

    @Test
    public void testLCSUsingRecursionWithMemoization() {
        Assertions.assertEquals(2, LargestCommonSubsequence.lcsRecursionUsingMemoization("bd", "abcd"));
    }

    @Test
    public void testLCSUsingRecursionWithBottomup() {
        Assertions.assertEquals(2, LargestCommonSubsequence.lcsUsingBottomUp("bd", "abcd"));
    }

    @Test
    public void testLCSUsingRecursionWithBottomup2() {
        Assertions.assertEquals(4, LargestCommonSubsequence.lcsUsingBottomUp("ABCBDAB", "BDCABA"));
    }

    @Test
    public void testLCSUsingRecursionWithBottomup3() {
        Assertions.assertEquals(3, LargestCommonSubsequence.lcsUsingBottomUp("stone", "longest"));
    }

    @Test
    public void printLCS() {
        Assertions.assertEquals("one", LargestCommonSubsequence.printlcs("stone", "longest"));
    }

    @Test
    public void printLCS2() {
        Assertions.assertEquals("bd", LargestCommonSubsequence.printlcs("bd", "abcd"));
    }

    @Test
    public void printLCS3() {
        Assertions.assertEquals("BCBA", LargestCommonSubsequence.printlcs("ABCBDAB", "BDCABA"));
    }

    @Test
    public void testLCSUsingRecursionWithBottomup4() {
        Assertions.assertEquals(6, LargestCommonSubsequence.lcsUsingBottomUp("10010101", "010110110"));
    }

    @Test
    public void printLCS4() {
        Assertions.assertEquals("BCBA", LargestCommonSubsequence.printlcs("10010101", "010110110"));
    }
}
