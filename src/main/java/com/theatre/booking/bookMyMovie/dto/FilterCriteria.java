package com.theatre.booking.bookMyMovie.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class FilterCriteria {

private String city;
private String language;
private String genres;
private String lead_actors;
private String director;
private String name;


@JsonFormat(pattern="yyyy-MM-dd")
@DateTimeFormat(pattern="yyyy-MM-dd", iso = DateTimeFormat.ISO.DATE)
private LocalDate date;
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getLanguage() {
	return language;
}
public void setLanguage(String language) {
	this.language = language;
}
public String getGenres() {
	return genres;
}
public void setGenres(String genres) {
	this.genres = genres;
}
public String getLead_actors() {
	return lead_actors;
}
public void setLead_actors(String lead_actors) {
	this.lead_actors = lead_actors;
}
public String getDirector() {
	return director;
}
public void setDirector(String director) {
	this.director = director;
}
public LocalDate getDate() {
	return date;
}
public void setDate(LocalDate date) {
	this.date = date;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}


}
