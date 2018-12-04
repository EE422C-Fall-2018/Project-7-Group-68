package assignment7;



import java.io.File;
import java.util.HashMap;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Login extends Application {
	public static String user = "no username";
	public static int serverport = 0;
	public static String ipaddress = " ";

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Welcome to ChatRoom");


		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Label userName = new Label("User Name:");
		grid.add(userName, 0, 1);

		TextField userTextField = new TextField();
		grid.add(userTextField, 1, 1);
		
		Label ser = new Label("Server Port:");
		grid.add(ser, 0, 2);
		
		TextField serverTextField = new TextField();
		grid.add(serverTextField, 1, 2);

		Label ip = new Label("IP Address:");
		grid.add(ip, 0, 3);

		TextField ipTextField = new TextField();
		grid.add(ipTextField, 1, 3);

		Button signIn = new Button("Sign in");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(signIn);
		grid.add(hbBtn, 1, 4);
		

		

		try {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/assignment7/Computer_Magic-Microsift-1901299923.wav").getAbsoluteFile());
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	    } catch(Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }
		signIn.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
			 
		    @Override
		     public void handle(ActionEvent e) {
		        user = userTextField.getText();
		        serverport = Integer.parseInt(serverTextField.getText());
		        ipaddress = ipTextField.getText();
		        primaryStage.hide();
		        ChatServer.main(null);


		    }
		});
        
		Scene scene = new Scene(grid, 300, 275);
		primaryStage.setScene(scene);
        primaryStage.show();
		
	}

	public static void main(String[] args) {
		Application.launch(Login.class);
		
	}
}