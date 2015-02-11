package graphique;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SelectPerso extends GridPane {

	public SelectPerso(final Stage primaryStage) {
        ScrollPane sp = new ScrollPane();
        sp.setPrefSize(primaryStage.widthProperty().doubleValue(), primaryStage.heightProperty().doubleValue());
        this.add(sp, 0, 0);
        GridPane gp = new GridPane();
        gp.setAlignment(Pos.CENTER);
        gp.setPadding(new Insets(10, 10, 10, 10));
        gp.setVgap(15);
        gp.setHgap(10);

        sp.setContent(gp);
        
	}
}
