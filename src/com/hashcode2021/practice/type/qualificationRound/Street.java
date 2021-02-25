package com.hashcode2021.practice.type.qualificationRound;

public class Street {

    private long id;
    private Intersection startingIntersection;
    private Intersection endingIntersection;
    private String name;
    private int timeToTravel;


    public Street(long id, Intersection startingIntersection, Intersection endingIntersection, String name, int timeToTravel) {
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

    public Intersection getStartingIntersection() {
        return startingIntersection;
    }

    public void setStartingIntersection(Intersection startingIntersection) {
        this.startingIntersection = startingIntersection;
    }

    public Intersection getEndingIntersection() {
        return endingIntersection;
    }

    public void setEndingIntersection(Intersection endingIntersection) {
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

    @Override
    public String toString() {
        return "Street{" +
                "id=" + id +
                ", startingIntersection=" + startingIntersection +
                ", endingIntersection=" + endingIntersection +
                ", name='" + name + '\'' +
                ", timeToTravel=" + timeToTravel +
                '}';
    }
}
