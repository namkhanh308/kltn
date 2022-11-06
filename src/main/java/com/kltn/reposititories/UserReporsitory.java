package com.kltn.reposititories;

import com.kltn.enttities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserReporsitory extends JpaRepository<User, Integer> {
	User findByUserName(String userName);
	User save(User user);
}
