package com.theatre.booking.bookMyMovie.entity;

import java.time.LocalDateTime;
import java.util.Set;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
public class Theatre {
	@Id
	@GeneratedValue
	private int theatre_id;
	private String description;
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String brand;
	private String logo_link;
	private String created_by;
	@ManyToOne
	@JoinColumn(name = "partner_id")
	@JsonIgnore
	private Partner partner;
	private LocalDateTime created_on;
	@UpdateTimestamp
	private LocalDateTime last_updated;
	private String phone;
	private String email;
	private String website;
	private double lattitude;
	private double logitude ;
	private String address;
	private String street;
	private String city;
	private String zipcode;
	private String country;
	@JsonIgnoreProperties("theatre")
	@OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<Screen> screens;
	
	@OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Discounts> discounts;
	
	
	public Set<Discounts> getDiscounts() {
		return discounts;
	}
	public void setDiscounts(Set<Discounts> discounts) {
		this.discounts = discounts;
	}
	public int getTheatre_id() {
		return theatre_id;
	}
	public void setTheatre_id(int theatre_id) {
		this.theatre_id = theatre_id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getLogo_link() {
		return logo_link;
	}
	public void setLogo_link(String logo_link) {
		this.logo_link = logo_link;
	}
	public String getCreated_by() {
		return created_by;
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	public Partner getPartner() {
		return partner;
	}
	public void setPartner(Partner partner) {
		this.partner = partner;
	}
	public LocalDateTime getCreated_on() {
		return created_on;
	}
	public void setCreated_on(LocalDateTime created_on) {
		this.created_on = created_on;
	}
	public LocalDateTime getLast_updated() {
		return last_updated;
	}
	public void setLast_updated(LocalDateTime last_updated) {
		this.last_updated = last_updated;
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
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public double getLattitude() {
		return lattitude;
	}
	public void setLattitude(double lattitude) {
		this.lattitude = lattitude;
	}
	public double getLogitude() {
		return logitude;
	}
	public void setLogitude(double logitude) {
		this.logitude = logitude;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public Set<Screen> getScreens() {
		return screens;
	}
	public void setScreens(Set<Screen> screens) {
		this.screens = screens;
	}
	
	
}
