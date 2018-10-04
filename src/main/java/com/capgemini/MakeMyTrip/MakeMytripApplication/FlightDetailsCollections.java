package com.capgemini.MakeMyTrip.MakeMytripApplication;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;

public class FlightDetailsCollections  {
	
	private static ArrayList<FlightDetails> listOfFlights=new ArrayList<FlightDetails>();;
	
	
	 public static void addFlights(FlightDetails flight)
	 {
		 listOfFlights.add(flight);
	 }
	 public static ArrayList<FlightDetails> getAllFlights()
	 {
		 return listOfFlights;
	 }
	 public static ArrayList<FlightDetails> removeFlights(int flightId) throws FlightNotFoundException
	 {
		 for(FlightDetails flight:listOfFlights)
		 {
			 if(flight.getFlightId()==flightId) {
				 listOfFlights.remove(flight);
				 return listOfFlights;
		 }
		 }
			 throw new FlightNotFoundException("Given Flight Id does not Exist");
	 }
	 
	 public static ArrayList<FlightDetails> sortByFare(String source,String destination)
	 {
		 ArrayList<FlightDetails> CheapFlight=new ArrayList();
		 listOfFlights.sort((flight1, flight2)->flight1.getFlightFare()-flight2.getFlightFare());
		 for(FlightDetails flight:listOfFlights)
		 {
			 if(flight.getSourceCity().equals(source) && (flight.getDestinationCity().equals(destination)))
					 CheapFlight.add(flight);
		 }
		return CheapFlight;
		
	 }
	 
	 public static ArrayList<FlightDetails> sortByDuration(String source,String destination)
	 {
		 ArrayList<FlightDetails> ShortFlight=new ArrayList();
		 listOfFlights.sort((flight1, flight2)->flight1.getDuration()-flight2.getDuration());
		 for(FlightDetails flight:listOfFlights)
		 {
			 if(flight.getSourceCity().equals(source) && (flight.getDestinationCity().equals(destination)))
					 ShortFlight.add(flight);
		 }
		
		return ShortFlight;
		
	 }
	 public static ArrayList<FlightDetails> filterMorningFlights(String source,String destination)
	 {
		 ArrayList<FlightDetails> MornFlight=new ArrayList();
		 for(FlightDetails flight:listOfFlights)
		 {
			 if(flight.getDepartureTime().getHour()>6 && flight.getDepartureTime().getHour()<12 && flight.getSourceCity().equals(source) && (flight.getDestinationCity().equals(destination)))
			 {
				 MornFlight.add(flight);
			 }
		 }
		 return MornFlight;
	 }
	 
	 public static ArrayList<FlightDetails> filterAfterNoonFlights(String source,String destination)
	 {
		 ArrayList<FlightDetails> AftFlight=new ArrayList();
		 for(FlightDetails flight:listOfFlights)
		 {
			 if(flight.getDepartureTime().getHour()>12 && flight.getDepartureTime().getHour()<17 && flight.getSourceCity().equals(source) && (flight.getDestinationCity().equals(destination)))
			 {
				 AftFlight.add(flight);
			 }
		 }
		 return AftFlight;
	 }
	 
	 public static ArrayList<FlightDetails> filterEvenFlights(String source,String destination)
	 {
		 ArrayList<FlightDetails> EvenFlight=new ArrayList();
		 for(FlightDetails flight:listOfFlights)
		 {
			 if(flight.getDepartureTime().getHour()>17 && flight.getDepartureTime().getHour()<21 && flight.getSourceCity().equals(source) && (flight.getDestinationCity().equals(destination)))
			 {
				 EvenFlight.add(flight);
			 }
		 }
		 return EvenFlight;
	 }
	 
	 public static ArrayList<FlightDetails> filterNightFlights(String source,String destination)
	 {
		 ArrayList<FlightDetails> EvenFlight=new ArrayList();
		 for(FlightDetails flight:listOfFlights)
		 {
			 if(flight.getDepartureTime().getHour()>21 && flight.getDepartureTime().getHour()<23 && flight.getSourceCity().equals(source) && (flight.getDestinationCity().equals(destination)))
			 {
				 EvenFlight.add(flight);
			 }
		 }
		 return EvenFlight;
	 }
	 
	 public static ArrayList<FlightDetails> updateFlightDetails(int flightNo,LocalTime arrivalTime,LocalTime DepartureTime) throws FlightNotFoundException{
         for(FlightDetails fly : listOfFlights){
                if(fly.getFlightId()==flightNo){
                      fly.setArrivalTime(arrivalTime);
                      fly.setDepartureTime(DepartureTime);
                      
                }
                return listOfFlights;
  }throw new FlightNotFoundException("flight doesnt exist");
  }
  
	 public static ArrayList<FlightDetails> updateFlightDetailsVer_2(int flightNo,String DestnCity) throws FlightNotFoundException{
         for(FlightDetails fly : listOfFlights){
                if(fly.getFlightId()==flightNo){
                      
                      fly.setDestinationCity(DestnCity);
                      
                }
                return listOfFlights;
  }throw new FlightNotFoundException("flight doesnt exist");
  }
  
	 
	 
	 
	 
	 
	 public static void main(String[] args) {
		 
		 
		 FlightDetails flight1=new FlightDetails("AirIndia", 2000,LocalTime.of(23,0,0,0), LocalTime.of(21,0,0,0), "Kolkata", "Bangalore", 2);
		 FlightDetails flight2=new FlightDetails("AirIndia", 5000,LocalTime.of(9,0,0,0), LocalTime.of(6,0,0,0), "Kolkata", "Bangalore", 8);
		 FlightDetails flight3=new FlightDetails("AirIndia", 7000,LocalTime.of(12,0,0,0), LocalTime.of(10,0,0,0), "Kolkata", "Mumbai", 4);
		 FlightDetails flight4=new FlightDetails("AirIndia", 9000,LocalTime.of(17,0,0,0), LocalTime.of(15,0,0,0), "Kolkata", "Bangalore", 5);
		 FlightDetails flight5=new FlightDetails("AirIndia", 8000,LocalTime.of(19,0,0,0), LocalTime.of(10,0,0,0), "Kolkata", "Bangalore", 6);
		 FlightDetails flight6=new FlightDetails("AirIndia", 6000,LocalTime.of(21,0,0,0), LocalTime.of(21,0,0,0), "Kolkata", "Siliguri", 1);
		 
		 
		 FlightDetailsCollections.addFlights(flight1);
		 FlightDetailsCollections.addFlights(flight2);
		 FlightDetailsCollections.addFlights(flight3);
		 FlightDetailsCollections.addFlights(flight4);
		 FlightDetailsCollections.addFlights(flight5);
		 FlightDetailsCollections.addFlights(flight6);
		 
		 for(FlightDetails fly:FlightDetailsCollections.getAllFlights())
			 System.out.println(fly);
		 
		
		 System.out.println("==========================================================");
		 for(FlightDetails fly:FlightDetailsCollections.sortByFare("Kolkata", "Bangalore"))
			 System.out.println(fly);
		 System.out.println("==========================================================");
		 for(FlightDetails fly:FlightDetailsCollections.sortByDuration("Kolkata", "Bangalore"))
			 System.out.println(fly);
		 System.out.println("==========================================================");
		 for(FlightDetails fly:FlightDetailsCollections.filterMorningFlights("Kolkata", "Bangalore"))
			 System.out.println(fly);
		 System.out.println("==========================================================");
		 for(FlightDetails fly:FlightDetailsCollections.filterAfterNoonFlights("Kolkata", "Bangalore"))
			 System.out.println(fly);
	}

}
