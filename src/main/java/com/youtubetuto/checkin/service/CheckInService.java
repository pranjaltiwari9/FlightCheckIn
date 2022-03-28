package com.youtubetuto.checkin.service;

import java.util.List;
import java.util.Optional;

import com.youtubetuto.checkin.passenger.PassengerDetails;

public interface CheckInService {
	
	public List<PassengerDetails> getAllPassengers();
	public Optional<PassengerDetails> getByPassengerID(int pid);
	public Optional<PassengerDetails> getReceipt(int pid, int weight);
	public void cancelBooking(int pid);
	public void bookTicket(PassengerDetails passengerobj);
}
