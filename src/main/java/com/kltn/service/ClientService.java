package com.kltn.service;

import com.kltn.enttities.Client;
import com.kltn.reposititories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;


    public Iterable<Client> findAll() {
        return clientRepository.findAll();
    }


    public Optional<Client> findById(Integer id) {
        return clientRepository.findById(id);
    }

    public Client save(Client client) {
        return client;
    }

    public Client findClientByUserId (Integer id) {
        return clientRepository.findClientByUserId(id);
    }



}
