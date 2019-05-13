package projectBackbone;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

import database.DBMethod;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;
import userInterface.AccountHistory;
import userInterface.AlertBox;
import userInterface.ForgotPasswordFinal;
import userInterface.ForgotPasswordNext;
import userInterface.ForgotPasswordPage;
import userInterface.HomePage;
import userInterface.HomepageAdmin;
import userInterface.MainMenu;
import userInterface.PUCBox;
import userInterface.RegisterWindow;
import userInterface.SearchOutbound;
import userInterface.SearchReturnFlights;
import userInterface.UpdateFlightsTable;
import userInterface.Welcome;

public class Method {
	
	//used to register a new User (Customer only right now)
	public static void registerUser(User u1) {
		
		// find out if it is a Customer (admin option is below)
		if (u1 instanceof Customer) {
			Customer c1 = (Customer) u1;
			
			// establish a connection with the database
			Connection conn = getConnection();
			
			// make an insert statement for the customer's information
			String insertUser = "INSERT INTO user(user_email, firstname, lastname, address, zipcode, username, "
					+ "password, ssn, security_question, secutity_answer) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			try {//create the statement that inserts the Customer's information into the database
				PreparedStatement preState = conn.prepareStatement(insertUser);
				
				// fill in the variables with the Customer's info
				preState.setString(1, c1.getEmail());
				preState.setString(2, c1.getFirstName());
				preState.setString(3, c1.getLastName());
				preState.setString(4, c1.getAddress());
				preState.setInt(5, c1.getZip());
				preState.setString(6, c1.getUserName());
				preState.setString(7, c1.getPassword());
				preState.setInt(8, c1.getsSN());
				preState.setString(9, c1.getSecurityQuestion());
				preState.setString(10, c1.getSecurityAnswer());
				
				// send the info to the database
				preState.executeUpdate();
				
				//close the connection
				conn.close();
						
				// a broad catch if anything goes wrong
			}catch (Exception e) {
				System.out.println("Exception in register User method");
				System.out.println(e);
			}
			
		}
		//find out if user is an Admin (Customer option is above)
		if (u1 instanceof Admin) {
			Admin a1 = (Admin) u1;
			
			// establish a connection with the database
			Connection conn = getConnection();
			
			// make an insert statement for the admin's information
			String insertUser = "INSERT INTO user(user_email, firstname, lastname, username, "
					+ "password, security_question, secutity_answer) values (?, ?, ?, ?, ?, ?, ?)";
			
			try {//create the statement that inserts the Admin's information into the database
				PreparedStatement preState = conn.prepareStatement(insertUser);
				
				// fill in the variables with the admin's info
				preState.setString(1, a1.getEmail());
				preState.setString(2, a1.getFirstName());
				preState.setString(3, a1.getLastName());
				preState.setString(4, a1.getUserName());
				preState.setString(5, a1.getPassword());
				preState.setString(6, a1.getSecurityQuestion());
				preState.setString(7, a1.getSecurityAnswer());
				
				// send the info to the database
				preState.executeUpdate();
				
				//close the connection
				conn.close();
		
				// a broad catch if anything goes wrong
			}catch (Exception e) {
				System.out.println("Exception in register User method");
				System.out.println(e);
			}
		
		}
	}

	//used to allow a User to login to the program
	public static User login(String userN, String pass) {
		
		// make sure the user name and password are not null
		if (userN != null && pass != null) {
			
		
			try {
				// establish a connection with the database
				Connection conn = getConnection();
				
				//create the statement that pulls the appropriate User information
				String loginStr = "SELECT * FROM user WHERE username = ? and password = ?";
				PreparedStatement preparedLogin = conn.prepareStatement(loginStr);
				
				// put in the values missing in the login statement above
				preparedLogin.setString(1, userN);
				preparedLogin.setString(2, pass);
				
				//execute the statement and get the results
				ResultSet results = preparedLogin.executeQuery();
					
				// keep only what is needed to create a User instance for the program to use
				String email = results.getString("user_email");
				String userName = results.getString("username");
				String firstName = results.getString("firstname");
				String lastName = results.getString("lastname");
				int accountType = results.getInt("accounttype");
					
				
				// find out if the user is an admin or customer, then make an instance of the class
				if (accountType == 1) {
					Admin a1 = new Admin(firstName, lastName, userName, email);
					
					return a1;
				}
				
				else {
					Customer c1 = new Customer(firstName, lastName, userName, email);
					
					return c1;
				}
			
			}// a broad catch if anything goes wrong
			catch (Exception e) {
				System.out.println(e);
			}
		}
		return null;
	}
	
	//used to connect to the database
	public static Connection getConnection() {
		
		try {
		//	the driver is not needed for the current version of JDK
	//		String driver = "com.mysql.jdbc.Driver";
	//		Class.forName(driver);
			String url = "jdbc:mysql://localhost:3306/demo";
			String name = "root";
			String pass = "toor";
			
			//The actual connection to the database 
			Connection conn = DriverManager.getConnection(url, name, pass);
			
			//lets the programmers know the connection has succeeded
			System.out.println("connected to database");
			
			//returns the connection to the caller 
			return conn;
			
			//A catch if the connection is not where the url says it should be
		}catch(NullPointerException npe) {
			System.out.println("database not found");
		
		}//a broad catch if anything else goes wrong
		catch(Exception e) {
			
		}
		
		//returns something if the try statement fails
		return null;
	}

	// used to get flights from the database
	public static ArrayList<Flights> SearchFlights(String cityA, String cityB) { 
		
		//make an ArrayList to store more then one flight
		ArrayList<Flights> flights = new ArrayList<>();
		
		try {
			// connect to the database
			Connection conn = Method.getConnection();
			
			//create the statement that pulls the appropriate Flights information
			String queryStr = "select * from flights where origin_city=? and destination_city=?";
			PreparedStatement preparedQuery = conn.prepareStatement(queryStr);
			
			// put in the values missing in the login statement above
			preparedQuery.setString(1, cityA);
			preparedQuery.setString(2, cityB);
			
			//pull the information from the database
			ResultSet result = preparedQuery.executeQuery();
			
			//loop until there are no more flights that match the query
			while(result.next()) {
				
				//get the information on a single flight
				String origin_city = result.getString("origin_city");
				String destination_city = result.getString("destination_city");
				String departure_time = result.getString("departure_time");
				Date departure_date = result.getDate("departure_date");
				int seats_available = result.getInt("seats_abailable");
				
				//make a flight instance with the information
				Flights f1 = new Flights(origin_city, destination_city, departure_date, departure_time, seats_available);
			
				// add the new flight to the flight ArrayList
				flights.add(f1);
			}
			//return the ArrayList full of flights
			return flights;
			
		}//a broad catch if anything else goes wrong
		catch (Exception e) {
			System.out.println(e);
		}
		//return null if something goes wrong
		return null;
		
		
	}

	public static int SearchFlights() {
		// TODO Auto-generated method stub
		return 0;
	}
public static void welcome(Stage stage) {
		
		Welcome login = new Welcome();
		 
		try {
			  login.start(stage);
		 
		}catch(Exception e1) {
			  e1.printStackTrace();
		  }
	}
	
	public static void mainMenu(Stage window) {
		
		MainMenu main = new MainMenu();
		try {
			main.start(window);
		}
		catch(Exception e2) {
			e2.printStackTrace();
		}
	}
	
	public static Object register(Stage window) {

		RegisterWindow registerwindow = new RegisterWindow(); 

		try {
			registerwindow.start(window);
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void forgotStage1 (Stage window) {
		
		try {
			ForgotPasswordPage forgotPage = new ForgotPasswordPage();
			
			forgotPage.start(window);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void forgotStage2 (Stage window, String name) {
		
		ForgotPasswordNext next = new ForgotPasswordNext();

		try { 
			next.start(window);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void homepageAdmin(Stage window, Admin a1) {
		HomepageAdmin homepage = new HomepageAdmin();
		
		try {
			homepage.start(window, a1);
		}
		catch (Exception e2) {
			e2.printStackTrace();
		}
	}

	public static void updateTable(Stage window, Admin a1) {
		
		UpdateFlightsTable updateTable = new UpdateFlightsTable();

		try {
		
			updateTable.start(window);
			
		}
		catch(Exception ufte) {
			System.out.println(ufte);
			ufte.printStackTrace();
		}
	}
	
	public static void searchReturn(Stage window, User u1) {
		
		SearchReturnFlights searchReturn = new SearchReturnFlights();
		
		try {
			searchReturn.start(window, u1);
		}
		catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
	public static void searchFlights(Stage window, User u1) {
		
		SearchOutbound searchFlights = new SearchOutbound();
		
		try {
			searchFlights.start(window, u1);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void homepage(Stage window, User u1) {
		
		HomePage homepage = new HomePage();
		try {
			homepage.start(window, u1);
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
	}
	
	public static void history(Stage window, User u1) {
		
		AccountHistory history = new AccountHistory();
		
		try {
			
			history.start(window, u1);
			
		}
		catch (Exception e) {
			e.printStackTrace();
			PUCBox.display();
		}
	}
	
	//used to check if the String contains only numbers
	public static boolean isInt(String number) {
		
		int length = number.length();
		
		for (int t = 0; t > length; t++) {
			if(number.charAt(t) > 9 || number.charAt(t) < 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean isValidPassword(String password) {
		final int LENGTH_OF_VALID_PASSWORD = 8;
		// Valid length of password
		final int MINIMUM_NUMBER_OF_DIGITS = 2;
		// Minimum digits it must contain

		boolean validPassword = 
		isLengthValid(password, LENGTH_OF_VALID_PASSWORD) && 
		isOnlyLettersAndDigits(password) &&
		hasNDigits(password, MINIMUM_NUMBER_OF_DIGITS);

		return validPassword;
		}

		/** Method isLengthValid tests whether a string is a valid length */
		public static boolean isLengthValid(String password, int validLength) {
		return password.length() >= validLength;
		}

		/** Method isOnlyLettersAndDigits tests if a string contains only letters
		and digits */
		public static boolean isOnlyLettersAndDigits(String password) {
			for (int i = 0; i < password.length(); i++) {
				if (!Character.isLetterOrDigit(password.charAt(i))) {
					return false;
				}
			}
			return true;
		}

		/** Method hasNDigits tests if a string contains at least n digits */
		public static boolean hasNDigits(String password, int n) {
			int numberOfDigits = 0;
			for (int i = 0; i < password.length(); i++) {
				if (Character.isDigit(password.charAt(i))) {
					numberOfDigits++;
				}
				if (numberOfDigits >= n) {
					return true;
				}
			}
		return false;
		}
	
	// used to make sure the new user entered all the needed information
	public static boolean checkRegistry(String first, String last,String user, String pass, String email, String question, String answer,
										String address, String state, String zip, String ssn) {
		if(first.length() == 0) {
			AlertBox.display("First Name", "You Must Enter a Name for \"First Name\"");
			return false;
		}
		
		if(last.length() == 0) {
			AlertBox.display("Last Name", "You Must Enter a Name for \"Last Name\"");
			return false;
		}
		if (user.length() == 0) {
			AlertBox.display("User Name", "You Must Enter a Name for \"User Name\"");
			return false;
		}
			
		if (DBMethod.userNameExists(user) || user.length() == 0) {
			AlertBox.display("User Name", "The User Name You Entered Already Exists");
			return false;
		}
		
		
		if (!isValidPassword(pass)) {
			AlertBox.display("Invalid Password", "Your Password Must Match or Surpass our Requirments");
			return false;
		}
		
		if (email.length() == 0) {
			AlertBox.display("E-Mail", "You must Enter an E-Mail Address for \"E-Mail\"");
			return false;
		}
		
		if (DBMethod.emailExists(email)) {
			AlertBox.display("E-Mail", "The User E-Mail You Entered Already Exists");
			return false;
		}
		
		if (question.equalsIgnoreCase("Select a Question")) {
			AlertBox.display("Security Question", "You Must Pick a Question");
			return false;
		}
		
		if (answer.length() == 0) {
			AlertBox.display("Security Answer", "You Must Enter Something for the Answer\nThis is for Your Own Good");
			return false;
		}
		
		if (address.length() == 0) {
			AlertBox.display("Address", "You Must Enter an Address for \"Address\"");
			return false;
		}
		
		if (state.length() == 0) {
			AlertBox.display("State", "You Must Enter a State for \"State\"");
			return false;
		}
		
		if (!isInt(zip) || zip.length() == 0) {
			AlertBox.display("Zip Code", "You Must Enter a valid Zip Code for \"Zip Code\"");
			return false;
		}
		
		if (!isInt(ssn) || ssn.length() != 9) {
			AlertBox.display("Social Security Number", "You Must Enter a valid Social Security Number for \"Social Security Number\"");
			return false;
		}
		
		
		return true;
	}

	
	public static boolean bookFlight(User u1, Flights f1) {
		
		try {
		
		DBMethod.isBooked(u1, f1);
		
		int seats = DBMethod.checkSeats(f1);
		
		if(seats > 0) {
			seats -= 1;
			if(DBMethod.book(u1, f1, seats)) {
				return true;
			}
		}
		}
		catch (ClassCastException cce) {
			PUCBox.display();
			cce.printStackTrace();
		}
		return false;
	}
	
	
	public static Flights makeFlight(String airline, String originCity, String destinationCity, String flightCapacityStr, 
			String flightNumberStr, LocalDate dateHereLD, LocalDate dateThereLD, String departureTime, String arrivalTime, 
			String seatsAvailableStr, CheckBox isFilledBox) {
		
		int flightCapacity = 0, seatsAvailable = 0, flightNumber = 0;
		
		boolean isFilled;
		
		Date departureDate = null, arrivalDate = null;
		
		if (isInt(flightCapacityStr)){
			flightCapacity = Integer.parseInt(flightCapacityStr);
		}
		
		if (isInt(seatsAvailableStr)) {
			seatsAvailable = Integer.parseInt(seatsAvailableStr);
		}
		
		if (isInt(flightNumberStr)) {
			flightNumber = Integer.parseInt(flightNumberStr);
		}
		
		if (isFilledBox.isSelected()) {
			isFilled = true;
		}
		else {
			isFilled = false;
		}
		
		departureDate = Date.valueOf(dateHereLD);
		
		arrivalDate = Date.valueOf(dateThereLD);
		
		Flights f1 = new Flights();
	
		return f1;
	}

	public static void forgotStage3(Stage window, String name, String pass) {
		ForgotPasswordFinal forgotFinal = new ForgotPasswordFinal();
		
		try {
			forgotFinal.start(window);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}


}


