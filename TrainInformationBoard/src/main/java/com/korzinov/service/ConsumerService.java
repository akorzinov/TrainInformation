package com.korzinov.service;

import com.korzinov.models.TrainInfoModel;

public interface ConsumerService {

    void receive(TrainInfoModel message);
}
