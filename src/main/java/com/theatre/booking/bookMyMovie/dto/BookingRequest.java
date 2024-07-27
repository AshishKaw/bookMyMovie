package com.theatre.booking.bookMyMovie.dto;

import java.util.List;


import com.theatre.booking.bookMyMovie.entity.Customer;
import com.theatre.booking.bookMyMovie.entity.Discounts;
import com.theatre.booking.bookMyMovie.entity.Seats;
import com.theatre.booking.bookMyMovie.entity.Shows;



import lombok.Data;

@Data
public class BookingRequest {
	
	private Customer customer;
	private int total_tickets;
	private Shows show;
	private String payment_mode;
	
	private List<Seats> seats;
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public int getTotal_tickets() {
		return total_tickets;
	}
	public void setTotal_tickets(int total_tickets) {
		this.total_tickets = total_tickets;
	}
	public Shows getShow() {
		return show;
	}
	public void setShow(Shows show) {
		this.show = show;
	}
	public String getPayment_mode() {
		return payment_mode;
	}
	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}
	public List<Seats> getSeats() {
		return seats;
	}
	public void setSeats(List<Seats> seats) {
		this.seats = seats;
	}
    
	
}
