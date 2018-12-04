package com.korzinov.controller;

import com.korzinov.models.TrainInfoModel;
import com.korzinov.service.TrainInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Named(value = "scoreboardController")
@Controller
public class ScoreboardController {

    @Autowired
    private TrainInfoService trainInfoService;

    private List<TrainInfoModel> listTrains;
    private List<String> listStations;
    private String station;
    private Date currentDate;

    @PostConstruct
    public void initListTrains() {
        Date date = java.sql.Date.valueOf(LocalDate.now());
                    /*stub*/
        date = new Date(date.getTime()+3*24*60*60*1000);
        currentDate = date;
        listTrains = trainInfoService.listTrains("Voronezh", currentDate);
    }

    @PostConstruct
    public void initListStations() {
        listStations = trainInfoService.listStations();
        station = listStations.get(0);
    }

    public void onChangeStation() {
        listTrains = trainInfoService.listTrains(getStation(), currentDate);
    }

    public List<TrainInfoModel> getListTrains() {
        return listTrains;
    }

    public void setListTrains(List<TrainInfoModel> listTrains) {
        this.listTrains = listTrains;
    }

    public TrainInfoService getTrainInfoService() {
        return trainInfoService;
    }

    public void setTrainInfoService(TrainInfoService trainInfoService) {
        this.trainInfoService = trainInfoService;
    }

    public List<String> getListStations() {
        return listStations;
    }

    public void setListStations(List<String> listStations) {
        this.listStations = listStations;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }
}
