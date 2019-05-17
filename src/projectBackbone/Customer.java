package projectBackbone;

import java.sql.*;
import java.util.ArrayList;

import javafx.collections.ObservableList;


public class Customer extends User {

	private String address;
	
	private String state;
	
	private int zip;
	
	private int sSN;  
	
	private int accountType = 0;
	
	Customer(){
		
	}
	
	public Customer(String firstN, String lastN, String userN, String pass, String email, String securityQ, String securityA, String address, String state, int zip, int sSN){
		super(firstN, lastN, userN, pass, email, securityQ, securityA);
		this.address = address;
		this.state = state;
		this.zip = zip;
		this.sSN = sSN;
	}
	
	public Customer(String firstName, String lastName, String userName, String email) {
		// TODO Auto-generated constructor stub
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public int getsSN() {
		return sSN;
	}

	public void setsSN(int sSN) {
		this.sSN = sSN;
	}
	
	@Override
	public String getPassword() { // use to give the user their password when they forget only if they have securityAnswer
		// details unknown
		
		return super.getPassword();
	}
	
	@Override
	public void bookFlight() { // use to register a user (and friends) on a flight
		// details unknown
		
	}
	
	@Override
	public void removeFlight(Object flight) {// use to remove a booking from a flight
		// details unknown
		
	}

	@Override
	public ArrayList<Flights> getFlight() { 
		
		ArrayList<Flights> f1 = new ArrayList<Flights>(Method.SearchFlights());
		
		if (f1.isEmpty()) {
			return null;
		}
	
		return f1;
	}
	
	public void register(Customer c1) {

		try {
			//use method in Method to register the Customer
			Method.registerUser(c1);
			
		}
		catch (Exception e){
			System.out.println("There was a problem registering");
			System.out.println(e);
		}

	}

	public int getAccountType() {
		// TODO Auto-generated method stub
		return 0;
	}


}