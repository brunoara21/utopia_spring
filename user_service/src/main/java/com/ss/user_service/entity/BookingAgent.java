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
@Table(name="booking_agent")
public class BookingAgent implements Serializable{

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
	@JoinColumn(name="agent_id", referencedColumnName = "role_id")
	private User agent;

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
	public User getAgent() {
		return agent;
	}

	/**
	 * @param agentId the agentId to set
	 */
	public void setAgent(User agent) {
		this.agent = agent;
	}

	@Override
	public String toString() {
		return "BookingAgent [booking=" + booking + ", agent=" + agent + "]";
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
		BookingAgent other = (BookingAgent) obj;
		return Objects.equals(booking, other.booking);
	}
	
	
	
	
}
