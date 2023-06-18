package com.mdoner.kafkatrial.message;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomMessage {
    private String message;
    private String topic;
    private String key;
    private String value;
    private String timestamp;
    private String type;
}
