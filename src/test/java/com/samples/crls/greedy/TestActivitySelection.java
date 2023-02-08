package com.samples.crls.greedy;

import org.junit.jupiter.api.Test;

import java.util.List;

public class TestActivitySelection {

    @Test
    public void testActivitySelectionInput() {
        Activity[] activities = {
                new Activity(1, 4), new Activity(3, 5), new Activity(0,6),
                new Activity(5,7), new Activity(3,9),  new Activity(5,9),
                new Activity(6, 10), new Activity(8, 11), new Activity(8, 12),
                new Activity(12, 16), new Activity(2, 14)
        };
        List<Activity> maximumSelection = ActivitySelection.selectMaximumActivitiesUsingRecursion(activities);
        List<Activity> maximumSelection2 = ActivitySelection.selectMaximumActivitiesIteration(activities);
        System.out.println(maximumSelection);
        System.out.println(maximumSelection2);
    }
}
