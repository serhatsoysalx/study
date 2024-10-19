package com.study.producer;

import com.study.model.Notification;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class NotificationProcuder {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("#{@environment.getProperty('rabbit.routing.name')}")
    private String routing;

    @Value("#{@environment.getProperty('rabbit.exchange.name')}")
    private String exchange;

    public void sendToNotification(Notification notification){
        System.out.printf("notification send ID : " + notification.getId() + "\n");
        rabbitTemplate.convertAndSend(exchange, routing,notification);
    }
}
