package com.jordan.bookings.data.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jordan.bookings.data.entity.Reservation;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {
	
	List<Reservation> findByReservationDate(Date reservationDate);

}
