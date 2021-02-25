package com.hashcode2021.practice.type.qualificationRound;

public class Street {

    private long id;
    private Street startingIntersection;
    private Street endingIntersection;
    private String name;
    private int timeToTravel;


    public Street(long id, Street startingIntersection, Street endingIntersection, String name, int timeToTravel) {
        this.id = id;
        this.startingIntersection = startingIntersection;
        this.endingIntersection = endingIntersection;
        this.name = name;
        this.timeToTravel = timeToTravel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Street getStartingIntersection() {
        return startingIntersection;
    }

    public void setStartingIntersection(Street startingIntersection) {
        this.startingIntersection = startingIntersection;
    }

    public Street getEndingIntersection() {
        return endingIntersection;
    }

    public void setEndingIntersection(Street endingIntersection) {
        this.endingIntersection = endingIntersection;
    }

    public int getTimeToTravel() {
        return timeToTravel;
    }

    public void setTimeToTravel(int timeToTravel) {
        this.timeToTravel = timeToTravel;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
