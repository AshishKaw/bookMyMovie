package com.theatre.booking.bookMyMovie.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
public class Discounts {
	@Id
	@GeneratedValue
	private int discount_id;
	private String description;
	private String period;
	private int discount;
	private String discount_type;
	private int items_required;
	private String unit;
	@UpdateTimestamp
	private LocalDateTime last_updated;
	@ManyToOne
	@JoinColumn(name = "theatre_id")
	@JsonIgnore
	private Theatre theatre;

	public int getDiscount_id() {
		return discount_id;
	}

	public void setDiscount_id(int discount_id) {
		this.discount_id = discount_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public LocalDateTime getLast_updated() {
		return last_updated;
	}

	public void setLast_updated(LocalDateTime last_updated) {
		this.last_updated = last_updated;
	}

	public Theatre getTheatre() {
		return theatre;
	}

	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}

	public int getItems_required() {
		return items_required;
	}

	public void setItems_required(int items_required) {
		this.items_required = items_required;
	}

	public String getDiscount_type() {
		return discount_type;
	}

	public void setDiscount_type(String discount_type) {
		this.discount_type = discount_type;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	

}
