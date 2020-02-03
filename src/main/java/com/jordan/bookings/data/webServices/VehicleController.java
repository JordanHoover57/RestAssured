package com.jordan.bookings.data.webServices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jordan.bookings.data.entity.Vehicle;
import com.jordan.bookings.data.repository.VehicleRepository;

@RestController
public class VehicleController {

	@Autowired
	public VehicleRepository vehicleRepository;

	@RequestMapping(value = "/vehicles", method = RequestMethod.GET)
	List<Vehicle> findAll(@RequestParam(required = false) String modelName) {

		List<Vehicle> vehicleList = new ArrayList();

		if (modelName == null) {

			Iterable<Vehicle> iterableVehicle = this.vehicleRepository.findAll();

			iterableVehicle.forEach(vehicle -> {
				vehicleList.add(vehicle);
			});
		} else {

			Vehicle vehicle = this.vehicleRepository.findByVehicleModel(modelName);

			if (vehicle != null) {
				vehicleList.add(vehicle);
			}
		}

		return vehicleList;
	}

}
