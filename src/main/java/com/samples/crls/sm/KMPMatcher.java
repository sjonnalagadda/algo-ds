package com.samples.crls.sm;

import java.util.ArrayList;
import java.util.List;

public class KMPMatcher {

    private String input;
    private String pattern;
    private int length;
    private int patternLength;
    private int[] largestPrefixSuffix;

    KMPMatcher(String input, String pattern) {
        this.input = input;
        this.pattern = pattern;
        this.length = input.length();
        this.patternLength = pattern.length();
        this.largestPrefixSuffix = new int[this.patternLength];
        computePrefix();
    }

    List<Points> findMatches() {
        final List<Points> matches = new ArrayList<>();
        int currentMatchCounter = 0;
        for(int i=0; i < this.input.length(); i++) {
            while(currentMatchCounter > 0 && this.pattern.charAt(currentMatchCounter) != this.input.charAt(i)) {
                currentMatchCounter = this.largestPrefixSuffix[currentMatchCounter];
            }
            if(this.pattern.charAt(currentMatchCounter) == this.input.charAt(i)) {
                currentMatchCounter = currentMatchCounter + 1;
            }
            if(currentMatchCounter == this.patternLength) {
                matches.add(new Points(i - this.patternLength + 1, i + 1));
                currentMatchCounter = this.largestPrefixSuffix[currentMatchCounter -1];
            }
        }
        return matches;
    }

    private void computePrefix() {
        int k = 0;
        this.largestPrefixSuffix = new int[this.patternLength];
        this.largestPrefixSuffix[0] = 0;
        for(int psIdx = 1; psIdx < patternLength; psIdx++) {
            while(k > 0 && this.pattern.charAt(k) != this.pattern.charAt(psIdx)) {
                k = this.largestPrefixSuffix[k];
            }
            if(this.pattern.charAt(k) == this.pattern.charAt(psIdx)){
                k = k +1;
            }
            this.largestPrefixSuffix[psIdx] = k;
        }
    }
}
