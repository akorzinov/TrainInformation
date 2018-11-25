package com.korzinov.model;

import java.util.Date;

public class TrainInfoModel {

    private String trainName;
    private String stationDep;
    private String stationDest;
    private Date arrivalTime;
    private Date departureTime;

    public TrainInfoModel() {
    }

    public TrainInfoModel(String trainName, String stationDep, String stationDest, Date arrivalTime, Date departureTime) {
        this.trainName = trainName;
        this.stationDep = stationDep;
        this.stationDest = stationDest;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getStationDep() {
        return stationDep;
    }

    public void setStationDep(String stationDep) {
        this.stationDep = stationDep;
    }

    public String getStationDest() {
        return stationDest;
    }

    public void setStationDest(String stationDest) {
        this.stationDest = stationDest;
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
        return "TrainInfoModel{" +
                "trainName='" + trainName + '\'' +
                ", stationDep='" + stationDep + '\'' +
                ", stationDest='" + stationDest + '\'' +
                ", arrivalTime=" + arrivalTime +
                ", departureTime=" + departureTime +
                '}';
    }
}
