package projectBackbone;


public class Admin extends User {
	
		private int accountType = 1;
		
	Admin(){
		
	}
	
	public Admin(String firstN, String lastN, String userN, String email){
		super(firstN, lastN, userN, email);
		
	}
		
	Admin(String firstN, String lastN, String userN, String pass, String email, String securityQ, String securityA){
		super(firstN, lastN, userN, pass, email, securityQ, securityA);
	}
	
	@Override
	public void bookFlight() { // use to register a user (and friends) on a flight
		// details unknown
		
	}
	
	@Override
	public void removeFlight(Object flight) { // use to remove a booking from a flight
		// details unknown
		
	}
	
	@Override
	public Object getFlight() { // use to get flights from the database
		// details unknown
		return null;
	}
	
	public void addFlight() { // use to add flights to the database
		// details unknown
	}
	
	public void updateFlight() { // use to update flight details in the database
		// details unknown
	}
	
	public void deleteFlight(){ // use to remove flights from the database
		// details unknown
	}
	
	public void register(Admin a1) {
		
			Method.registerUser(a1);
	}
	
}
