package com.korzinov.controller;

import com.korzinov.models.TrainInfoModel;
import com.korzinov.service.TrainInfoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Named(value = "scoreboardController")
@Controller
@EnableRabbit
@SessionScoped
public class ScoreboardController implements Serializable {

    static final Logger logger = LogManager.getLogger(ScoreboardController.class);

    @Autowired
    private TrainInfoService trainInfoService;

    private List<TrainInfoModel> listTrains;
    private List<String> listStations;
    private String station;
    private Date currentDate;

    @PostConstruct
    public void init() {
        listStations = trainInfoService.listStations();
        if (!listStations.isEmpty()) {
            station = listStations.get(0);
        }
        Date date = java.sql.Date.valueOf(LocalDate.now());
                    /*stub*/
//        date = new Date(date.getTime()+24*60*60*1000);
        currentDate = date;
        listTrains = trainInfoService.listTrains(station, currentDate);
    }

    @RabbitListener(queues = "Notification", containerFactory = "factory")
    public void receive(TrainInfoModel message) {
        logger.info("Received message: " + message);
        listTrains = trainInfoService.updateListTrainsFromMQ(listTrains, message);
    }

    public void onChangeStation() {
        listTrains = trainInfoService.listTrains(station, currentDate);
        listStations = trainInfoService.listStations();
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
