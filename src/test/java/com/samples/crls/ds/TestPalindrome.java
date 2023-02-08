package com.samples.crls.ds;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestPalindrome {

    @Test
    public void isMadamPalindrome() {
        Assertions.assertTrue(isStringPalindrome("madam"));
    }

    @Test
    public void is101Palindrome() {
        Assertions.assertTrue(isStringPalindrome("101"));
    }

    @Test
    public void isSingleCharPalindrome() {
        Assertions.assertTrue(isStringPalindrome("a"));
    }

    @Test
    public void isAbPalindrome() {
        Assertions.assertFalse(isStringPalindrome("ab"));
    }

    @Test
    public void isTootPalindrome() {
        Assertions.assertTrue(isStringPalindrome("toot"));
    }

    @Test
    public void isMPalindrome() {
        Assertions.assertTrue(isPalindromeUsingDeque("madam"));
    }

    @Test
    public void isAPalindrome() {
        Assertions.assertTrue(isPalindromeUsingDeque("a"));
    }

    @Test
    public void isABPalindrome() {
        Assertions.assertFalse(isPalindromeUsingDeque("ab"));
    }

    @Test
    public void isTOOTPalindrome() {
        Assertions.assertTrue(isPalindromeUsingDeque("toot"));
    }

    private boolean isStringPalindrome(final String input) {
        int low = 0;
        int high = input.length() -1;
        while(low <= high) {
            if(input.charAt(low) != input.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }

    private boolean isPalindromeUsingDeque(final String input) {
        Deque deque = new Deque(input.length());
        for(char aChar: input.toCharArray()) {
            deque.addLast(aChar);
        }
        while(deque.size() > 1) {
            int left = deque.removeFirst();
            int right = deque.removeLast();
            if(left != right) {
                return false;
            }
        }
        return true;
    }
}
