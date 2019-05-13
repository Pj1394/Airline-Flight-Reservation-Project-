package userInterface;

import database.DBMethod;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import projectBackbone.Flights;
import projectBackbone.Method;
import projectBackbone.User;


public class SearchReturnFlights extends MainMenu {


	Stage window;
	
	Scene scene5;
	
	//creation a table for returning flgihts 
	TableView<Flights> returnFlights;
	
	VBox vBox;
	
	HBox bottom;
	
	Button backBT, bookFlightBT;
	
	
	public void start(Stage primaryStage, User u1) {
		
		window = primaryStage;
		
		//set the title to the new screen 
		window.setTitle("Search Return Flights");
		
		//creating the table with all the columns and its column name 
		TableColumn<Flights, String> airline = new TableColumn<>("Airline");		
		airline.setMinWidth(75);
		airline.setCellValueFactory(new PropertyValueFactory<>("airline"));
		
		//creation of the origin city column and its minimum width
		TableColumn<Flights, String> origin = new TableColumn<>("Origin City");		
		origin.setMinWidth(150);
		origin.setCellValueFactory(new PropertyValueFactory<>("originCity"));
		
		//creation of the destination city column and its minimum width
		TableColumn<Flights, String> destination = new TableColumn<>("Destination City");		
		destination.setMinWidth(150);
		destination.setCellValueFactory(new PropertyValueFactory<>("destinationCity"));
		
		//creation of the departure time column and its minimum width of 75
		TableColumn<Flights, String> departureTime = new TableColumn<>("Departure Time");		
		departureTime.setMinWidth(75);
		departureTime.setCellValueFactory(new PropertyValueFactory<>("departureTime"));
	
		//creation of the arrival time column and its minimum width of 75
		TableColumn<Flights, String> arrivalTime = new TableColumn<>("Arrival Time");		
		arrivalTime.setMinWidth(75);
		arrivalTime.setCellValueFactory(new PropertyValueFactory<>("arrivalTime"));
		
		//creation of the date column
		TableColumn<Flights, java.util.Date> date = new TableColumn<>("Date");		
		date.setMinWidth(75);
		date.setCellValueFactory(new PropertyValueFactory<>("departureDate"));
		
		//creation of the seats column and its minimum width
		TableColumn<Flights, Integer> seats = new TableColumn<>("Seats Available");		
		seats.setMinWidth(30);
		seats.setCellValueFactory(new PropertyValueFactory<>("seatsAvailable"));
	
		//creating me table
		returnFlights = new TableView<>();
		
		//calling DBMethod to search a flight 
		ObservableList<Flights> flights = DBMethod.searchFlights();
		
		returnFlights.setItems(flights);
		
		//call columns when return flight
		returnFlights.getColumns().addAll(airline, origin, destination, departureTime, arrivalTime, date, seats);
		
		backBT = new Button("back");
		
		backBT.setOnAction(e -> Method.searchFlights(window, u1));
		
		bookFlightBT = new Button("Book Flight");

		//set action to the new button bookFloghtBT to the method book flight 
		bookFlightBT.setOnAction(e -> {
			Method.bookFlight(u1, returnFlights.getSelectionModel().getSelectedItems());
			
		});
		
		//dimension and organization of the items in the screen 
		bottom = new HBox();
		bottom.getChildren().addAll(backBT, bookFlightBT);
		bottom.setPadding(new Insets(10, 10, 10, 10));
		bottom.setSpacing(10);
		
		vBox = new VBox();
		
		vBox.getChildren().addAll(returnFlights, bottom);
		vBox.setPadding(new Insets(20.0, 20.0, 20.0, 20.0));
		
		//show screen on GUI
		scene5 = new Scene(vBox);
		window.setScene(scene5);
		window.show();
	}
}
