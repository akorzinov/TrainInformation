package com.korzinov.service;

import com.korzinov.model.TrainInfoModel;

import java.util.Date;
import java.util.List;

public interface TrainInfoService {

    List<TrainInfoModel> listTrains(String station, Date date);

    List<String> listStations();
}
