package com.theatre.booking.bookMyMovie.entity;

import java.time.LocalDateTime;
import java.util.Set;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Customer {
	
	@Id
	@GeneratedValue
	private int customer_id;
	private String username;
	private String first_name;
	private String last_name;
	private String phone;
	private String email;
	private String password;
	@UpdateTimestamp
	private LocalDateTime last_updated;
	@OneToMany(mappedBy = "customer")
	@JsonIgnoreProperties("customer")
	private Set<Bookings> bookings;
	
	
	
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDateTime getLast_updated() {
		return last_updated;
	}
	public void setLast_updated(LocalDateTime last_updated) {
		this.last_updated = last_updated;
	}
	public Set<Bookings> getBookings() {
		return bookings;
	}
	public void setBookings(Set<Bookings> bookings) {
		this.bookings = bookings;
	}
	
	
}
