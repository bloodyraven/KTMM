package graphique;
import bdd.BDD;
import bdd.Constantes;
import controller.StageController;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TimelineBuilder;
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


public class Inscription extends GridPane {

	public Inscription(final Stage primaryStage) {
		this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(10, 10, 10, 10));
        this.setVgap(15);
        this.setHgap(10);
        Text frmHeading = new Text("Inscription");
        frmHeading.setFont(Font.font("Impact", FontWeight.EXTRA_BOLD, 48));
        this.add(frmHeading, 0, 0, 2, 1);
        Label username = new Label("User Name");
        this.add(username, 0, 2);
        final TextField uname = new TextField();
        this.add(uname, 1, 2);
        Label password = new Label("Password");
        this.add(password, 0, 3);
        final TextField pass = new PasswordField();
        this.add(pass, 1, 3);
        Label passwordverif = new Label("Password Confirm");
        this.add(passwordverif, 0, 4);
        final TextField passverif = new PasswordField();
        this.add(passverif, 1, 4);
        Button inscrip = new Button("Valider");
        this.add(inscrip, 1, 5);
        Button retour = new Button("Retour");
        this.add(retour, 1, 6);
        final Label toast = new Label();
        toast.setTextFill(Color.WHITESMOKE);
        toast.setFont(Font.font("Courier New", FontWeight.EXTRA_BOLD, 12));
        toast.setStyle("-fx-border: 1px solid #666; -fx-background-color: #404040; -fx-padding: 3px 10px 3px 10px;");
        toast.setOpacity(0);
        this.add(toast, 0, 7, 3, 1);
        inscrip.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(javafx.event.ActionEvent arg0) {
	        	String[][] logs = BDD.contient(BDD.getTable("bdd/logs.txt"), uname.getText(), 0);
	        	if(logs==null) { //si la table ne contient pas le login
	        		if(pass.getText().equals(passverif.getText())) {
	        			String tab[] = {uname.getText(), pass.getText()};
	        			if(uname.getText().length()<5 || pass.getText().length()<5) {
	        				toast.setText("Le login et le password doivent contenir\nau minimum 5 caractères");
	        			} else {
	        				BDD.insert("bdd/logs.txt", tab);
	        				toast.setText("Vous êtes désormais inscrit !");
	        			}
	        		} else {
	        			toast.setText("Les passwords sont différents");
	        		}
	        	} else {
	        		toast.setText("Login déjà utilisé !");
	        	}
                Timeline l = TimelineBuilder.create()
                        .keyFrames(new KeyFrame(new Duration(0), new KeyValue(toast.opacityProperty(), 1)), new KeyFrame(new Duration(3000), new KeyValue(toast.opacityProperty(), 0)))
                        .autoReverse(false)
                        .cycleCount(1)
                        .build();
                l.play();
            }
        });
        retour.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				StageController.changeScene(primaryStage, new Scene(Login.initGridPane(primaryStage), Constantes.WINDOWX, Constantes.WINDOWY));
			}
        });
	}
}
