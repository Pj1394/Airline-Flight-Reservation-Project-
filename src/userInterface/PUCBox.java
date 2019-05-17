package userInterface;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PUCBox {

	public static void display() {
		
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		
		window.setTitle("Program Under Construction");
		
		window.setMinWidth(350);
		
		Label l = new Label("This part of BMP Travel is still under construction\n\tWe appreciate your understanding");
		
		Button b = new Button("Understood");
		b.setOnAction(e -> window.close());
		
		VBox v = new VBox(10);
		v.getChildren().addAll(l, b);
		
		v.setAlignment(Pos.CENTER);
		
		Scene s = new Scene(v);
		
		window.setScene(s);
		
		window.showAndWait();
	}
}