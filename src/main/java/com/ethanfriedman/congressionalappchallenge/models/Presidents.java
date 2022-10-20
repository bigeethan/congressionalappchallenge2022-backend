package com.ethanfriedman.congressionalappchallenge.models;

public class Presidents {
    public String name;
    public String party;
    public int startOfTerm;
    public int endOfTerm;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public int getStartOfTerm() {
        return startOfTerm;
    }

    public void setStartOfTerm(int startOfTerm) {
        this.startOfTerm = startOfTerm;
    }

    public int getEndOfTerm() {
        return endOfTerm;
    }

    public void setEndOfTerm(int endOfTerm) {
        this.endOfTerm = endOfTerm;
    }
}
