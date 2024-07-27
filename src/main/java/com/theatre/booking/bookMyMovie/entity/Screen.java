package com.theatre.booking.bookMyMovie.entity;

import java.time.LocalDateTime;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Screen {

	@Id
	@GeneratedValue
	private int screen_id;
	private String name;
	private int total_seats;
	private String screen_size;
	private String screen_type;
	
	@ManyToOne
	@JoinColumn(name = "theatre_id")
	@JsonIgnoreProperties("screen")
	private Theatre theatre;
	
	@UpdateTimestamp 
	private LocalDateTime last_updated;
	
	@JsonIgnoreProperties("screen")
	@OneToMany(mappedBy = "screen", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Shows> shows;
	
	@OneToMany(mappedBy = "screen", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Seats> seats;
	
	public Set<Shows> getShows() {
		return shows;
	}
	public void setShows(Set<Shows> shows) {
		this.shows = shows;
	}
	
	public Set<Seats> getSeats() {
		return seats;
	}
	public void setSeats(Set<Seats> seats) {
		this.seats = seats;
	}
	public int getScreen_id() {
		return screen_id;
	}
	public void setScreen_id(int screen_id) {
		this.screen_id = screen_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTotal_seats() {
		return total_seats;
	}
	public void setTotal_seats(int total_seats) {
		this.total_seats = total_seats;
	}
	public String getScreen_size() {
		return screen_size;
	}
	public void setScreen_size(String screen_size) {
		this.screen_size = screen_size;
	}
	public String getScreen_type() {
		return screen_type;
	}
	public void setScreen_type(String screen_type) {
		this.screen_type = screen_type;
	}
	public Theatre getTheatre() {
		return theatre;
	}
	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}
	public LocalDateTime getLast_updated() {
		return last_updated;
	}
	public void setLast_updated(LocalDateTime last_updated) {
		this.last_updated = last_updated;
	}
	
	
	
}
