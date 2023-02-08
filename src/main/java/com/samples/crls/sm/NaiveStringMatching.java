package com.samples.crls.sm;

import java.util.ArrayList;
import java.util.List;

public class NaiveStringMatching {

    private String input;
    private String pattern;
    private int length;
    private int patternLength;

    NaiveStringMatching(String input, String pattern) {
        this.input = input;
        this.pattern = pattern;
        this.length = input.length();
        this.patternLength = pattern.length();
    }

    List<Points> findMatches() {
        final List<Points> matches = new ArrayList<>();
        for(int startIdx = 0; startIdx <= length - patternLength; startIdx++) {
            if(input.substring(startIdx, startIdx+this.patternLength).equals(pattern)) {
                matches.add(new Points(startIdx, startIdx + this.patternLength ));
            }
        }
        return matches;
    }
}
