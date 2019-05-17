package userInterface;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ForgotPasswordNext extends Application {

	
	Label messageLB, questionLB; 
	
	Button EnterBT, ExitBT; 
	
	TextField answerTF; 
	
	Stage window; 
	
	Scene scene; 
	
	VBox vBox; 
	
	BorderPane pane; 
	
	public static void main(String[] args) {
		launch(args);

	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
	//creation a new screen  
	window = primaryStage; 
	window.setTitle("Security Question"); 
	//the message its going to display when clicking on forgot password
	messageLB = new Label("Please answer the following security question:" ); 
	questionLB = new Label("Question from database"); 
	//the space where the user is going to write the answer of the question 
	answerTF = new TextField(); 
	//the two buttons that will be shown in the screen
	EnterBT = new Button("Enter"); 
	ExitBT = new Button("Exit"); 
	ExitBT.setOnAction(event -> closeProgram());
	
	//dimensions of the screen
	GridPane grid = new GridPane();
	grid.setPadding(new Insets(10, 10, 10, 10));
	grid.setVgap(8); 
	grid.setHgap(10);
	//the 5 items the screen with have and the location of each
	GridPane.setConstraints(messageLB, 14, 5);
	GridPane.setConstraints(questionLB, 14, 6);
	GridPane.setConstraints(answerTF, 14, 7);
	GridPane.setConstraints(EnterBT, 14, 8);
	GridPane.setConstraints(ExitBT, 30,0 );
	
	//adding all the items to the grid	
	grid.getChildren().addAll(messageLB, questionLB, answerTF, ExitBT, EnterBT); 
	
	//set action for the Enter button, so that when the user clicks it it will open the ForgotPasswordFinal screen
	EnterBT.setOnAction(event -> {
		ForgotPasswordFinal forgotpassword = new ForgotPasswordFinal();
		try { 
			forgotpassword.start(primaryStage);
		}
		catch (Exception e) {
			e.printStackTrace(); 
		}
	});
	//dimensions of the screen 
	scene = new Scene(grid, 650, 280);
	window.setScene(scene);
	
	window.show(); 
	}	
	//method to close the window when clicking on Exit button 
	public void closeProgram() { 	
		System.out.print("Action saved!");
		window.close(); 
		
	}		

	}
