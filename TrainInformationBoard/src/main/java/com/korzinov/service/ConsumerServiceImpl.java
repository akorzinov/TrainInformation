package com.korzinov.service;

import com.korzinov.models.TrainInfoModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerServiceImpl implements ConsumerService {

    static final Logger logger = LogManager.getLogger(ConsumerServiceImpl.class);

    @RabbitListener(queues = "Notification", containerFactory = "factory")
    @Override
    public void receive(TrainInfoModel message) {
        System.out.println("Received message: " + message);
        logger.info("Received message: " + message);
    }
}
