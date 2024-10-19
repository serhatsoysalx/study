package com.study.listener;

import com.study.model.Notification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NatificationListener {

    @RabbitListener(queues = "#{@environment.getProperty('rabbit.queue.name')}")
    public void handleMessage(Notification notification) {
        System.out.printf(notification.toString());
    }
}
