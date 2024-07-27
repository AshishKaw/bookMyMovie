package com.theatre.booking.bookMyMovie.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.theatre.booking.bookMyMovie.entity.Partner;
import com.theatre.booking.bookMyMovie.entity.Shows;


public interface Show_Repo extends JpaRepository<Shows, Integer>, JpaSpecificationExecutor<Shows> { 

}
