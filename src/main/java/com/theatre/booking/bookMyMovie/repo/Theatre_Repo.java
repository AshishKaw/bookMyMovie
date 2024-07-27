package com.theatre.booking.bookMyMovie.repo;

import org.springframework.data.repository.CrudRepository;

import com.theatre.booking.bookMyMovie.entity.Partner;
import com.theatre.booking.bookMyMovie.entity.Theatre;


public interface Theatre_Repo extends CrudRepository<Theatre, Integer> { 

}
