package database;



import java.sql.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import projectBackbone.Admin;
import projectBackbone.Customer;
import projectBackbone.Flights;
import projectBackbone.Method;
import projectBackbone.User;
import userInterface.AlertBox;
import userInterface.PUCBox;


public class DBMethod {

	public static void createFlightTable() {
		try {
			Connection conn = projectBackbone.Method.getConnection();
			
			PreparedStatement create = conn.prepareStatement("CREATE TABLE IF NOT EXISTS flight(id int NOT NULL, numberflight int, "
					+ "airline varchar(30), origin_city varchar(30), destination_city varchar(30), departure_time varchar(30), "
					+ "arrival_time varchar(30), departure_date date, arrival_date date, capactiy int, seats_available int, "
					+ "seats_occupied int, isfull int, PRIMARY KEY(id))");
				
			create.executeUpdate();
			
			conn.close();
			
		}catch (NullPointerException npe) {
			System.out.println(npe);
			System.out.println("something went wrong with create table");
		}
		catch (Exception e) {
			System.out.println(e);
			System.out.println("problem caught by exception");
		}
		finally {
			System.out.println("Done");
		}
		
		
	}
	
	public static void createUserTable() {
		try {
			Connection conn = Method.getConnection();
			
			PreparedStatement create = conn.prepareStatement("CREATE TABLE IF NOT EXISTS user(user_email varchar(40) NOT NULL PRIMARY KEY, "
					+ "firstname varchar(30), lastname varchar(30), address varchar(30), zipcode int(5), username varchar(30), "
					+ "password varchar(15), ssn varchar(9), security_question varchar(90), security_answer varchar(90),accounttype int(1))");
			
			
		create.executeUpdate();
		
		conn.close();
		
		}catch (NullPointerException npe) {
			System.out.println(npe);
			System.out.println("something went wrong with create table");
		}
		catch (Exception e) {
			System.out.println(e);
			System.out.println("problem caught by exception");
		}
		finally {
			System.out.println("Done");
		}
		
	}
	
	public static void createTicketTable() {
		try {
			Connection conn = Method.getConnection();
			
			PreparedStatement create = conn.prepareStatement("CREATE TABLE IF NOT EXISTS ticket(User_email varchar(40), flightid int(6), "
					+ "PRIMARY KEY (user_email, flightid))");
			
			create.executeUpdate();
			
			conn.close();
			
		}catch (NullPointerException npe) {
			System.out.println(npe);
			System.out.println("something went wrong with create table");
		}
		catch (Exception e) {
			System.out.println(e);
			System.out.println("problem caught by exception");
		}
		finally {
			System.out.println("Done");
			}
	}
		
		// backup of the Flight table format, data is in a different method
		public static void fillUserTable() {
		try {
			//establish a connection with the database
			Connection conn = getConnection();
				
			//prepare a statement for the data
			PreparedStatement fill = conn.prepareStatement("INSERT INTO user(user_email, firstname, lastname, address, zipcode, state, username,"
					+ " password, ssn, security_question, security_answer, accounttype) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
				
			//fill in the variables for the first set
			fill.setString(1, "veronica2004@hotmail.com");
			fill.setString(2, "Yvonne");
			fill.setString(3, "Baughn");
			fill.setString(4, "3693 Yorkie Lane, Brunswick");
			fill.setInt(5,  31520);
			fill.setString(6, "Georgia");
			fill.setString(7, "retta_bali1977");
			fill.setString(8, "Zaa9ki5ieg");
			fill.setString(9,  "912777696");
			fill.setString(10, "What was the name of your first stuffed animal");
			fill.setString(11, "Lammy");
			fill.setInt(12, 0);
				
			//send the data to the database
			fill.executeUpdate();
			
			//fill in the variables for the second set
			fill.setString(1, "arvel1983@gmail.com");
			fill.setString(2, "Helen");
			fill.setString(3, "Alderman");
			fill.setString(4, "3154 Mount Olive Road");
			fill.setInt(5,  30303);
			fill.setString(6, "Georgia");
			fill.setString(7, "lucas_hintz");
			fill.setString(8, "shei5eiW9moh");
			fill.setString(9,  "678807220");
			fill.setString(10, "In what city or town did your mother and father meet");
			fill.setString(11, "Lilburn");
			fill.setInt(12, 0);
			
			//send the data to the database
			fill.executeUpdate();
			
			//fill in the variables for the third set
			fill.setString(1, "laverne_damo@hotmail.com");
			fill.setString(2, "Carl");
			fill.setString(3, "Oliver");
			fill.setString(4, "4050 Junior Avenue");
			fill.setInt(5,  30097);
			fill.setString(6, "Georgia");
			fill.setString(7, "mishalq8");
			fill.setString(8, "aith8Iete2Y");
			fill.setString(9,  "404672243");
			fill.setString(10, "Where were you when you had your first kiss");
			fill.setString(11, "Movie theater");
			
			//send the data to the database
			fill.executeUpdate();
			
			//fill in the variables for the fourth set
			fill.setString(1, "cecelia.considi@hotmail.com");
			fill.setString(2, "Blanca");
			fill.setString(3, "Ross");
			fill.setString(4, "1597 D Street");
			fill.setInt(5,  48302);
			fill.setString(6, "Michigan");
			fill.setString(7, "sirmuja");
			fill.setString(8, "Hee0JeeGo");
			fill.setString(9,  "586567213");
			fill.setString(10, "In what city or town was your first job");
			fill.setString(11, "Los Angeles");
			
			//send the data to the database
			fill.executeUpdate();
			
			//fill in the variables for the fifth set
			fill.setString(1, "deondre1999@yahoo.com");
			fill.setString(2, "William");
			fill.setString(3, "Gorman");
			fill.setString(4, "908 Brown Avenue");
			fill.setInt(5,  29607);
			fill.setString(6, "South Carolina");
			fill.setString(7, "lysanne.tr1971");
			fill.setString(8, "Oofai6kah");
			fill.setString(9,  "864982131");
			fill.setString(10, "In what city or town was your first job");
			fill.setString(11, "Hometown");
			
			//send the data to the database
			fill.executeUpdate();
			
			//fill in the variables for the sixth set
			fill.setString(1, "te1995@gmail.com");
			fill.setString(2, "Christine");
			fill.setString(3, "Carter");
			fill.setString(4, "2380 Locust Street,");
			fill.setInt(5, 31701);
			fill.setString(6,  "Goergia");
			fill.setString(7, "dimondedsword");
			fill.setString(8, "AeQuigail9qu");
			fill.setString(9,  "229691298");
			fill.setString(10, "In what city or town did your mother and father meet");
			fill.setString(11, "London");
			
			//send the data to the database
			fill.executeUpdate();
			
			//fill in the variables for the seventh set
			fill.setString(1, "mattie1976@hotmail.com");
			fill.setString(2, "Lucile");
			fill.setString(3, "Raper");
			fill.setString(4, "225 Sharon Lane");
			fill.setInt(5,  46544);
			fill.setString(6, "Indiana");
			fill.setString(7, "margarita.1975");
			fill.setString(8, "Iejoon9Iet9");
			fill.setString(9,  "574291805");
			fill.setString(10, "What was the name of your first stuffed animal");
			fill.setString(11, "Big Bear");
			
			//send the data to the database
			fill.executeUpdate();
			
			//fill in the variables for the eighth set
			fill.setString(1, "marilou_jer@hotmail.com");
			fill.setString(2, "Ronald");
			fill.setString(3, "Notron");
			fill.setString(4, "3015 Badger Pond Lane");
			fill.setInt(5,  33607);
			fill.setString(6, "Florida");
			fill.setString(7, "hook");
			fill.setString(8, "aw8HeiPhei");
			fill.setString(9,  "707377325");
			fill.setString(10, "In what city or town did your mother and father meet");
			fill.setString(11, "At Sea");
			
			//send the data to the database
			fill.executeUpdate();
			
			//fill in the variables for the ninth set
			fill.setString(1, "isadore_kri5@gmail.com");
			fill.setString(2, "Susan");
			fill.setString(3, "Crist");
			fill.setString(4, "959 Hiddenview Drive");
			fill.setInt(5,  19108);
			fill.setString(6, "Philadelphia");
			fill.setString(7, "reta");
			fill.setString(8, "Ohtahru3");
			fill.setString(9,  "215954621");
			fill.setString(10, "Where were you when you had your first kiss");
			fill.setString(11, "Behind the 12th grade cabin");
			
			//send the data to the database
			fill.executeUpdate();
			
			//fill in the variables for the tenth set
			fill.setString(1, "cleve2014@hotmail.com");
			fill.setString(2, "Steven");
			fill.setString(3, "McLean");
			fill.setString(4, "937 Winding Way");
			fill.setInt(5, 20904);
			fill.setString(6, "Maryland");
			fill.setString(7, "NerdinhoPlayer");
			fill.setString(8, "le6yo2aiT3oh");
			fill.setString(9,  "401668699");
			fill.setString(10, "In what city or town was your first job");
			fill.setString(11, "Albany, New York");
			
			//send the data to the database
			fill.executeUpdate();
			
			//fill in the variables for the first admin set
			fill.setString(1, "pfowler2@student.gsu.edu");
			fill.setString(2, "Peter");
			fill.setString(3, "Fowler");
			fill.setString(4, "null");
			fill.setInt(5,  0);
			fill.setString(6, null);
			fill.setString(7, "pfowler2");
			fill.setString(8, "AdminPass123");
			fill.setString(9,  "null");
			fill.setString(10, "In what city or town was your first job");
			fill.setString(11, "Atlanta");
			fill.setInt(12, 1);
			
			//send the data to the database
			fill.executeUpdate();
				
			System.out.println("worked");
				
			//close the connection to the database
			conn.close();
			
			}
			catch (NullPointerException npe) {
				System.out.println(npe);
				System.out.println("something went wrong with finding the table");
			}
			catch (Exception e) {
				System.out.println(e);
				System.out.println("problem caught by exception");
			}
			finally {
				System.out.println("Done");
				
			}
		}

		public static void fillFlightTable() {
			try {
				//establish a connection with the database
				Connection conn = getConnection();
				
				//prepare a statement for the data
				PreparedStatement fill = conn.prepareStatement("INSERT INTO flights(numberflight, airline, origin_city, destination_city,"
						+ " departure_time, arrival_time, departure_date, arrival_date, capactiy, seats_available, seats_occupied, isfull)"
						+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
				
				//fill in the values for the data
				fill.setInt(1, 001);
				fill.setString(2, "Delta");
				fill.setString(3, "Atlanta");
				fill.setString(4, "New York");
				fill.setString(5, "7:00 am");
				fill.setString(6, "9:17 am");
				fill.setDate(7, Date.valueOf("2019-5-26"));
				fill.setDate(8, Date.valueOf("2019-5-26"));
				fill.setInt(9, 15);
				fill.setInt(10, 15);
				fill.setInt(11, 0);
				fill.setBoolean(12, false);
		
				//send the information to the database
				fill.executeUpdate();
				
				//close the connection to the database
				conn.close();
				
			}catch (NullPointerException npe) {
				System.out.println(npe);
				System.out.println("something went wrong with create table");
			}
			catch (Exception e) {
				System.out.println(e);
				System.out.println("problem caught by exception");
			}
			finally {
				System.out.println("Done");
				}
			}

		//used to register a new User (Customer only right now)
		public static void registerUser(User u1) {
				
			// find out if it is a Customer (admin option is below)
			if (u1 instanceof Customer) {
				Customer c1 = (Customer) u1;
					
				// establish a connection with the database
				Connection conn = getConnection();
					
				// make an insert statement for the customer's information
				String insertUser = "INSERT INTO user(user_email, firstname, lastname, address, zipcode, state, username, "
						+ "password, ssn, security_question, security_answer, accounttype) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				
				try {//create the statement that inserts the Customer's information into the database
					PreparedStatement preState = conn.prepareStatement(insertUser);
					
					// fill in the variables with the Customer's info
					preState.setString(1, c1.getEmail());
					preState.setString(2, c1.getFirstName());
					preState.setString(3, c1.getLastName());
					preState.setString(4, c1.getAddress());
					preState.setInt(5, c1.getZip());
					preState.setString(6, c1.getState());
					preState.setString(7, c1.getUserName());
					preState.setString(8, c1.getPassword());
					preState.setInt(9, c1.getsSN());
					preState.setString(10, c1.getSecurityQuestion());
					preState.setString(11, c1.getSecurityAnswer());
					preState.setInt(12, c1.getAccountType());
					
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
			if (userN.length() > 0 && pass.length() >= 7) {
					
				
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
						
					while (results.next()) {
						// keep only what is needed to create a User instance for the program to use
						String email = results.getString("user_email");
						String userName = results.getString("username");
						String firstName = results.getString("firstname");
						String lastName = results.getString("lastname");
						int accountType = results.getInt("accounttype");
						
					
						// find out if the user is an admin or customer, then make an instance of the class
						if (accountType == 1) {
							Admin a1 = new Admin(firstName, lastName, userName, email);
							
							//close the database connection
							conn.close();
						
							return a1;
						}
					
						else {
							Customer c1 = new Customer(firstName, lastName, userName, email);
							
							//close the database connection
							conn.close();
						
							return c1;
						}
					}
				}
				catch (SQLException sqle) {
					AlertBox.display("Invalid UserName or Password", "The User Name and/or Password is Incorrect");
					sqle.printStackTrace();
				}
				catch (NullPointerException npe) {
					AlertBox.display("Invalid UserName or Password", "The User Name and/or Password is Incorrect");
					npe.printStackTrace();
				}// a broad catch if anything goes wrong
				catch (Exception e) {
					AlertBox.display("Invalid UserName or Password", "The User Name and/or Password is Incorrect");
					e.printStackTrace();
				}
			}
			AlertBox.display("User Name / Password Missing", "You Can Only Enter BMP Travel If You Are a Registered Member");
			return null;
		}
			
		//used to connect to the database
		public static Connection getConnection() {
				
			try {
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
		public static ObservableList<Flights> searchFlights() { 
				
			//make an ObservableList to store more then one flight
			ObservableList<Flights> flights = FXCollections.observableArrayList();
				
			try {
				// connect to the database
				Connection conn = getConnection();
					
				//unknown statement for unknown reasons (to be looked into)
				Statement Stmt = conn.createStatement();
					
				//select from the database
				ResultSet result = Stmt.executeQuery("select * from flights");
					
				//loop until there are no more flights that match the query
				while(result.next()) {
						
					//get the information on a single flight
					String airline = result.getString("airline");
					String origin_city = result.getString("origin_city");
					String destination_city = result.getString("destination_city");
					int flightCapacity = result.getInt("capactiy");
					int seats_available = result.getInt("seats_available");
					int flightNumber = result.getInt("numberflight");
					Date departure_date = result.getDate("departure_date");
					Date arrivalDate = result.getDate("arrival_date");
					String departure_time = result.getString("departure_time");
					String arrival_time = result.getString("arrival_time");
					int isFilled = result.getInt("isfull");
					
					boolean isFull;
				
					if (isFilled > 0) {
						isFull = true;
					}
					else {
						isFull = false;
					}
					//make a flight instance with the information
					Flights f1 = new Flights();
					
					// add the new flight to the flight ArrayList
					flights.add(f1);
					}
					//return the ArrayList full of flights
					return flights;
					
				}//a broad catch if anything else goes wrong
				catch (Exception e) {
					System.out.println(e);
					e.printStackTrace();
				}
				return null;
			}

		// used to make sure the flight is not already booked by the user
		public static boolean isBooked(User u1, Flights f1) {
				
				
			int numberflight = f1.getFlightNumber();
			
			String user = u1.getEmail();
				
			try {
					
				Connection conn = getConnection();
			
				String searchStr = "SELECT user_email FROM ticket WHERE user_email = ? AND numberflight = ?";
			
				PreparedStatement preparedSearch = conn.prepareStatement(searchStr);
				
				preparedSearch.setString(1, user);
				preparedSearch.setInt(2, numberflight);
				
				ResultSet result = preparedSearch.executeQuery();
				
				while(result.isBeforeFirst()) {
						
					AlertBox.display("Double Minded Person", "You Are Already Booked in this Flight");
					return true;
				}
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return false;
		}
			
		// used to make sure the email is unique in the database
		 public static boolean emailExists(String email) {
				
			try {
				Connection conn = getConnection();
					
				String searchStr = "SELECT user_email FROM user WHERE user_email = ?";
				
				PreparedStatement preparedSearch = conn.prepareStatement(searchStr);
				
				preparedSearch.setString(1, email);
					
				ResultSet result = preparedSearch.executeQuery();
					
			//	String exists = null;
				while(result.next()) {
						
					//returns true if the email is already in the database	
					return true;
				}
					
			//	if (exists != null) {
			//		return true;
			//	}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
				
			return false;
		}
		
		 //used to make sure the user name is unique in the database
		public static boolean userNameExists(String userName) {
				
			try {
				Connection conn = getConnection();
					
				String searchStr = "SELECT username FROM user WHERE username = ?";
					
				PreparedStatement preparedSearch = conn.prepareStatement(searchStr);
					
				preparedSearch.setString(1, userName);
					
				ResultSet result = preparedSearch.executeQuery();
					
				while(result.next()) {
						
					return true;				
				}
					
			}
			catch(Exception e) {
				e.printStackTrace();
			}
				
			return false;
		}

		public static boolean book(User u1, Flights f1, int seats) {

			Connection conn = getConnection();
			
			String bookStr = "INSERT INTO ticket(User_email, numberflight) VALUES (?, ?)";
			
			String markFlightsStr = "UPDATE flights SET seats_available = ? WHERE numberflight = ?";
			
		
			
			try {
				
				PreparedStatement preBook = conn.prepareStatement(bookStr);
				PreparedStatement preMarkFlights = conn.prepareStatement(markFlightsStr);
				
				preBook.setString(1, u1.getEmail());
				preBook.setInt(2, f1.getFlightNumber());
				
				preMarkFlights.setInt(1, seats);
				preMarkFlights.setInt(2, f1.getFlightNumber());
				
			//	System.out.println(f1.getFlightNumber);
				
				preBook.executeUpdate();
				preMarkFlights.executeUpdate();
				
				conn.close();
				
				return true;
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return false;
		}

		public static int checkSeats(Flights f1) {

			Connection conn = getConnection();
			
			String seatsStr = "SELECT seats_available FROM flights WHERE numberflight = ?";
			
			try {
				PreparedStatement preSeats = conn.prepareStatement(seatsStr);
			
				preSeats.setInt(1, f1.getFlightNumber());
				
				ResultSet set = preSeats.executeQuery();
				
				while(set.next()) {
					
					int seats_available = Integer.parseInt(set.getString("seats_available"));
					
					return seats_available;
				}
				
			}
			catch(NullPointerException npe) {
				AlertBox.display("Problem", "The Flight You Are Trying To Book Does Not Seem To Exist");
				npe.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return 0;
		}

		public static boolean addFlight(Flights f1) {
			
			Connection conn = getConnection();
			
			String addFlightStr = "INSERT INTO flights(numberflight, airline, origin_city, destination_city, departure_time,"
					+ " arrival_time, departure_date, arrival_date, capactiy, seats_available, seats_occupied, isfull) VALUES"
					+ " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			try {
				PreparedStatement preAddFlight = conn.prepareStatement(addFlightStr);
				
				preAddFlight.setInt(1, f1.getFlightNumber());
				preAddFlight.setString(2, f1.getAirline());
				preAddFlight.setString(3, f1.getOriginCity());
				preAddFlight.setString(4, f1.getDestinationCity());
				preAddFlight.setString(5, f1.getDepartureTime());
				preAddFlight.setString(6, f1.getArrivalTime());
				preAddFlight.setDate(7, (Date) f1.getDepartureDate());
				preAddFlight.setDate(8, (Date) f1.getArrivalDate());
				preAddFlight.setInt(9, f1.getFlightCapacity());
				preAddFlight.setInt(10, f1.getSeatsAvailable());
				preAddFlight.setInt(11,f1.getFlightCapacity() - f1.getSeatsAvailable());
				preAddFlight.setBoolean(12, f1.getIsFilled());
				
				preAddFlight.executeUpdate();
				
				conn.close();
				
				return true;
				
			}
			catch (Exception e) {
				e.printStackTrace();
				AlertBox.display("Problem", "There was a problem putting the new flight into the database");
			}
			return false;
		}

		public static boolean removeFlightTickes(Flights f1) {
			
			Connection conn = getConnection();
			
			String removeFlightStr = "DELETE FROM ticket WHERE numberflight = ?";
			
			try {
				PreparedStatement removeFlight = conn.prepareStatement(removeFlightStr);
				
				removeFlight.setInt(1, f1.getFlightNumber());
				
				removeFlight.executeUpdate();
				
				conn.close();
				
				return true;
			}
			catch (Exception e) {
				AlertBox.display("Problem", "There was a problem removing Your flight from the database");
				e.printStackTrace();
			}
			return false;
		}

		public static ObservableList<Flights> searchUserFlights(User u1) {
			
			ObservableList<Flights> obsFlights = FXCollections.observableArrayList();
			
			Connection conn = getConnection();
			
			String userTicketStr = "SELECT * FROM ticket WHERE user_email = ?";
			
			try {
				
				PreparedStatement preUserTicket = conn.prepareStatement(userTicketStr);
				
				preUserTicket.setString(1, u1.getEmail());
				
				ResultSet set = preUserTicket.executeQuery();
				
				while(set.next()) {
					
					int numberflight = set.getInt("numberflight");
					
					String pullFlight = "SELECT * FROM flights WHERE numberflight = ?";
							
					PreparedStatement prePullFlight = conn.prepareStatement(pullFlight);
					
					prePullFlight.setInt(1, numberflight);
					
					ResultSet result = prePullFlight.executeQuery();
					
					while(result.next()) {
						
						//get the information on a single flight
						String airline = result.getString("airline");
						String origin_city = result.getString("origin_city");
						String destination_city = result.getString("destination_city");
						int flightCapacity = result.getInt("capactiy");
						int seats_available = result.getInt("seats_available");
						int flightNumber = result.getInt("numberflight");
						Date departure_date = result.getDate("departure_date");
						Date arrivalDate = result.getDate("arrival_date");
						String departure_time = result.getString("departure_time");
						String arrival_time = result.getString("arrival_time");
						int isFilled = result.getInt("isfull");
						
						boolean isFull;
					
						if (isFilled > 0) {
							isFull = true;
						}
						else {
							isFull = false;
						}
						//make a flight instance with the information
						Flights f1 = new Flights();
						
						obsFlights.add(f1);
					}
				}
			}
			catch (Exception e) {
				PUCBox.display();
				e.printStackTrace();			
			}
			
			return obsFlights;
		}

		public static String getPassword(String P1) {

	        Connection conn = getConnection();
	      
	        String PassStr = "SELECT Password FROM Username WHERE Username = ?";

	        try {

	        	PreparedStatement prepassword = conn.prepareStatement(PassStr);

	        	prepassword.setString(1, P1);

	        	ResultSet set = prepassword.executeQuery();

	            while(set.next()) {

	            	String Password = set.getString("password");
	            	
	            	return Password;

	            }         

	        }
	        catch(NullPointerException npe) {

	        	AlertBox.display("Problem", "The Username You Are Trying To fined Does Not Seem To Exist");

	            npe.printStackTrace();

	        }

	        catch (Exception e) {

	            e.printStackTrace();

	        }

	        return null;

	}

		public static boolean removeFlight(Flights flight) {
	Connection conn = getConnection();
			
			String removeFlightStr = "DELETE FROM flights WHERE numberflight = ?";
			
			try {
				PreparedStatement removeFlight = conn.prepareStatement(removeFlightStr);
				
				removeFlight.setInt(1, flight.getFlightNumber());
				
				removeFlight.executeUpdate();
				
				conn.close();
				
				return true;
			}
			catch (Exception e) {
				AlertBox.display("Problem", "There was a problem removing the flight from the database");
				e.printStackTrace();
			}
			return false;
		}

		public static String getSecurityQuestion(String S) {

			Connection conn = getConnection();

			String PassStr = "SELECT security_question FROM user WHERE Username = ?";

			try {
				PreparedStatement presecurityQuestion = conn.prepareStatement(PassStr);

				presecurityQuestion.setString(1, S);

				ResultSet set = presecurityQuestion.executeQuery();

				while(set.next()) {

					String securityQuestion = set.getString("security_question");
					return securityQuestion;
				}

			}
			catch(NullPointerException npe) {
				AlertBox.display("Problem", "The Security Question You Are Trying To find Does Not Seem To Exist, try again.");
				npe.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
			return null;
		}
		
	public static String useSecurityAnswer(String userName, String answer) {
			
			Connection conn = getConnection();
			
			String PassStr = "SELECT password FROM user WHERE username = ? AND security_answer = ?";
			
			try {
				PreparedStatement presecurityAnswer = conn.prepareStatement(PassStr);
			
				presecurityAnswer.setString(1, userName);
				presecurityAnswer.setString(2, answer);
				
				ResultSet set = presecurityAnswer.executeQuery();
				
				while(set.next()) {
					
					return set.getString("password");
				}
				
			}
			catch(NullPointerException npe) {
				AlertBox.display("Problem", "The Security Answer You Are Trying To find Does Not Seem To Exist, try again.");
				npe.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			AlertBox.display("Invalid", "Ther Answers Did Not Match");
			return null;
		}
	}
