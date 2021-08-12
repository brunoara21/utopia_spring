package com.ss.user_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.user_service.dao.BookingGuestDao;
import com.ss.user_service.entity.BookingGuest;

@Service
public class BookingGuestService {

	@Autowired
	private BookingGuestDao bookingGuestDao;
	
	public List<BookingGuest> getAllBookingGuests(){
		return bookingGuestDao.findAll();
	}
}
