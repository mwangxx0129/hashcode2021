package com.hashcode2021.practice.type.qualificationRound;

import java.util.ArrayList;
import java.util.List;

public class Intersection {
    private long id;
    private List<Street> incomingStreet = new ArrayList<>();
    private List<Street> outgoingStreet = new ArrayList<>();

    public Intersection(long id){
        this.id = id;
    }

    public List<Street> getIncomingStreet() {
        return incomingStreet;
    }

    public void setIncomingStreet(List<Street> incomingStreet) {
        this.incomingStreet = incomingStreet;
    }

    public List<Street> getOutgoingStreet() {
        return outgoingStreet;
    }

    public void setOutgoingStreet(List<Street> outgoingStreet) {
        this.outgoingStreet = outgoingStreet;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return Long.toString(id);
//        return "Intersection{" +
//                "id=" + id +
//                ", incomingStreet=" + incomingStreet +
//                ", outgoingStreet=" + outgoingStreet +
//                '}';
    }
}
