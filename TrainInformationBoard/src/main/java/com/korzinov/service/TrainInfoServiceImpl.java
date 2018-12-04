package com.korzinov.service;

import com.korzinov.models.TrainInfoModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.primefaces.PrimeFaces;
import org.primefaces.context.RequestContext;
import org.springframework.stereotype.Service;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class TrainInfoServiceImpl implements TrainInfoService {

    static final Logger logger = LogManager.getLogger(TrainInfoServiceImpl.class);

    @Override
    public List<TrainInfoModel> listTrains(String station, Date date) {
        List<TrainInfoModel> listTrains = new ArrayList<>();
        String pathDate = String.valueOf(date.getTime());
        try {
            Client client = ClientBuilder.newClient();
            WebTarget webTarget = client.target("http://localhost:8080/rest").path("trains").path(station).path(pathDate);
            Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
            TrainInfoModel[] trains = invocationBuilder.get().readEntity(TrainInfoModel[].class);
            listTrains = Arrays.asList(trains);
            for (TrainInfoModel tr : listTrains) {
                logger.info("Trains: " + tr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTrains;
    }

    @Override
    public List<String> listStations() {
        List<String> listStations = new ArrayList<>();
        try {
            Client client = ClientBuilder.newClient();
            WebTarget webTarget = client.target("http://localhost:8080/rest").path("trains").path("stations");
            Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
            String[] stations = invocationBuilder.get().readEntity(String[].class);
            listStations = Arrays.asList(stations);
            for (String st : listStations) {
                logger.info("Stations: " + st);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listStations;
    }

    @Override
    public List<TrainInfoModel> updateListTrainsFromMQ(List<TrainInfoModel> listTrains, TrainInfoModel message) {
        for (int i = 0; i < listTrains.size(); i++) {
            if (listTrains.get(i).getScheduleId() == message.getScheduleId() &&
                    listTrains.get(i).getStationName().equals(message.getStationName())) {
                listTrains.set(i, message);
            }
        }
        return listTrains;
    }
}
