package userInterface;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class MainMenu extends Application{
	private static final int CENTER = 0;

	// creating the labels 
	Label UserNameLB, PasswordLB;  
	
	TextField UserNameTF; 
	
	//password field so it does show when writing it in the GUI
	PasswordField password; 
	
	Button loginBT, registerBT, exitBT, forgotPassBT;
	
	Stage window;
	
	Scene scene;
	
	VBox vBox;
	
	BorderPane pane;
	
	
	public static void main(String[] args) {
		launch(args);

	}
	@Override
	public  void start(Stage primaryStage) throws Exception{
		
		//creating the new screen 
		window = primaryStage;
		window.setTitle("Main Menu");
		
		//items to show in the screen
		loginBT = new Button("Log in");
		registerBT = new Button("Register");
		forgotPassBT = new Button("Forgot Password");
	//	registerBT.setOnAction(e -> RegisetWindow.d);
		exitBT = new Button("Exit");
		exitBT.setOnAction(event -> closeProgram()); 
		//labels 
		UserNameLB = new Label("Username:");
		PasswordLB = new Label("Password:");
		//text field with prompt text 
		UserNameTF = new TextField();
		UserNameTF.setPromptText("User Name");
		
		//password as passwordField so when writing it, it is hidden 
		PasswordField password = new PasswordField();
		password.setPromptText("Password");
		
		// dimensions of the gridPane 
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8); 
		grid.setHgap(10);
		
		//location of all the items in the main menu screen and addition them to the grid
		GridPane.setConstraints(UserNameLB, 0, 0); 
		GridPane.setConstraints(UserNameTF, 0, 1);
		GridPane.setConstraints(PasswordLB, 0, 2);
		GridPane.setConstraints(password, 0, 3);
		GridPane.setConstraints(loginBT, 0, 4);
		GridPane.setConstraints(registerBT, 0, 5);
		GridPane.setConstraints(exitBT, 42, 0);
		GridPane.setConstraints(forgotPassBT, 0, 7);
		
		grid.getChildren().addAll(UserNameLB, UserNameTF, PasswordLB, password, loginBT, registerBT, exitBT, forgotPassBT); 
		
		//dimensions of the grid/screen 
		scene = new Scene(grid, 650, 280);
		window.setScene(scene);
		
		//setting action to the exit button, call the closeProgram method 
		window.setOnCloseRequest(event -> closeProgram()) ;
		
		//set action to the register button so when you click the button it send you the the register screen   
		registerBT.setOnAction(event -> {
		RegisterWindow registerwindow = new RegisterWindow(); 
		try {
			registerwindow.start(primaryStage);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		}); 
		//set action to the login button so when you click it, it send you to the main menu depending if you are an admin or a customer
		loginBT.setOnAction(event1 -> {
			HomePage homepage = new HomePage(); 
			try {
				homepage.start(primaryStage);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		});
		//set action to the forgot password so it send you to the next screen to answer the security question 
		forgotPassBT.setOnAction(event2 -> {
			ForgotPasswordPage forgot = new ForgotPasswordPage(); 
			try {
				forgot.start(primaryStage);
			} 
			catch ( Exception f) {
				f.printStackTrace();
			}
		});
		window.show();
	}
	
	//close program method 
	public void closeProgram() { 	
		System.out.print("Action saved!");
		window.close(); 
		
	}
}