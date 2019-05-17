package userInterface;

import java.io.FileNotFoundException;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.Font;



public class BMPSplash extends Application {

	HBox hbox;
	Button letsgo;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	@Override
	public void start(Stage stage) throws FileNotFoundException {
		// this next line will create the image.
		
		  hbox = new HBox();
		  hbox.setPadding(new Insets(5,5,5,5));
		  
		  FadeTransition fadeouttransition = new FadeTransition(Duration.millis(7000), hbox);
		  fadeouttransition.setFromValue(1.0);
		  fadeouttransition.setToValue(0.0);
		  fadeouttransition.setCycleCount(1);
		  
		  fadeouttransition.setOnFinished(e-> {
			  MainMenu login = new MainMenu();
			  try {
				  login.start(stage);
			  }catch(Exception e1) {
				  e1.printStackTrace();
			  }
		  });
		  
		
		
		Image image = new Image("userInterface/BMP TRAVEL.jpg");
		
		// setting image view
		ImageView imageView = new ImageView(image); 
	
		//Setting the postion of the image
		imageView.setX(0);
		imageView.setY(0);
		
		// setting the fit height and width of the image view\
		imageView.setFitHeight(500);
		imageView.setFitWidth(850);
	
		// setting the preserve ratio of the image view
		
		
		  Text text1 = new Text(25, 25 , "Welcome to BMP Travel ");
	        text1.setFill(Color.WHITE);
	        text1.setFont(Font.font(java.awt.Font.SERIF, 29));
	         
	        //root.getChildren().add(text1);
	        
		imageView.setPreserveRatio(true);
		
		hbox.getChildren().addAll(imageView, text1);
		// creating group object 
		
		
		// creating scene object
		
		Scene scene = new Scene(hbox, 600, 600,Color.BLUE);
		
		
		
		// Setting the tittle of the stage
		stage.setTitle("Loading Image.....");
		
	      
		
		//Adding scene to stage
		stage.setScene(scene);
		stage.show();	
		fadeouttransition.play();
	}	

	

}