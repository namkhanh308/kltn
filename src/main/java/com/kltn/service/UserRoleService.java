package com.kltn.service;

import com.kltn.dto.request.RegisterRequest;
import com.kltn.enttities.Role;
import com.kltn.enttities.User;
import com.kltn.enttities.UserRole;
import com.kltn.reposititories.RoleRepository;
import com.kltn.reposititories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserRoleService {
    @Autowired
    private RoleRepository roleService;

    @Autowired
    private UserRoleRepository userRoleRepository;

    public UserRole registerUserRole(User user, String roles) {
        Optional<Role> role = roleService.findById(Integer.valueOf(roles));
        return userRoleRepository.save(new UserRole(user, role.get()));
    }
}

