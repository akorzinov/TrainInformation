package com.korzinov.service;

import com.korzinov.model.TrainInfoModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TrainInfoServiceImpl implements TrainInfoService {

    static final Logger logger = LogManager.getLogger(TrainInfoServiceImpl.class);

    @Override
    public List<TrainInfoModel> listTrains() {
        List<TrainInfoModel> listTrains = new ArrayList<>();
        try {
            Client client = ClientBuilder.newClient();
            WebTarget webTarget = client.target("http://localhost:8080/rest").path("trains");
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
}
