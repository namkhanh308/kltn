package com.kltn.reposititories;

import com.kltn.enttities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
//    @Query(value = "select c.id as id from user u join client c on c.id = u.id where u.id = :userId " ,nativeQuery = true)
    Client findClientByUserId(Integer userId);
}
