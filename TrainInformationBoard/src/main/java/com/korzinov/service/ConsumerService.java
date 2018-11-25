package com.korzinov.service;

import com.korzinov.model.MessageFromMQModel;

public interface ConsumerService {

    void Receive(MessageFromMQModel message);
}
