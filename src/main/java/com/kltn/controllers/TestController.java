package com.kltn.controllers;

import com.kltn.enttities.email.MailObject;
import com.kltn.service.ClientService;
import com.kltn.service.email.EmailService;
import com.kltn.service.email.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TestController {
    @Autowired
    ClientService clientService;

    @Autowired
    EmailServiceImpl emailService;

    @GetMapping("/")
    public ResponseEntity<?> test(){
//        Client client = clientService.findClientByUserId(1);
//        ClientDTO clientDTO = new ClientDTO(client.getUserId(),client.getName(),client.getGender(),client.getAge());\

        MailObject mailObject = new MailObject("hello@job.com","anngogm98@gmai.com", "Account Tinder Windy Verified", "Tài khoản của bạn là: username: " );
        emailService.sendSimpleMessage(mailObject);
        return new ResponseEntity<>("1", HttpStatus.OK);
    }
}
