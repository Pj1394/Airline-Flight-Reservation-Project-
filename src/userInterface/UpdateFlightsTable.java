package userInterface;

import java.lang.reflect.Method;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import projectBackbone.Flights;


public class UpdateFlightsTable extends Application {

	Stage window; 
	
	Button AddBT, DeleteBT, UpdateBT; 
	
	TextField airlineTF, originCityTF, destinationCityTF, flightCapacityTF,
	flightNumberTF, departureDateTF, arrivalDateTF, departureTimeTF, 
	arrivalTimeTF, seatsAvailableTF, isFilledTF;
	
	TableView<Flights> table; 
	
	VBox vBox; 
	
	HBox hBox; 
	
	Scene scene; 
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage; 
		
		//set title for the new screen
		window.setTitle("UpdateFlightsTable");
		
		//buttons on the new screen
		AddBT = new Button("Add Flight"); 
		DeleteBT = new Button("Delete Flight"); 
		UpdateBT = new Button("Update Flight"); 
		
		//text field so that when the user can type the each field in the respective column
		airlineTF = new TextField(); 
		airlineTF.setPromptText("airline");
		
		//creation of the origin city text field - setting prompt text so the admin knows what to write in the box
		originCityTF = new TextField();
		originCityTF.setPromptText("originCity");
		
		//creation of the destination city text field - setting prompt text so the admin knows what to write in the box
		destinationCityTF = new TextField();
		destinationCityTF.setPromptText("destinationCity");
		
		//creation of the flight capacity text field - setting prompt text so the admin knows what to write in the box
		flightCapacityTF = new TextField();
		flightCapacityTF.setPromptText("flightCapacity");
		
		//creation of the flight number(Primary key) text field - setting prompt text so the admin knows what to write in the box
		flightNumberTF = new TextField();
		flightNumberTF.setPromptText("flightNumber");
		
		//creation of the departure date text field - setting prompt text so the admin knows what to write in the box
		departureDateTF = new TextField();
		departureDateTF.setPromptText("departureDate");
		
		//creation of the arrival date text field - setting prompt text so the admin knows what to write in the box
		arrivalDateTF = new TextField();
		arrivalDateTF.setPromptText("arrivalDate");
		
		//creation of the departure time text field - setting prompt text so the admin knows what to write in the box
		departureTimeTF = new TextField();
		departureTimeTF.setPromptText("departureTime");
		
		//creation of the arrival time text field - setting prompt text so the admin knows what to write in the box
		arrivalTimeTF = new TextField();
		arrivalTimeTF.setPromptText("arrivalTime");
		
		//creation of the seats available text field - setting prompt text so the admin knows what to write in the box
		seatsAvailableTF = new TextField();
		seatsAvailableTF.setPromptText("seatsAvailable");
		
		//creation of the isFilled text field - setting prompt text so the admin knows what to write in the box
		isFilledTF = new TextField();
		isFilledTF.setPromptText("isFilled");
		
		//airline column
		TableColumn<Flights, String> airlineColumn = new TableColumn("Airline"); 
		airlineColumn.setMinWidth(200); 
		airlineColumn.setCellValueFactory(new PropertyValueFactory<>("airline"));
		
		//origin city column
		TableColumn<Flights, String> originCityColumn = new TableColumn("Origin City"); 
		airlineColumn.setMinWidth(200); 
		airlineColumn.setCellValueFactory(new PropertyValueFactory<>("originCity"));
		
		//destination city column
		TableColumn<Flights, String> destinationCityColumn = new TableColumn("Destination City"); 
		airlineColumn.setMinWidth(200); 
		airlineColumn.setCellValueFactory(new PropertyValueFactory<>("destinationCity"));
		
		//flight capacity column
		TableColumn<Flights, String> flightCapacityColumn = new TableColumn("Flight Capacity"); 
		airlineColumn.setMinWidth(200); 
		airlineColumn.setCellValueFactory(new PropertyValueFactory<>("flightCapacity"));
		
		//flight number column - primary key 
		TableColumn<Flights, String> flightNumberColumn = new TableColumn("Flight Number"); 
		airlineColumn.setMinWidth(200); 
		airlineColumn.setCellValueFactory(new PropertyValueFactory<>("flightNumber"));
		
		//departure date column
		TableColumn<Flights, String> departureDateColumn = new TableColumn("Departure Date"); 
		airlineColumn.setMinWidth(200); 
		airlineColumn.setCellValueFactory(new PropertyValueFactory<>("departureDate"));
		
		//arrival date column 
		TableColumn<Flights, String> arrivalDateColumn = new TableColumn("Arrival Date"); 
		airlineColumn.setMinWidth(200); 
		airlineColumn.setCellValueFactory(new PropertyValueFactory<>("arrivalDate"));
		
		//create the departure time column 
		TableColumn<Flights, String> departureTimeColumn = new TableColumn("Departure Time"); 
		airlineColumn.setMinWidth(200); 
		airlineColumn.setCellValueFactory(new PropertyValueFactory<>("departureTime"));
		
		//create the arrival time column
		TableColumn<Flights, String> arrivalTimeColumn = new TableColumn("Arrival Time"); 
		airlineColumn.setMinWidth(200); 
		airlineColumn.setCellValueFactory(new PropertyValueFactory<>("arrivalTime"));
		
		//create the seats available column
		TableColumn<Flights, String> seatsAvailableColumn = new TableColumn("Seats Available"); 
		airlineColumn.setMinWidth(200); 
		airlineColumn.setCellValueFactory(new PropertyValueFactory<>("seatsAvailable"));
		
		//create isFilled column
		TableColumn<Flights, String> isFilledColumn = new TableColumn("is Filled"); 
		airlineColumn.setMinWidth(200); 
		airlineColumn.setCellValueFactory(new PropertyValueFactory<>("isFilled"));
		
		//new table view to see all the flights 
		table = new TableView<>(); 
		table.setItems(Method.getFlights()); 
		
		//adding all the columns created in the table
		table.getColumns().addAll(airlineColumn,originCityColumn, destinationCityColumn, 
				flightCapacityColumn, flightNumberColumn, departureDateColumn, arrivalDateColumn, 
				departureTimeColumn, arrivalTimeColumn, seatsAvailableColumn, isFilledColumn); 
		
		HBox hBox2 = new HBox(); 
		hBox.getChildren().addAll(airlineTF, originCityTF, destinationCityTF, flightCapacityTF, flightNumberTF, 
				departureDateTF, arrivalDateTF, departureTimeTF, arrivalTimeTF, seatsAvailableTF, isFilledTF); 
		
		HBox hBox = new HBox(); 
		hBox.getChildren().addAll(AddBT, DeleteBT, UpdateBT);
		
		//organize the screen by putting first the table, the hBox2, and last the hBox
		VBox vBow = new VBox();
		vBox.getChildren().addAll(table,hBox2, hBox); 
		
		//call scene to show in GUI
		Scene scene = new Scene(vBox); 
		window.setScene(scene); 
		
		window.show(); 
		
		
	}

}
