package com.reg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reg.entities.User;

@Repository

public interface UserRepository extends JpaRepository<User, Integer> {
	
	

}
