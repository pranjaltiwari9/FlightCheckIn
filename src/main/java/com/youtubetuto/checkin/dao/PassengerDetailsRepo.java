package com.youtubetuto.checkin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.youtubetuto.checkin.passenger.PassengerDetails;

public interface PassengerDetailsRepo extends JpaRepository<PassengerDetails, Integer>{
	

}
