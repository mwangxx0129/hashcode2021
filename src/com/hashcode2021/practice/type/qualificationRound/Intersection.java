package com.hashcode2021.practice.type.qualificationRound;

import java.util.ArrayList;
import java.util.List;

public class Intersection {
    private long id;
    private List<String> incomingStreet = new ArrayList<>();
    private List<String> outgoingStreet = new ArrayList<>();

    public Intersection(long id){
        this.id = id;
    }

    public List<String> getIncomingStreet() {
        return incomingStreet;
    }

    public void setIncomingStreet(List<String> incomingStreet) {
        this.incomingStreet = incomingStreet;
    }

    public List<String> getOutgoingStreet() {
        return outgoingStreet;
    }

    public void setOutgoingStreet(List<String> outgoingStreet) {
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
//        return Long.toString(id);
        return "Intersection{" +
                "id=" + id +
                ", incomingStreet=" + incomingStreet +
                ", outgoingStreet=" + outgoingStreet +
                '}';
    }
}
