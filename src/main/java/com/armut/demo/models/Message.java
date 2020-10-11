package com.armut.demo.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Message")
public class Message {

    @Id
    private String id;

    private String messageContent;
    private User sendMessageUser;
    private User receiveMessageUser;


}
