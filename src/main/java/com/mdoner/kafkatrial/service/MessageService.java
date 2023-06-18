package com.mdoner.kafkatrial.service;

import com.mdoner.kafkatrial.message.CustomMessage;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    public CustomMessage getCustomMessage() {
        return CustomMessage.builder()
                .message("Hello World")
                .build();
    }

    @KafkaListener(topics = "test")
    public void listen(CustomMessage customMessage) {
        System.out.println("Received message:" + customMessage.toString());
    }
}
