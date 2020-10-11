package com.armut.demo.restcontrollers;

import com.armut.demo.models.Message;
import com.armut.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Controller
@CrossOrigin
public class ChatRestController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/sendingMessages")
    //@SendTo -> Kanaldaki tüm kullanıcıya gönderir.
    public void chatEndpoint(@Payload Message message){

        System.out.println(message);
        messagingTemplate.convertAndSend("/receiveMessages", message);
    }

}
