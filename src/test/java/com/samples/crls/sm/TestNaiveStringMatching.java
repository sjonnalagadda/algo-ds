package com.samples.crls.sm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestNaiveStringMatching {

    @Test
    public void testStringMatching() {
        final String input = "abcabc";
        final String pattern = "abc";
        NaiveStringMatching naiveStringMatching = new NaiveStringMatching(input, pattern);
        List<Points> pointsList = naiveStringMatching.findMatches();
        for(Points points: pointsList) {
            System.out.println(points.start + "  " + points.end);
            System.out.println(input.substring(points.start, points.end));
        }
    }

    @Test
    public void testStringMatching1() {
        final String input = "abcabc";
        final String pattern = "ab";
        NaiveStringMatching naiveStringMatching = new NaiveStringMatching(input, pattern);
        List<Points> pointsList = naiveStringMatching.findMatches();
        for(Points points: pointsList) {
            System.out.println(points.start + "  " + points.end);
            System.out.println(input.substring(points.start, points.end));
        }
    }

    @Test
    public void testStringMatching2() {
        final String input = "abcabc";
        final String pattern = "ab1";
        NaiveStringMatching naiveStringMatching = new NaiveStringMatching(input, pattern);
        List<Points> pointsList = naiveStringMatching.findMatches();
        Assertions.assertTrue(pointsList.isEmpty());
    }

    @Test
    public void testStringMatchingRK() {
        final String input = "abcabc";
        final String pattern = "abc";
        RabinKarpMatcher rabinKarpMatcher = new RabinKarpMatcher(input, pattern, 256, 101);
        List<Points> pointsList = rabinKarpMatcher.findMatches();
        for(Points points: pointsList) {
            System.out.println(points.start + "  " + points.end);
            System.out.println(input.substring(points.start, points.end));
        }
    }

    @Test
    public void testStringMatchingRK1() {
        final String input = "abcabc";
        final String pattern = "ab1";
        RabinKarpMatcher rabinKarpMatcher = new RabinKarpMatcher(input, pattern, 256, 101);
        List<Points> pointsList = rabinKarpMatcher.findMatches();
        Assertions.assertTrue(pointsList.isEmpty());
    }

    @Test
    public void testStringMatchingRk2() {
        final String input = "abcabc";
        final String pattern = "ab";
        RabinKarpMatcher rabinKarpMatcher = new RabinKarpMatcher(input, pattern, 256, 101);
        List<Points> pointsList = rabinKarpMatcher.findMatches();
        for(Points points: pointsList) {
            System.out.println(points.start + "  " + points.end);
            System.out.println(input.substring(points.start, points.end));
        }
    }

    @Test
    public void testStringMatchingWithKMP() {
        KMPMatcher kmpMatcher = new KMPMatcher("bacbababa", "ababaca");
        kmpMatcher.findMatches();
    }

    @Test
    public void testStringMatchingWithKMP1() {
        final String input = "abcabc";
        final String pattern = "ab";
        KMPMatcher kmpMatcher = new KMPMatcher(input, pattern);
        List<Points> pointsList = kmpMatcher.findMatches();
        for(Points points: pointsList) {
            System.out.println(points.start + "  " + points.end);
            System.out.println(input.substring(points.start, points.end ));
        }
    }

    @Test
    public void testStringMatchingWithKMP2() {
        final String input = "ababcabcabababd";
        final String pattern = "ababd";
        KMPMatcher kmpMatcher = new KMPMatcher(input, pattern);
        List<Points> pointsList = kmpMatcher.findMatches();
        for(Points points: pointsList) {
            System.out.println(points.start + "  " + points.end);
            System.out.println(input.substring(points.start, points.end ));
        }
    }

}
