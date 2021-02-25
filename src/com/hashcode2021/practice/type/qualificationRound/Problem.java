package com.hashcode2021.practice.type.qualificationRound;

import com.hashcode2021.practice.type.Pizza;

import java.util.HashMap;
import java.util.Map;

public class Problem {
    private int duration;
    private int numIntersections;
    private int numStreets;
    private int numCars;
    private int points;
    public Map<Integer,Intersection> intersectionsMap = new HashMap<>();
    public Map<Integer,Street> idToStreets = new HashMap<>();
    public Map<String,Street> nameToStreets = new HashMap<>();
    public Map<String, Integer> streetToIds = new HashMap<>();
    public Map<Integer,Car> carsMap= new HashMap<>();

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


    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Map<Integer, Street> getIdToStreets() {
        return idToStreets;
    }

    public void setIdToStreets(Map<Integer, Street> idToStreets) {
        this.idToStreets = idToStreets;
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
//
//    public String summarize() {
//        return """
//                ######
//                # duration: %d
//                # duration: %d
//                # Teams of 2: %d
//                # Teams of 3: %d
//                # Teams of 4: %d
//                # Different ingredients: %d
//                ######
//                """.formatted(
//                duration,
//                numTwoTeams,
//                numThreeTeams,
//                numFourTeams,
//                pizzas.stream()
//                        .map(Pizza::getIngredients)
//                        .distinct()
//                        .count()
//        );
//    }
}
