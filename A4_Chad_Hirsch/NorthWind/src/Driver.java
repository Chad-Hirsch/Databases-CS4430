/*
 * Chad Hirsch
 * CS4430
 * DUE: 11/12/2019
 */

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Driver extends Application{

	private Stage primaryStage;
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		Root();
	}
	private void Root() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("root.fxml"));
		AnchorPane pane = loader.load();
		Scene scene = new Scene(pane);
		this.primaryStage.setScene(scene);
		this.primaryStage.setResizable(false);
		this.primaryStage.setTitle("Welcome");
		this.primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
