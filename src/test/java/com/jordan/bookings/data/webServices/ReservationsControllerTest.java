package com.jordan.bookings.data.webServices;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.jordan.bookings.business.domains.VehicleReservation;
import com.jordan.bookings.business.services.ReservationService;

import static org.mockito.BDDMockito.given;
import static org.hamcrest.CoreMatchers.containsString;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(ReservationsController.class)
public class ReservationsControllerTest {
	
	@MockBean
	private ReservationService reservationService;
	
	@Autowired
	private MockMvc mockMvc;
	
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	
	@Test
	public void getReservations() throws Exception {
		Date date = DATE_FORMAT.parse("2019-01-01");
		List<VehicleReservation> mockVehicleReservationsList = new ArrayList();
		VehicleReservation mockVehicleReservation = new VehicleReservation();
		mockVehicleReservation.setClientId(1L);
		mockVehicleReservation.setFirstName("JORDAN");
		mockVehicleReservation.setLastName("HOOVER");
		mockVehicleReservation.setVehicleId(1L);
		mockVehicleReservation.setDate(date);
		mockVehicleReservation.setVehicleModel("FORD");
		mockVehicleReservation.setVehicleType("MUSTANG");
		mockVehicleReservationsList.add(mockVehicleReservation);
		
		given(reservationService.getVehicleReservationsForDate(date)).willReturn(mockVehicleReservationsList);
		
		this.mockMvc.perform(get("/reservations?date=2019-01-01")).andExpect(status().isOk()).andExpect(content()
				.string(containsString("JORDAN, HOOVER")));
		
		
	}

}
