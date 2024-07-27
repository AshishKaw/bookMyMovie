package com.theatre.booking.bookMyMovie.repo;

import org.springframework.data.repository.CrudRepository;

import com.theatre.booking.bookMyMovie.entity.Customer;


public interface Customer_Repo extends CrudRepository<Customer, Integer> { 

}
