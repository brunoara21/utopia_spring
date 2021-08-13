package com.ss.user_service.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ss.user_service.entity.User;

public interface UserDao extends JpaRepository<User, Integer> {
	User findByUsername(String username);
}
