package com.theatre.booking.bookMyMovie.repo;

import org.springframework.data.repository.CrudRepository;

import com.theatre.booking.bookMyMovie.entity.Bookings;
import com.theatre.booking.bookMyMovie.entity.Customer;


public interface Booking_Repo extends CrudRepository<Bookings, Integer> { 

}
