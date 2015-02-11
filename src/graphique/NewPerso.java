package graphique;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class NewPerso extends GridPane {

	public NewPerso(final Stage primaryStage) {
		this.setAlignment(Pos.CENTER);
		this.setPadding(new Insets(10, 10, 10, 10));
		this.setVgap(15);
		this.setHgap(10);
	}
}
