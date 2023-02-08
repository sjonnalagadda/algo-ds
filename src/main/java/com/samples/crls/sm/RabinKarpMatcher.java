package com.samples.crls.sm;

import java.util.ArrayList;
import java.util.List;

public class RabinKarpMatcher {

    private String input;
    private String pattern;
    private int radix;
    private int primeNumber;
    private int length;
    private int patternLength;

    RabinKarpMatcher(String input, String pattern, int radix, int primeNumber) {
        this.input = input;
        this.pattern = pattern;
        this.radix = radix;
        this.primeNumber = primeNumber;
        this.length = this.input.length();
        this.patternLength = this.pattern.length();
    }

    List<Points> findMatches() {
        final List<Points> matches = new ArrayList<>();

        int p = 0;
        int t = 0;
        int multiplier = (int)Math.pow(this.radix, this.patternLength -1) % this.primeNumber;

        for(int i=0; i< this.patternLength; i++) {
            p = (this.radix * p + this.pattern.charAt(i)) % this.primeNumber;
            t = (this.radix * t + this.input.charAt(i)) % this.primeNumber;
        }

        for(int startIdx = 0; startIdx <= this.length - this.patternLength; startIdx++) {
            //Soft check
            if(p == t) {
                if(this.input.substring(startIdx, startIdx + this.patternLength).equals(this.pattern)) {
                    Points aPoint = new Points(startIdx, startIdx + this.patternLength);
                    matches.add(aPoint);
                }
            }
            if(startIdx < this.length - this.patternLength) {
                //calculate using rolling update
                t = (this.radix *
                        (t - this.input.charAt(startIdx) * multiplier) +
                        this.input.charAt(startIdx + this.patternLength)) % this.primeNumber;
                if (t < 0) {
                    t = (t + this.primeNumber);
                }
            }
        }
        return matches;
    }
}
