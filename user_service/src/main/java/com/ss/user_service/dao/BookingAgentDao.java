package com.ss.user_service.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ss.user_service.entity.BookingAgent;

public interface BookingAgentDao extends JpaRepository<BookingAgent, Integer> {

}
