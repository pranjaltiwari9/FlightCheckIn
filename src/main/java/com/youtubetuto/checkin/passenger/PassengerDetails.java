package com.youtubetuto.checkin.passenger;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PassengerDetails {
		@Id
		private int passengerid;
		
		private String passengername;
		private String flightdetails;
		private String dateoftravel;
		private long amount;
		private int baggageweight;
		public int getBaggageweight() {
			return baggageweight;
		}
		public void setBaggageweight(int baggageweight) {
			this.baggageweight = baggageweight;
		}
		public int getPassengerid() {
			return passengerid;
		}
		public void setPassengerid(int passengerid) {
			this.passengerid = passengerid;
		}
		public String getPassengername() {
			return passengername;
		}
		public void setPassengername(String passengername) {
			this.passengername = passengername;
		}
		public String getFlightdetails() {
			return flightdetails;
		}
		public void setFlightdetails(String flightdetails) {
			this.flightdetails = flightdetails;
		}
		public String getDateoftravel() {
			return dateoftravel;
		}
		public void setDateoftravel(String dateoftravel) {
			this.dateoftravel = dateoftravel;
		}
		
		public long getAmount() {
			return amount;
		}
		public void setAmount(long amount) {
			this.amount = amount;
		}
		
		public long updateAmount(long extracharge) {
			this.amount= this.amount + extracharge;
			return amount;
		}
		
		public void updateBaggageWeight(int checkinweight) {
			this.baggageweight= checkinweight;
		}
		
		@Override
		public String toString() {
			return "PassengerDetails [passengerid=" + passengerid + ", passengername=" + passengername
					+ ", flightdetails=" + flightdetails + ", dateoftravel=" + dateoftravel + ", amount=" + amount
					+ ", baggageweight=" + baggageweight + "]";
		}
		
	
		
		
		
}
