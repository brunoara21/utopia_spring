package com.ss.user_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.user_service.dao.BookingUserDao;
import com.ss.user_service.entity.BookingUser;

@Service
public class BookingUserService {

	@Autowired
	private BookingUserDao bookingUserDao;
	
	public List<BookingUser> getAllBookingUsers(){
		return bookingUserDao.findAll();
	}
}
