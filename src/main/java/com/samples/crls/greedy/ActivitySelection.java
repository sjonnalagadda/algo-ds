package com.samples.crls.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ActivitySelection {

    public static List<Activity> selectMaximumActivitiesIteration(Activity[] activities) {
        List<Activity> compatibleActivities = new ArrayList<>();
        //If activities is zero, then there is no compatible activities.
        if ( activities.length ==  0 ) {
            return compatibleActivities;
        }
        //Sort
        sortActivitiesByEndTime(activities);
        //Making greedy choice
        compatibleActivities.add(activities[0]);
        //find comparable activities using iteration
        int activityEndTime = activities[0].endTIme;
        for(int nextActivityCounter = 1; nextActivityCounter < activities.length; nextActivityCounter++) {
            if(activities[nextActivityCounter].startTime >= activityEndTime) {
                compatibleActivities.add(activities[nextActivityCounter]);
                activityEndTime = activities[nextActivityCounter].endTIme;
            }
        }
        //Time complexity of entire algorithm is n log(n) + n
        //Sorting time + time to iterate
        //Space complexity n for output.
        return compatibleActivities;
    }

    public static List<Activity> selectMaximumActivitiesUsingRecursion(Activity[] activities) {
        List<Activity> compatibleActivities = new ArrayList<>();
        //If activities is zero, then there is no compatible activities.
        if ( activities.length ==  0 ) {
            return compatibleActivities;
        }
        //Sort
        sortActivitiesByEndTime(activities);
        //Making greedy choice
        compatibleActivities.add(activities[0]);
        //find comparable activities using recursion
        selectMaximumActivitiesUsingRecursionInternal(activities, compatibleActivities, 1, activities[0].endTIme);
        //Time complexity of entire algorithm is n log(n) + n
        //Sorting time + time to iterate
        //Space complexity n for output and n for thread for stack size.
        return compatibleActivities;
    }

    private static void selectMaximumActivitiesUsingRecursionInternal(Activity[] allActivities, List<Activity> compatibleActivities,
                                                                      int nextActivityCounter, int activityEndTime) {
        //When all elements are done.
        if ( nextActivityCounter > allActivities.length-1 ) {
            return;
        }
        //Find next activity start time is greater than equal to current activity end time and mark add to compa
        if ( allActivities[nextActivityCounter].startTime >= activityEndTime ) {
            compatibleActivities.add(allActivities[nextActivityCounter]);
            activityEndTime = allActivities[nextActivityCounter].endTIme;
        }
        selectMaximumActivitiesUsingRecursionInternal(allActivities, compatibleActivities, ++nextActivityCounter,
                activityEndTime);
    }

    private static void sortActivitiesByEndTime(Activity[] activities) {
        //Sort by end time of activity
        Arrays.sort(activities, 0, activities.length, new Comparator<Activity>() {
            @Override
            public int compare(Activity o1, Activity o2) {
                if(o1.endTIme == o2.endTIme) {
                    return 0;
                } else if(o1.endTIme > o2.endTIme) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

    }
}
