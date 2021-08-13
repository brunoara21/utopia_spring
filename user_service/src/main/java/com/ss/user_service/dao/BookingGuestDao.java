package com.ss.user_service.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ss.user_service.entity.BookingGuest;

public interface BookingGuestDao extends JpaRepository<BookingGuest, Integer> {

}
