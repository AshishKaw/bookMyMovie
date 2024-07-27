package com.theatre.booking.bookMyMovie.repo;

import org.springframework.data.repository.CrudRepository;

import com.theatre.booking.bookMyMovie.entity.Customer;
import com.theatre.booking.bookMyMovie.entity.Ticket;


public interface Ticket_Repo extends CrudRepository<Ticket, Integer> { 

}
