package com.kltn.controllers;

import com.kltn.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TestController {
    @Autowired
    ClientService clientService;

//    @GetMapping("/")
//    public ResponseEntity<ClientDTO> test(){
//        Client client = clientService.findClientByUserId(1);
////        ClientDTO clientDTO = new ClientDTO(client.getUserId(),client.getName(),client.getGender(),client.getAge());
//        return new ResponseEntity<>(clientDTO, HttpStatus.OK);
//    }
}
