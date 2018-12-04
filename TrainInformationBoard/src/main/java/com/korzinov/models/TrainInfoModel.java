package com.korzinov.models;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TrainInfoModel {

    private int scheduleId;
    private String trainName;
    private String stationDep;
    private String stationDest;
    private Date arrivalTime;
    private Date departureTime;
    private String status;
    private String stationName;

    public TrainInfoModel() {
    }

    public TrainInfoModel(int scheduleId, String trainName, String stationDep, String stationDest, Date arrivalTime, Date departureTime, String status, String stationName) {
        this.scheduleId = scheduleId;
        this.trainName = trainName;
        this.stationDep = stationDep;
        this.stationDest = stationDest;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.status = status;
        this.stationName = stationName;
    }

    public void handleMessage(TrainInfoModel message) {
        this.scheduleId = message.getScheduleId();
        this.trainName = message.getTrainName();
        this.stationDep = message.getStationDep();
        this.stationDest = message.getStationDest();
        this.arrivalTime = message.getArrivalTime();
        this.departureTime = message.getDepartureTime();
        this.status = message.getStatus();
        this.stationName = message.getStationName();
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

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    @Override
    public String toString() {
        return "TrainInfoModel{" +
                "scheduleId=" + scheduleId +
                ", trainName='" + trainName + '\'' +
                ", stationDep='" + stationDep + '\'' +
                ", stationDest='" + stationDest + '\'' +
                ", arrivalTime=" + arrivalTime +
                ", departureTime=" + departureTime +
                ", status='" + status + '\'' +
                ", stationName='" + stationName + '\'' +
                '}';
    }
}
