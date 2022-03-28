package com.youtubetuto.checkin;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.youtubetuto.checkin.dao.PassengerDetailsRepo;
import com.youtubetuto.checkin.passenger.PassengerDetails;

import java.util.List;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class FlightCheckinReceiptApplicationTests {

	@Autowired
	PassengerDetailsRepo testrepo;
	
	@Test
	@Order(1)
	void repositorytesting() {
		PassengerDetails testobject= new PassengerDetails();
		testobject.setAmount(1000);
		testobject.setBaggageweight(10);
		testobject.setDateoftravel("7 April 2022");
		testobject.setFlightdetails("Paris to Berlin");
		testobject.setPassengerid(1);
		testobject.setPassengername("Vikrant Thakur");
		testrepo.save(testobject);
		assertNotNull(testrepo.findById(1).get());
		
	}
	
	@Test
	@Order(2)
	public void testGetPassengerDetails() {
		PassengerDetails testobj= testrepo.findById(1104).get();
		assertEquals("Junaid Ahsan", testobj.getPassengername());
	}
	
	@Test
	@Order(3)
	public void testGetAllPassengers() {
		List<PassengerDetails> testlist= testrepo.findAll();
		assertThat(testlist).size().isGreaterThan(0);
	}
	
	@Test
	@Order(4)
	public void testGetReceipt() {
		PassengerDetails testobject= new PassengerDetails();
		testobject.setAmount(1000);
		testobject.setBaggageweight(10);
		testobject.setDateoftravel("7 April 2022");
		testobject.setFlightdetails("Paris to Berlin");
		testobject.setPassengerid(2);
		testobject.setPassengername("Vikrant Thakur");
		testrepo.save(testobject);
		
		PassengerDetails checkupdate= testrepo.findById(2).get();
		checkupdate.setFlightdetails("Kyiv to Moscow");
		testrepo.save(checkupdate);
		assertEquals("Kyiv to Moscow",testrepo.findById(2).get().getFlightdetails());
	}
	
	@Test
	@Order(5)
	public void testCancelBooking() {
		testrepo.deleteById(1104);
		assertThat(testrepo.existsById(1104)).isFalse();
	}
	
	
}
