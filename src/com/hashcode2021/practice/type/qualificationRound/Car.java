package com.hashcode2021.practice.type.qualificationRound;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private long id;
    private int numStreets;
    private List<Street> streetList = new ArrayList<>();
    private boolean isArrived;
    private int arrivalTime;


    public Car(long id, int numStreets, boolean isArrived, int arrivalTime) {
        this.id = id;
        this.numStreets = numStreets;
        this.isArrived = isArrived;
        this.arrivalTime = arrivalTime;
    }

    public Car(long id, List<Street> streetList, int numStreets, boolean isArrived, int arrivalTime) {
        this.id = id;
        this.streetList = streetList;
        this.numStreets = numStreets;
        this.isArrived = isArrived;
        this.arrivalTime = arrivalTime;
    }

    public int getNumStreets() {
        return numStreets;
    }

    public void setNumStreets(int numStreets) {
        this.numStreets = numStreets;
    }

    public List<Street> getStreetList() {
        return streetList;
    }

    public void setStreetList(List<Street> streetList) {
        this.streetList = streetList;
    }

    public boolean isArrived() {
        return isArrived;
    }

    public void setArrived(boolean arrived) {
        isArrived = arrived;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", numStreets=" + numStreets +
                ", streetList=" + streetList +
                ", isArrived=" + isArrived +
                ", arrivalTime=" + arrivalTime +
                '}';
    }
}
