package com.example.demo.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class NotificationClient {

    @Autowired
    private RestTemplate restTemplate;

    public void notify(String feedbackId) {
        String notificationServiceHost = System.getenv("NOTIFICATION_SERVICE_HOST");

        UriComponents uri = UriComponentsBuilder.fromHttpUrl(notificationServiceHost)
                .path("/events/feedback/notification/").build();

        System.out.println("URI");
        System.out.println(uri.toString());
        restTemplate.postForEntity(uri.toString()+ feedbackId,null, String.class);
    }

}
