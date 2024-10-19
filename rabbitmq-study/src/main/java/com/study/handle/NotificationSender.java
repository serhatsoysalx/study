package com.study.handle;

import com.study.model.Notification;
import com.study.producer.NotificationProcuder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.UUID;

@Component
public class NotificationSender {

    @Autowired
    private NotificationProcuder producer;

    public void getThread() {
        Thread thread = new Thread(() -> {
            while (true) {
                Notification notification = new Notification();
                notification.setId(UUID.randomUUID().toString());
                notification.setDate(new Date());
                notification.setMessage("Message");
                notification.setSeen(false);
                producer.sendToNotification(notification);

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setName("Notification sender");
        thread.start();
    }

    @PostConstruct
    public void init() {
        getThread();

    }
}
