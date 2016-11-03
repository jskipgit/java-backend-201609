package com.ironyard.data;

/**
 * This class represents a single Assignment.
 */
public class Assignment {
    private String name;
    private int points;
    private int totalPossiblePoints;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getTotalPossiblePoints() {
        return totalPossiblePoints;
    }

    public void setTotalPossiblePoints(int totalPossiblePoints) {
        this.totalPossiblePoints = totalPossiblePoints;
    }
}
