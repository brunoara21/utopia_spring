package com.ss.user_service.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ss.user_service.entity.BookingUser;

public interface BookingUserDao extends JpaRepository<BookingUser, Integer> {

}
