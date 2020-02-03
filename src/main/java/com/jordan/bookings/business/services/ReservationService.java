package com.jordan.bookings.business.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jordan.bookings.business.domains.VehicleReservation;
import com.jordan.bookings.data.entity.Client;
import com.jordan.bookings.data.entity.Reservation;
import com.jordan.bookings.data.entity.Vehicle;
import com.jordan.bookings.data.repository.ClientRepository;
import com.jordan.bookings.data.repository.ReservationRepository;
import com.jordan.bookings.data.repository.VehicleRepository;

@Service
public class ReservationService {
	
	private VehicleRepository vehicleRepository;
	private ClientRepository clientRepository;
	private ReservationRepository reservationRepository;
	
	@Autowired
	public ReservationService (VehicleRepository vehicleRepository, ClientRepository clientRepository,
			ReservationRepository reservationRepository) {
		super();
		this.vehicleRepository = vehicleRepository;
		this.clientRepository = clientRepository;
		this.reservationRepository = reservationRepository;
	}
	
	public List<VehicleReservation> getVehicleReservationsForDate(Date date){
		//calls the vehicle repository to return all vehicles
		Iterable<Vehicle> vehicles = this.vehicleRepository.findAll();
		//A map to hold vehicle reservations by vehicle ID
		Map<Long,VehicleReservation> vehicleReservationsMap = new HashMap();
		//iterating over each vehicle to build a vehicle reservation
		vehicles.forEach(vehicle -> {
			VehicleReservation vehicleReservation = new VehicleReservation();
			vehicleReservation.setVehicleId(vehicle.getId());
			vehicleReservation.setVehicleModel(vehicle.getVehicleModel());
			vehicleReservation.setVehicleType(vehicle.getVehicleType());
			//add to the map the vehicle reservation by vehicle id
			//the map will have on reservation per vehicle with the vehicle ID as the key
			vehicleReservationsMap.put(vehicle.getId(), vehicleReservation);
		});
		
		Iterable<Reservation> reservations = (Iterable<Reservation>) this.reservationRepository.findByReservationDate(date);
		if(reservations != null) {
			reservations.forEach(reservation -> {
				Optional<Client> client = this.clientRepository.findById(reservation.getClientId());
				if(client != null) {
					VehicleReservation vehicleReservation = vehicleReservationsMap.get(reservation.getVehicleId());
					//Mistake in line above should be vehicle id but will let video tell me
					vehicleReservation.setDate(date);
					vehicleReservation.setFirstName(client.get().getFirstName());
					vehicleReservation.setLastName(client.get().getLastName());
					vehicleReservation.setClientId(client.get().getId());
				}//end of client if
			});
		}//end of reservations if
		
		List<VehicleReservation> vehicleReservations = new ArrayList();
		for(Long vehicleId : vehicleReservationsMap.keySet()){
			vehicleReservations.add(vehicleReservationsMap.get(vehicleId));
		}
		return vehicleReservations;
	}

}
