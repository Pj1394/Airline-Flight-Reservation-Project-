package userInterface;
import java.awt.Window;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ForgotPasswordFinal extends Application {

	Label UserNameLB, PasswordLB;
	
	Button mainMenuBT; 
	
	Stage window; 
	
	Scene scene; 
	
	VBox vBox; 
	
	BorderPane pane; 
	
	public static void main(String[] args) {
		launch(args);

	}
	@Override
	public void start(Stage primaryStage) throws Exception {
	
	//creation a new screen continuing the forget password sequence 
	//title of new screen Credentials 
	window = primaryStage; 
	window.setTitle("Credentials");
	//label on the screen
	UserNameLB = new Label("get username"); 
	PasswordLB = new Label("get password"); 
	
	mainMenuBT = new Button("Main Menu"); 
	//dimensions of the grid
	GridPane grid = new GridPane();
	grid.setPadding(new Insets(10, 10, 10, 10));
	grid.setVgap(8); 
	grid.setHgap(10);
	//the items and the location of them in the screen 
	GridPane.setConstraints(UserNameLB, 5, 3);
	GridPane.setConstraints(PasswordLB, 5, 4);
	GridPane.setConstraints(mainMenuBT, 5, 6);
	//adding the items in the screen-grid
	grid.getChildren().addAll(UserNameLB, PasswordLB, mainMenuBT); 
	
	//setting action to the Main menu button so that when the user getd the credentials can go back to 
	//main menu and login
	mainMenuBT.setOnAction(event -> {
		MainMenu menu = new MainMenu(); 
		try {
			menu.start(primaryStage); 
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	});
	//dimensions of the window
	scene = new Scene(grid, 200, 200);
	window.setScene(scene);
	
	window.show(); 
	
	}

}
