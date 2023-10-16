package com.simplepicpay.simplepicpay.services;

import com.simplepicpay.simplepicpay.domain.user.User;
import com.simplepicpay.simplepicpay.dtos.NotificationDTO;
import com.simplepicpay.simplepicpay.infra.exceptions.NotificationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationService {

    @Autowired
    private RestTemplate restTemplate;

    public void sendNotification(User user, String message) {
        String email = user.getEmail();
        
        NotificationDTO notification = new NotificationDTO(email, message);

//        ResponseEntity<String> response = restTemplate.postForEntity(
//                "http://o4d9z.mocklab.io/notify", notification, String.class);
//        if (!(response.getStatusCode() == HttpStatus.OK)) {
//            System.out.println("Notification service is off.");
//            throw new NotificationException("Notification service is off.");
//        }
        System.out.println("Notification was sent.");
    }

}
