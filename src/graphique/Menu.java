package graphique;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import objets.Player;

public class Menu extends GridPane {

	public Menu(final Stage primaryStage, Player p) {
		this.setAlignment(Pos.CENTER);
		this.setPadding(new Insets(10, 10, 10, 10));
		this.setVgap(15);
        this.setHgap(0);
        final Label j1 = new Label("Kill Th");
        j1.setFont(Font.font("Impact", FontWeight.EXTRA_BOLD, 48));
        final Label j2 = new Label("e Mad ");
        j2.setFont(Font.font("Impact", FontWeight.EXTRA_BOLD, 48));
        final Label j3 = new Label("Mob");
        j3.setFont(Font.font("Impact", FontWeight.EXTRA_BOLD, 48));
        this.add(j1, 0, 0);
        this.add(j2, 1, 0);
        this.add(j3, 2, 0);
        final Button newPerso = new Button("Nouveau ");
        this.add(newPerso, 1, 1);
        final Button continuer = new Button("Continuer");
        this.add(continuer, 1, 2);
        final Button options = new Button("  Options ");
        this.add(options, 1, 3);
        final Button quit = new Button("  Quitter  ");
        this.add(quit, 1, 4);
        newPerso.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
			}
        });
        continuer.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
			}
        });
        options.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
			}
        });
        quit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				System.exit(0);
			}
        });
	}
}
