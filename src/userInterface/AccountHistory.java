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
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import projectBackbone.Admin;
import projectBackbone.Customer;
import projectBackbone.Flights;
import projectBackbone.Method;
import projectBackbone.User;




public class AccountHistory extends MainMenu {
	
	Button deleteBT, backBT, logOutBT;
	
	TableView<Flights> flightTable;
	
	VBox vBox;
	
	HBox hBox;
	
	Region emptySpace = new Region();
	
	Scene scene;
	
	
	public void start(Stage window, User u1) {
		
		window.setTitle("Account History");
		
		TableColumn<Flights, String> airline = new TableColumn<>("Airline");		
		airline.setMinWidth(75);
		airline.setCellValueFactory(new PropertyValueFactory<>("airline"));
		
		TableColumn<Flights, String> origin = new TableColumn<>("Origin City");		
		origin.setMinWidth(150);
		origin.setCellValueFactory(new PropertyValueFactory<>("originCity"));
		
		TableColumn<Flights, String> destination = new TableColumn<>("Destination City");		
		destination.setMinWidth(150);
		destination.setCellValueFactory(new PropertyValueFactory<>("destinationCity"));
		
		TableColumn<Flights, String> departureTime = new TableColumn<>("Departure Time");		
		departureTime.setMinWidth(75);
		departureTime.setCellValueFactory(new PropertyValueFactory<>("departureTime"));
		
		TableColumn<Flights, String> arrivalTime = new TableColumn<>("Arrival Time");		
		arrivalTime.setMinWidth(75);
		arrivalTime.setCellValueFactory(new PropertyValueFactory<>("arrivalTime"));

		TableColumn<Flights, java.util.Date> date = new TableColumn<>("Date");		
		date.setMinWidth(75);
		date.setCellValueFactory(new PropertyValueFactory<>("departureDate"));
		
		TableColumn<Flights, Integer> seats = new TableColumn<>("Seats Abailable");		
		seats.setMinWidth(30);
		seats.setCellValueFactory(new PropertyValueFactory<>("seatsAvailable"));
		
		flightTable = new TableView<>();
		
		ObservableList<Flights> flights = (DBMethod.searchUserFlights(u1));
		
		flightTable.setItems(flights);
		
		flightTable.getColumns().addAll(airline, origin, destination, departureTime, arrivalTime, date, seats);
		
		backBT = new Button("back");
		
		backBT.setOnAction(e -> {
			if (u1 instanceof Admin) {
				
				Admin a1 = (Admin) u1;
			
				Method.homepageAdmin(window, a1);
			}
			else {
				Customer c1 = (Customer) u1;
				
				Method.homepage(window, c1);
				
			}
		});
		
		logOutBT = new Button("Logout");
		
		logOutBT.setOnAction(e -> Method.mainMenu(window));
		
		deleteBT = new Button("Remove Flight");
		
		deleteBT.setOnAction(e -> {
			
			ObservableList<Flights> obsFlight, allFlights;
			
			Flights flight;
			
			allFlights = flightTable.getItems();
			
			obsFlight = flightTable.getSelectionModel().getSelectedItems();
			
			flight = flightTable.getSelectionModel().getSelectedItem();
			
			if (DBMethod.removeFlightTickes(flight)) {
				obsFlight.forEach(allFlights::remove);
			}
			
		});		
		
		hBox = new HBox();
		hBox.setHgrow(emptySpace, Priority.ALWAYS);
		hBox.getChildren().addAll(deleteBT, emptySpace, backBT, logOutBT);
		hBox.setPadding(new Insets(8, 8, 8, 8));
		hBox.setSpacing(8);
		
		vBox = new VBox();
		vBox.getChildren().addAll(flightTable, hBox);
		vBox.setPadding(new Insets(8, 8, 8, 8));
		vBox.setSpacing(8);
		
		scene = new Scene(vBox);
		window.setScene(scene);
		window.show();
	}
	
}