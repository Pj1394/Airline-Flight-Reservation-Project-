package userInterface;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {

	public static void display(String title, String message) {
		
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		
		window.setTitle(title);
		
		window.setMinWidth(350);
		
		Label l = new Label(message);
		
		Button b = new Button("Try Again");
		b.setOnAction(e -> window.close());
		
		VBox v = new VBox(10);
		v.getChildren().addAll(l, b);
		
		v.setAlignment(Pos.CENTER);
		
		Scene s = new Scene(v);
		
		window.setScene(s);
		
		window.showAndWait();
	}
}
