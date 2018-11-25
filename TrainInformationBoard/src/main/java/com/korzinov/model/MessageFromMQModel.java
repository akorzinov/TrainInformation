package com.korzinov.model;

import java.util.Date;

public class MessageFromMQModel {

    private String trainName;
    private String stationName;
    private Date arrivalTime;
    private Date departureTime;

    public MessageFromMQModel() {
    }

    public MessageFromMQModel(String trainName, String stationName, Date arrivalTime, Date departureTime) {
        this.trainName = trainName;
        this.stationName = stationName;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    @Override
    public String toString() {
        return "MessageFromMQModel{" +
                "trainName='" + trainName + '\'' +
                ", stationName='" + stationName + '\'' +
                ", arrivalTime=" + arrivalTime +
                ", departureTime=" + departureTime +
                '}';
    }
}
