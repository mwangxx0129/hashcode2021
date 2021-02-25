package com.hashcode2021.practice.type.qualificationRound;

import java.util.HashMap;
import java.util.Map;

public class Problem {
    private int duration;
    private int numIntersections;
    private int numStreets;
    private int numCars;
    private Map<Integer,Street> streetsMap = new HashMap<>();
    private Map<Integer,Car> carsMap= new HashMap<>();
    private Map<Integer,Intersection> intersectionsMap = new HashMap<>();

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getNumIntersections() {
        return numIntersections;
    }

    public void setNumIntersections(int numIntersections) {
        this.numIntersections = numIntersections;
    }

    public int getNumStreets() {
        return numStreets;
    }

    public void setNumStreets(int numStreets) {
        this.numStreets = numStreets;
    }

    public int getNumCars() {
        return numCars;
    }

    public void setNumCars(int numCars) {
        this.numCars = numCars;
    }

    public Map<Integer, Street> getStreetsMap() {
        return streetsMap;
    }

    public void setStreetsMap(Map<Integer, Street> streetsMap) {
        this.streetsMap = streetsMap;
    }

    public Map<Integer, Car> getCarsMap() {
        return carsMap;
    }

    public void setCarsMap(Map<Integer, Car> carsMap) {
        this.carsMap = carsMap;
    }

    public Map<Integer, Intersection> getIntersectionsMap() {
        return intersectionsMap;
    }

    public void setIntersectionsMap(Map<Integer, Intersection> intersectionsMap) {
        this.intersectionsMap = intersectionsMap;
    }
}
