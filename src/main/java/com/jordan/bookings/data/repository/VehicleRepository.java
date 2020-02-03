package com.jordan.bookings.data.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jordan.bookings.data.entity.Vehicle;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Long> {
	
	Vehicle findByVehicleModel(String vehicleModel);
	
}
