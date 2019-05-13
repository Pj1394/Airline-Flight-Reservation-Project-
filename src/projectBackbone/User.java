package projectBackbone;



public abstract class User {

	private String firstName;
	
	private String lastName;
	
	private String userName;
	
	private String password;
	
	private String email;
	
	private String securityQuestion;  
									
	private String securityAnswer;
	
	int accountType;
	
	User(){
		
	}
	
	User (String firstN, String lastN, String userN, String email){
		firstName = firstN;
		lastName = lastN;
		userName = userN;
		this.email = email;
	}
	
	User(String firstN, String lastN, String userN, String pass, String email, String securityQ, String securityA){
		firstName = firstN;
		lastName = lastN;
		userName = userN;
		password = pass;
		this.email = email;
		securityQuestion = securityQ;
		securityAnswer = securityA;
		
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}
	
	public String getSecurityAnswer() {
		return securityAnswer;
	}
	
	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() { 
		return this.password;
	}
	
	public abstract void bookFlight();// use to register a user (and friends) on a flight
		// details unknown
	
	public abstract void removeFlight(Object flight); // use to remove a booking from a flight
		// details unknown
	
	public abstract Object getFlight(); // use to get flights from the database

}
