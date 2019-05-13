package userInterface;

import java.io.IOException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import projectBackbone.Admin;
import projectBackbone.Method;
import projectBackbone.User;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class HomepageAdmin extends MainMenu {

	Label helloLB; 

	Button searchFlightBT,  accountHistoryBT, logoutBT, updateFlightsInfoBT; 

	Stage window; 

	Scene scene; 

	VBox vBox; 

	Admin a1;
	
	public void start(Stage primaryStage, Admin a1)  {
		//creation the home page of the admin, with has an extra button "update flights"
		window = primaryStage; 
		window.setTitle("Home Page");
		
		// setting the name of the items on the new screen 
		searchFlightBT = new Button("Search for a Flight"); 
		accountHistoryBT = new Button("Account History List");
		logoutBT = new Button("Logout");
		updateFlightsInfoBT = new Button("Update Flights Info");
		helloLB = new Label ("Hello, and welcome back " + a1.getFirstName() + "!"); 
		
		//grid dimensions 
		GridPane grid = new GridPane(); 
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8); 
		grid.setHgap(10);
		
		//location of the items on the screen, using the grid
		GridPane.setConstraints(helloLB, 20, 5);
		GridPane.setConstraints(searchFlightBT, 20,8); 
		GridPane.setConstraints(updateFlightsInfoBT, 20,10);
		GridPane.setConstraints(accountHistoryBT, 20, 12); 
		GridPane.setConstraints(logoutBT, 20, 14); 
		
		//adding the items to the grid
		grid.getChildren().addAll(searchFlightBT, accountHistoryBT, logoutBT, helloLB, updateFlightsInfoBT);
		
		//set action for the logout button to main menu 
		logoutBT.setOnAction(event -> Method.mainMenu(window));
		
		//set action to the updateFlightsInfo so the admin is able to update flights in the update table
		updateFlightsInfoBT.setOnAction(e -> Method.updateTable(window, a1));
		
		//set action -> search flights 
		searchFlightBT.setOnAction(e -> {
				
			User u1 = a1;
				
			Method.searchFlights(window, u1);
		});		
		
		// dimensions of the screen and the code to show the window
		scene = new Scene(grid, 600, 300);
		window.setScene(scene);
		window.show();

	}

}