package userInterface;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import projectBackbone.Method;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;


public class Welcome extends Application  implements EventHandler<ActionEvent> {

	Button button;
	
	
	public static void main(String[] args) {
		launch(args);
	}
		@Override
		public void start(Stage primaryStage) throws Exception {
			
		
			
			primaryStage.setTitle("Welcome To BMP Travel");
			button = new Button();
			button.setText("Enter Site");
			button.setOnAction(e-> Method.mainMenu(primaryStage));
			
			
			
			
			
			StackPane layout = new StackPane();
			layout.getChildren().add(button);
			
			Scene scene = new Scene(layout, 300,250,Color.BLUE);
			primaryStage.setScene(scene);
			primaryStage.show();
			
	
		
	
}
		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
			
		}

			
			
			
		
}