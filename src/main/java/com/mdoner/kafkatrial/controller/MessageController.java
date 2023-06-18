package com.mdoner.kafkatrial.controller;

import com.mdoner.kafkatrial.message.CustomMessage;
import com.mdoner.kafkatrial.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")

public class MessageController {

    private final KafkaTemplate kafkaTemplate;

    private final MessageService messageService;

    public MessageController(@Autowired KafkaTemplate kafkaTemplate,
                             @Autowired MessageService messageService) {
        this.kafkaTemplate = kafkaTemplate;
        this.messageService = messageService;
    }

    @GetMapping("message")
    public String getMessage() {
        CustomMessage msg = messageService.getCustomMessage();
        kafkaTemplate.send("test", msg);
        return "Hello World!";
    }
}
