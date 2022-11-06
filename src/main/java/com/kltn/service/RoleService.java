package com.kltn.service;

import com.kltn.enttities.Client;
import com.kltn.enttities.Role;
import com.kltn.reposititories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public class RoleService{
    @Autowired
    RoleRepository roleRepository;

    public Optional<Role> findById(Integer id) {
        return roleRepository.findById(id);
    }

}
