/*
 * Chad Hirsch
 * CS4430
 * DUE: 11/12/2019
 */

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class RootController implements Initializable{

	@FXML
	private MenuBar menuBar;
	@FXML
	private Menu File;
	@FXML
	private Menu Manage;
	@FXML
	private MenuItem Exit;
	@FXML
	private MenuItem AddCustomer;
	@FXML
	private MenuItem AddOrder;
	@FXML
	private MenuItem RemoveOrder;
	@FXML
	private MenuItem ShipOrder;
	@FXML
	private MenuItem PrintPending;
	@FXML
	private MenuItem Restock;
	@FXML
	private Label welcome;
	@FXML
	private BorderPane Border;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		AddCustomer.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				try {
					FXMLLoader loader = new FXMLLoader();
					loader.setLocation(getClass().getResource("AddCustomer.fxml"));
					AnchorPane pane = loader.load();
					Border.setCenter(pane);
					welcome.setText("Add Customer");
					Border.setTop(welcome);
					Scene scene = new Scene(pane);
					Stage stage = new Stage();
					stage.setTitle("Add Customer");
					stage.setScene(scene);
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
		});
		ShipOrder.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				try {
					FXMLLoader loader = new FXMLLoader();
					loader.setLocation(getClass().getResource("Orders.fxml"));
					AnchorPane pane = loader.load();
					Border.setCenter(pane);
					welcome.setText("Add Order");
					Border.setTop(welcome);
					Scene scene = new Scene(pane);
					Stage stage = new Stage();
					stage.setTitle("Add Order");
					stage.setScene(scene);
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
		});
		AddOrder.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				try {
					FXMLLoader loader = new FXMLLoader();
					loader.setLocation(getClass().getResource("Orders.fxml"));
					AnchorPane pane = loader.load();
					Border.setCenter(pane);
					welcome.setText("Add Order");
					Border.setTop(welcome);
					Scene scene = new Scene(pane);
					Stage stage = new Stage();
					stage.setTitle("Orders");
					stage.setScene(scene);
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
		});
		RemoveOrder.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				try {
					FXMLLoader loader = new FXMLLoader();
					loader.setLocation(getClass().getResource("DeleteOrder.fxml"));
					AnchorPane pane = loader.load();
					Border.setCenter(pane);
					welcome.setText("Delete order");
					Border.setTop(welcome);
					Scene scene = new Scene(pane);
					Stage stage = new Stage();
					stage.setTitle("Delete Order");
					stage.setScene(scene);
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
		});
		PrintPending.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				try {
					FXMLLoader loader = new FXMLLoader();
					loader.setLocation(getClass().getResource("PendingOrder.fxml"));
					AnchorPane pane = loader.load();
					Border.setCenter(pane);
					welcome.setText("Pending Order");
					Border.setTop(welcome);
					Scene scene = new Scene(pane);
					Stage stage = new Stage();
					stage.setTitle("Pending Order");
					stage.setScene(scene);
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
		});
		Restock.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				try {
					FXMLLoader loader = new FXMLLoader();
					loader.setLocation(getClass().getResource("Restock.fxml"));
					AnchorPane pane = loader.load();
					Border.setCenter(pane);
					welcome.setText("Restock");
					Border.setTop(welcome);
					Scene scene = new Scene(pane);
					Stage stage = new Stage();
					stage.setTitle("Restock");
					stage.setScene(scene);
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
		});
		Exit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.exit(0);
				
			}
		});
	}

}
