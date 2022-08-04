package com.kltn.service;

import com.kltn.enttities.User;
import com.kltn.enttities.UserDetail;
import com.kltn.enttities.email.MailObject;
import com.kltn.reposititories.UserReporsitory;
import com.kltn.service.email.EmailService;
import com.kltn.service.email.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserReporsitory repository;

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repository.findByUserName(username);
		if (user == null)
			throw new UsernameNotFoundException(username);
		return new UserDetail(user);
	}
	
	public UserDetails loadUserById(int id) throws UsernameNotFoundException {
		User user = repository.getById(id);
		if (user == null)
			throw new UsernameNotFoundException(Integer.toString(id));
		return new UserDetail(user);
	}



}
