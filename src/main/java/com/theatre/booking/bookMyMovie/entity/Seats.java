package com.theatre.booking.bookMyMovie.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Seats {

	@Id
	@GeneratedValue
	private int seat_id;
	private String seat_number;
	@ManyToOne
	@JoinColumn(name = "screen_id")
	@JsonIgnore
	private Screen screen;
	private String seat_category;
	private int addon_price;
	@JsonIgnoreProperties("seat")
	@OneToOne(mappedBy = "seat")
	private Ticket ticket;
	
	@UpdateTimestamp
	private LocalDateTime last_updated;
	
	
	public int getSeat_id() {
		return seat_id;
	}
	public void setSeat_id(int seat_id) {
		this.seat_id = seat_id;
	}
	public String getSeat_number() {
		return seat_number;
	}
	public void setSeat_number(String seat_number) {
		this.seat_number = seat_number;
	}
	public Screen getScreen() {
		return screen;
	}
	public void setScreen(Screen screen) {
		this.screen = screen;
	}
	public String getSeat_category() {
		return seat_category;
	}
	public void setSeat_category(String seat_category) {
		this.seat_category = seat_category;
	}
	public int getAddon_price() {
		return addon_price;
	}
	public void setAddon_price(int addon_price) {
		this.addon_price = addon_price;
	}
	public LocalDateTime getLast_updated() {
		return last_updated;
	}
	public void setLast_updated(LocalDateTime last_updated) {
		this.last_updated = last_updated;
	}
	
	
	
}
