package com.jordan.bookings.data.webServices;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jordan.bookings.business.domains.VehicleReservation;
import com.jordan.bookings.business.services.ReservationService;

@Controller
@RequestMapping(value = "/reservations")
public class ReservationsController {
	
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat ("yyyy-MM-dd");
	
	@Autowired
	private ReservationService reservationService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getReservations(@RequestParam(value = "date", required = false) String dateString, Model model) {
		Date date = null;
		if(dateString != null) {
			try {
				date = DATE_FORMAT.parse(dateString);
			}
			catch(ParseException e){
				date = new Date();
				e.printStackTrace();
			}
		}else {
			date = new Date();
		}
		List<VehicleReservation> vehiclesReservationList = this.reservationService.getVehicleReservationsForDate(date);
		model.addAttribute("vehicleReservations", vehiclesReservationList);
		return "reservations";
	}
}
