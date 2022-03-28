package com.youtubetuto.checkin.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.youtubetuto.checkin.passenger.PassengerDetails;
import com.youtubetuto.checkin.service.CheckInService;


@RestController
public class CheckInController {
	
	@Autowired
	private CheckInService serviceObj;
	
	@GetMapping("/")
	public String homepage()
	{
		String welcomemsg= "WELCOME! GET YOUR FLIGHT RECEIPT AT CHECK-IN: \nNOTE-\nUSE /passenger/{passengerID}/{baggageweight} TO GET RECEIPT\nUSE /passenger/{passengerID} TO CANCEL BOOKING";
		return welcomemsg;
	}
	
	@GetMapping("/passenger/{passengerID}")
	public Optional<PassengerDetails> getPassengerDetails(@PathVariable("passengerID") int passengerid)
	{
		return serviceObj.getByPassengerID(passengerid);
	}
	
	@GetMapping("/passengers")
	public List<PassengerDetails> getAllPassengers()
	{
		return serviceObj.getAllPassengers();
	}
	
	@PutMapping("/bookyourticket")
	public String bookTicket(@RequestBody PassengerDetails newpassenger) {
		serviceObj.bookTicket(newpassenger);
		return "REGISTRATION SUCCESSFUL!";
		
	}
	
	@PutMapping("/passenger/{passengerID}/{baggageweight}")
	public Optional<PassengerDetails> getReceipt(@PathVariable("passengerID") int passengerID, @PathVariable("baggageweight") int weight)
	{
		
		return serviceObj.getReceipt(passengerID, weight);
	}
	
	@DeleteMapping("passenger/{passengerID}")
	public String cancelBooking(@PathVariable("passengerID") int passengerid){
		try {
			serviceObj.cancelBooking(passengerid);
			return "BOOKING CANCELLED SUCCESSFULLY..";
		} catch (Exception e) {
			return "<--- INVALID PASSENGER ID --->";
		}
	}
	
}







