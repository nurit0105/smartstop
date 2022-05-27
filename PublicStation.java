package com.SmartStop;

import java.util.Arrays;

public class PublicStation {

    private double latitude;
    private double longitude;
    private String title;
    private PublicLine [] lines;

    public PublicStation() {
    }

    public PublicStation(double latitude, double longitude, String title, PublicLine[] lines) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.title = title;
        this.lines = lines;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public PublicLine[] getLines() {
        return lines;
    }

    public void setLines(PublicLine[] lines) {
        this.lines = lines;
    }

    @Override
    public String toString() {
        String begin = "Station " + title + "has ";
        StringBuilder end = new StringBuilder();
        for (PublicLine i: lines) {
            end.append(i);
        }
        return begin + end;
    }
}
