package com.ss.user_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.ss.user_service.dao.BookingAgentDao;
import com.ss.user_service.dao.UserDao;
import com.ss.user_service.dao.UserRoleDao;
import com.ss.user_service.entity.Booking;
import com.ss.user_service.entity.BookingAgent;
import com.ss.user_service.entity.User;
import com.ss.user_service.entity.UserRole;

import reactor.core.publisher.Mono;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserRoleDao userRoleDao;

	@Autowired
	private BookingAgentDao bookingAgentDao;
	
	@Autowired
	private WebClient.Builder webClientBuilder;

	public List<User> getAllUsers() {
		return userDao.findAll();
	}

	public Optional<User> getUserById(Integer userId) {
		return userDao.findById(userId);
	}

	public User createAdmin(User user, String name) {
		UserRole userRole = userRoleDao.findById(1).get();
		user.setRole(userRole);
		return userDao.save(user);
	}

	public Mono<Booking> createBooking(Integer userId, Booking booking) {

		Optional<User> oUser = userDao.findById(userId);
		if(oUser.isPresent()) {
			User user = oUser.get();
			Mono<Booking> mBooking = webClientBuilder.build().post().uri("http://BOOKING/bookings").body(Mono.just(booking), Booking.class)
					.retrieve().bodyToMono(Booking.class);
			switch (user.getRole().getId()) {
			case 1:
				break;
			case 2:
				BookingAgent bookingAgent = new BookingAgent();
				bookingAgent.setAgent(user);
				bookingAgent.setBooking(mBooking.block());
				user.getBookingAgents().add(bookingAgent);
				bookingAgentDao.save(bookingAgent);
				userDao.save(user);
				break;
			case 3:
				break;
			default:
				break;
			}
			
			return mBooking;
		} else {
			return null;
		}
		
	}

}
