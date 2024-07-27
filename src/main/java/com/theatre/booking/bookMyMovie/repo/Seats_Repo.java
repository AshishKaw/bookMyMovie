package com.theatre.booking.bookMyMovie.repo;

import org.springframework.data.repository.CrudRepository;

import com.theatre.booking.bookMyMovie.entity.Partner;
import com.theatre.booking.bookMyMovie.entity.Seats;


public interface Seats_Repo extends CrudRepository<Seats, Integer> { 

}
