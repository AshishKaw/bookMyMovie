package com.theatre.booking.bookMyMovie.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;

@Entity
@Data
public class Bookings {
	
	@Id
	@GeneratedValue
	private int booking_id;
	@ManyToOne
	@JoinColumn(name = "customer_id")
	@JsonIgnoreProperties("booking")
	private Customer customer;
	
	
	@JsonIgnoreProperties("booking")
	@OneToMany(mappedBy = "booking")
	private Set<Ticket> tickets;
	
	@ManyToOne
	@JoinColumn(name = "discount_id")
	@JsonIgnore
	private Discounts discounts;
	
	private int total_tickets;
	private int total_price;
	private int total_discount;
	private String payment_mode;
	private String payment_status;
	private String booking_status;
	
	@CreationTimestamp
	private LocalDateTime generated_on;
	
	
	

	public int getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Set<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}
	public Discounts getDiscounts() {
		return discounts;
	}
	public void setDiscounts(Discounts discounts) {
		this.discounts = discounts;
	}
	public int getTotal_tickets() {
		return total_tickets;
	}
	public void setTotal_tickets(int total_tickets) {
		this.total_tickets = total_tickets;
	}
	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	public int getTotal_discount() {
		return total_discount;
	}
	public void setTotal_discount(int total_discount) {
		this.total_discount = total_discount;
	}
	public String getPayment_mode() {
		return payment_mode;
	}
	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}
	public String getPayment_status() {
		return payment_status;
	}
	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}
	public String getBooking_status() {
		return booking_status;
	}
	public void setBooking_status(String booking_status) {
		this.booking_status = booking_status;
	}
	public LocalDateTime getGenerated_on() {
		return generated_on;
	}
	public void setGenerated_on(LocalDateTime generated_on) {
		this.generated_on = generated_on;
	}
	
	
	
	
}
