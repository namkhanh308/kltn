package com.kltn.service;

import com.kltn.dto.request.RegisterRequest;
import com.kltn.enttities.Role;
import com.kltn.enttities.User;
import com.kltn.enttities.UserDetail;
import com.kltn.enttities.UserRole;
import com.kltn.enttities.email.MailObject;
import com.kltn.reposititories.RoleRepository;
import com.kltn.reposititories.UserReporsitory;
import com.kltn.reposititories.UserRoleRepository;
import com.kltn.service.email.EmailService;
import com.kltn.service.email.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleList;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserReporsitory userReporsitory;
//


	@Autowired
	private UserRoleService userRoleService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userReporsitory.findByUserName(username);
		if (user == null)
			throw new UsernameNotFoundException(username);
		return new UserDetail(user);
	}
	
	public UserDetails loadUserById(int id) throws UsernameNotFoundException {
		User user = userReporsitory.getById(id);
		if (user == null)
			throw new UsernameNotFoundException(Integer.toString(id));
		return new UserDetail(user);
	}

	public User register(RegisterRequest registerRequest){
		User user = userReporsitory.save(new User(registerRequest.getUserName(),registerRequest.getPassword(),registerRequest.getEmail()));
		return userRoleService.registerUserRole(user,registerRequest.getRoles()).getUser();
	}




}
