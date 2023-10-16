package com.simplepicpay.simplepicpay.validators.transaction;

import com.simplepicpay.simplepicpay.domain.user.User;
import com.simplepicpay.simplepicpay.infra.exceptions.TransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Random;

@Component
public class AuthorizationTransaction implements ValidatorTransaction {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void validate(User user, BigDecimal amount) {
//        ResponseEntity<Map> response =  restTemplate.getForEntity(
//                "https://run.mocky.io/v3/8fafdd68-a090-496f-8c9a-3442cf30dae6", Map.class);
//
//        if(response.getStatusCode() != HttpStatus.OK &&
//                !"Autorizado".equalsIgnoreCase((String) response.getBody().get("message"))) {
//            throw new TransactionException("Unauthorized transaction");
//        }

        int autorizationNumberOp = new Random().nextInt(2);
        if(autorizationNumberOp == 0) {
            throw new TransactionException("Unauthorized transaction");
        }
    }
}
