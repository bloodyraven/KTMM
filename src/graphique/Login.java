package graphique;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TimelineBuilder;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import objets.Player;
import bdd.BDD;
import bdd.Constantes;
import controller.StageController;

public class Login extends Application {

	@Override
	public void start(final Stage primaryStage) throws Exception {
        Scene scene = new Scene(initGridPane(primaryStage), Constantes.WINDOWX, Constantes.WINDOWY);
        primaryStage.setTitle("Kill The Mad Mob");
        primaryStage.setScene(scene);
        primaryStage.show();
	}
	
	public static GridPane initGridPane(final Stage primaryStage) {
		GridPane root = new GridPane();
		root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setVgap(15);
        root.setHgap(10);
        Text frmHeading = new Text("Login");
        frmHeading.setFont(Font.font("Impact", FontWeight.EXTRA_BOLD, 48));
        root.add(frmHeading, 0, 0, 2, 1);
        Label username = new Label("User Name");
        root.add(username, 0, 2);
        final TextField uname = new TextField();
        root.add(uname, 1, 2);
        Label password = new Label("Password");
        root.add(password, 0, 3);
        final TextField pass = new PasswordField();
        root.add(pass, 1, 3);
        Button login = new Button("  Login   ");
        root.add(login, 1, 4);
        Button inscrip = new Button("S'inscrire");
        root.add(inscrip, 1, 5);
        final Label toast = new Label();
        toast.setTextFill(Color.WHITESMOKE);
        toast.setFont(Font.font("Courier New", FontWeight.EXTRA_BOLD, 12));
        toast.setStyle("-fx-border: 1px solid #666; -fx-background-color: #404040; -fx-padding: 3px 10px 3px 10px;");
        toast.setOpacity(0);
        root.add(toast, 0, 6, 3, 1);
        login.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(javafx.event.ActionEvent arg0) {
				String[] logs = BDD.contient(BDD.getTable("bdd/logs.txt"), uname.getText(), 0);
				if(logs==null) { //si pas trouvé
					toast.setText(uname.getText()+" n'est pas enregistré.");
				} else { //si trouvé
					if(logs[1].equals(pass.getText())) { // si mdp est bon
						toast.setText("Bienvenue "+uname.getText()+".");
						StageController.changeScene(primaryStage, new Scene(new Menu(primaryStage, createPlayer(logs[0])), Constantes.WINDOWX, Constantes.WINDOWY));
					} else { //s'il est faux
						toast.setText("Mot de passe incorrect.");
					}
				}
                Timeline l = TimelineBuilder.create()
                        .keyFrames(new KeyFrame(new Duration(0), new KeyValue(toast.opacityProperty(), 1)), new KeyFrame(new Duration(3000), new KeyValue(toast.opacityProperty(), 0)))
                        .autoReverse(false)
                        .cycleCount(1)
                        .build();
                l.play();
            }

			private Player createPlayer(String log) {
				
				return null;
			}
        });
        inscrip.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				StageController.changeScene(primaryStage, new Scene(new Inscription(primaryStage), Constantes.WINDOWX, Constantes.WINDOWY));
			}
        });
		return root;
	}
	
	public static void main(String[] args) {
        launch(args);
    }

}
