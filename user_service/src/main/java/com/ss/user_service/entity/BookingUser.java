package com.ss.user_service.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="booking_user")
public class BookingUser implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	
	@MapsId
	@OneToOne
	@JoinColumn(name="booking_id", referencedColumnName = "id")
	private Booking booking;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id", referencedColumnName = "role_id")
	private User user;

	/**
	 * @return the bookingId
	 */
	public Booking getBooking() {
		return booking;
	}

	/**
	 * @param bookingId the bookingId to set
	 */
	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	/**
	 * @return the agentId
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param agentId the agentId to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "BookingAgent [booking=" + booking + ", user=" + user + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(booking);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookingUser other = (BookingUser) obj;
		return Objects.equals(booking, other.booking);
	}
	
	
	
	
}