package userInterface;

import database.DBMethod;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import projectBackbone.Customer;
import projectBackbone.Method;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RegisterWindow extends Application{
	
	//labels if all the text fields
	Label fisstNameLB, lastNameLB, addressLB, zipLB, stateLB, userNameLB, passwordLB, emailLB, ssnLB, secQuestionLB, secAnswerLB;
	
	//text fields have to be input to register
	TextField firstNameTF, lastNameTF, addressTF, zipTF, stateTF, userNameTF, passwordTF, emailTF, ssnTF, secAnswerTF; 
	
	//choice box so the user can choose one question of the four options. when clicking on the forgot password button it has to be answer 
	ChoiceBox<String> secQuestionCB;
	
	Button mainMenuBT, registerBT;

	Stage window;
	
	Scene scene;
	
	BorderPane paneB;
	
	FlowPane paneF;
	
	HBox paneH;
	
	Region emptySpace = new Region();
	
	Customer c1;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Register for an Account");
		
		mainMenuBT = new Button("Main Menu");
		registerBT = new Button("Register");
		
		//the labels 
		fisstNameLB = new Label("First Name:");
		lastNameLB = new Label("Last Name:");
		addressLB = new Label("Address:");
		zipLB = new Label("Zip:");
		stateLB = new Label("State:");
		userNameLB  = new Label("User Name:");
		passwordLB  = new Label("Password:");
		emailLB = new Label("Email:");
		ssnLB = new Label("SSN:");
		secQuestionLB = new Label("Security Question:");
		secAnswerLB = new Label("Security Answer:");
		
		//the text field for the user to input 
		firstNameTF = new TextField();
		lastNameTF = new TextField();
		addressTF = new TextField();
		zipTF = new TextField();
		stateTF = new TextField();
		userNameTF = new TextField();
		passwordTF = new TextField();
		emailTF = new TextField();
		ssnTF = new TextField();
		secAnswerTF = new TextField();
		
		//the four option of security question
		secQuestionCB = new ChoiceBox<>();
		secQuestionCB.getItems().addAll("Select a Question", "What was the name of your first stuffed animal", 
										"In what city or town did your mother and father meet", "Where were you when you had your first kiss",
										"In what city or town was your first job");
		
		secQuestionCB.setValue("Select a Question");
		
		//add all the labels and text fields in the pane
		paneF = new FlowPane(8, 20);
		paneF.getChildren().addAll(fisstNameLB, firstNameTF, lastNameLB, lastNameTF, addressLB,  addressTF, zipLB, zipTF, stateLB, stateTF,
				userNameLB, userNameTF, passwordLB, passwordTF, emailLB, emailTF, ssnLB, ssnTF, secQuestionLB, secQuestionCB, secAnswerLB, 
				secAnswerTF);
		
		paneH = new HBox();
		HBox.setHgrow(emptySpace, Priority.ALWAYS);
		paneH.getChildren().addAll(mainMenuBT, emptySpace, registerBT);
		
		//call method main menu
		mainMenuBT.setOnAction(e -> Method.mainMenu(window));
		
		//call method checkiRegistry to verify inputs and finally creation a new user/customer
		registerBT.setOnAction(e -> {
			
			if (Method.checkRegistry(firstNameTF.getText(), lastNameTF.getText(), userNameTF.getText(), passwordTF.getText(), 
					emailTF.getText(), secQuestionCB.getValue(), secAnswerTF.getText(), addressTF.getText(), stateTF.getText(), 
					zipTF.getText(), ssnTF.getText())) {
				

					c1 = new Customer(firstNameTF.getText(), lastNameTF.getText(), userNameTF.getText(), passwordTF.getText(), 
							emailTF.getText(), secQuestionCB.getValue(), secAnswerTF.getText(), addressTF.getText(), stateTF.getText(), 
							Integer.parseInt(zipTF.getText()), Integer.parseInt(ssnTF.getText()));
					
					DBMethod.registerUser(c1);
			
					Method.homepage(window, c1);
				
				}
				});
		//dimensions of paneB
		paneB = new BorderPane();
		paneB.setCenter(paneF);
		paneB.setBottom(paneH);
		paneB.setMargin(paneF, new Insets(8, 8, 8, 8));
		paneB.setMargin(paneH, new Insets(10, 10, 10, 10));
		
		//dimensions of the screen 
		scene = new Scene(paneB, 875, 300);
		window.setScene(scene);
		
		window.show();
	}
	
}
