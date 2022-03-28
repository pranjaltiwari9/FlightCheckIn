package com.youtubetuto.checkin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youtubetuto.checkin.dao.PassengerDetailsRepo;
import com.youtubetuto.checkin.passenger.PassengerDetails;

@Service
public class CheckInServiceImpl implements CheckInService {
    
	@Autowired
	private PassengerDetailsRepo repositoryObj;
	
	@Override
	public List<PassengerDetails> getAllPassengers() {
		
		return repositoryObj.findAll();
	}

	@Override
	public Optional<PassengerDetails> getByPassengerID(int pid) {
		
		return repositoryObj.findById(pid);
	}

	@Override
	public Optional<PassengerDetails> getReceipt(int pid, int weight) {
		PassengerDetails checkweightobj = repositoryObj.findById(pid).orElse(new PassengerDetails());
		long extracharges;
		if(weight > 15 && weight <= 20) {
			extracharges=500;
		}
		else if(weight > 20 && weight <= 25) {
			extracharges=1000;
		}
		else if(weight > 25){
			extracharges=2000;
		}
		else {
			extracharges=0;
		}
		
		long newamount= checkweightobj.updateAmount(extracharges);
		checkweightobj.updateBaggageWeight(weight);
		repositoryObj.save(checkweightobj);
		System.out.println("The Updated Amount is:"+ newamount);
		return repositoryObj.findById(pid);
		
	}

	@Override
	public void cancelBooking(int pid) {
		PassengerDetails todelete = repositoryObj.findById(pid).orElse(new PassengerDetails());
		repositoryObj.delete(todelete);
	}

	@Override
	public void bookTicket(PassengerDetails passengerobj) {
		repositoryObj.save(passengerobj);
		System.out.print("hello");
	}

}
