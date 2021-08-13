package com.ss.user_service.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ss.user_service.entity.UserRole;

public interface UserRoleDao extends JpaRepository<UserRole, Integer> {

}
