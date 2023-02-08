package com.samples.crls.greedy;

import java.util.Objects;

public class Activity {
    int startTime;
    int endTIme;

    Activity(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTIme = endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Activity activity = (Activity) o;
        return startTime == activity.startTime && endTIme == activity.endTIme;
    }

    @Override
    public int hashCode() {
        return Objects.hash(startTime, endTIme);
    }

    @Override
    public String toString() {
        return "Activity{" +
                "startTime=" + startTime +
                ", endTIme=" + endTIme +
                '}';
    }
}
