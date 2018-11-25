package com.korzinov.controller;

import com.korzinov.model.TrainInfoModel;
import com.korzinov.service.TrainInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import java.util.List;

@Named(value = "scoreboardController")
@Controller
public class ScoreboardController {

    @Autowired
    private TrainInfoService trainInfoService;

    private List<TrainInfoModel> listTrains;

    @PostConstruct
    public void init() {
        listTrains = trainInfoService.listTrains();
    }

    public void find() {
        listTrains = trainInfoService.listTrains();
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
}
