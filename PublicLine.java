package com.SmartStop;

import java.util.Arrays;

public class PublicLine {

    private String name;
    private String towards;
    private int[] departures;

    public PublicLine(String name, String towards, int[] departure) {
        this.name = name;
        this.towards = towards;
        this.departures = departure;
    }

    public PublicLine() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getDeparture() {
        return departures;
    }


    public void setDeparture(int[] departure) {
        this.departures = departure;
    }

    public String getTowards(){
        return towards;
    }
    public void setTowards(String towards){
        this.towards = towards;
    }

    @Override
    public String toString() {
        String begin ="Line " + name + " towards " + towards + " has departures at: ";
        StringBuilder departure = new StringBuilder();
        for (int i: this.departures) {
            departure.append(i).append("min ");
        }
        return begin + departure;
    }
}
