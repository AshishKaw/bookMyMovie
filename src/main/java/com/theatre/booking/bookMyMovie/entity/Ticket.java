package com.theatre.booking.bookMyMovie.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Ticket {
	@Id
	@GeneratedValue
	private int ticket_id;
	@ManyToOne
	@JoinColumn(name = "show_id")
	@JsonIgnoreProperties("ticket")
	private Shows show;
	@OneToOne
	@JoinColumn(name = "seat_id")
	@JsonIgnoreProperties("ticket")
	private Seats seat;
	private int price;
	@CreationTimestamp
	private LocalDateTime generated_on;
	
	@ManyToOne
	@JoinColumn(name = "booking_id")
	@JsonIgnoreProperties("ticket")
	private Bookings booking;
	
	public int getTicket_id() {
		return ticket_id;
	}
	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}
	public Shows getShow() {
		return show;
	}
	public void setShow(Shows show) {
		this.show = show;
	}
	public Seats getSeat() {
		return seat;
	}
	public void setSeat(Seats seat) {
		this.seat = seat;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public LocalDateTime getGenerated_on() {
		return generated_on;
	}
	public void setGenerated_on(LocalDateTime generated_on) {
		this.generated_on = generated_on;
	}
	public Bookings getBooking() {
		return booking;
	}
	public void setBooking(Bookings booking) {
		this.booking = booking;
	}
	
	
}
