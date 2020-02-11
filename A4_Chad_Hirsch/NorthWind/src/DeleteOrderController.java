/*
 * Chad Hirsch
 * CS4430
 * DUE: 11/12/2019
 */

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class DeleteOrderController implements Initializable{
	@FXML
	private TableView<OrderList> Table;
	@FXML
	private TableColumn<OrderList, Integer> OrderID;
	@FXML
	private TableColumn<OrderList, String> CustomerID;
	@FXML
	private TableColumn<OrderList, String> EmployeeID;
	@FXML
	private TableColumn<OrderList, LocalDate> OrderDate;
	@FXML
	private TableColumn<OrderList, LocalDate> RequiredDate;
	@FXML
	private TableColumn<OrderList, LocalDate> ShippedDate;
	@FXML
	private TableColumn<OrderList, Integer> ShipVia;
	@FXML
	private TableColumn<OrderList, Double> Freight;
	@FXML
	private TableColumn<OrderList, String> ShipName;
	@FXML
	private TableColumn<OrderList, String> ShipAddress;
	@FXML
	private TableColumn<OrderList, String> ShipCity;
	@FXML
	private TableColumn<OrderList, String> ShipRegion;
	@FXML
	private TableColumn<OrderList, String> ShipPostalCode;
	@FXML
	private TableColumn<OrderList, String> ShipCountry;
	@FXML
	private Button Delete;
	private ObservableList<OrderList> Data;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Data = FXCollections.observableArrayList();
		try {
			Database db = new Database();
			db.preStatement = db.connection.prepareStatement("SELECT * FROM orders");
			db.result = db.preStatement.executeQuery();
			while (db.result.next()) {
				OrderList order = new OrderList();
				order.setOrderID(db.result.getInt(1));
				order.setCustomerID(db.result.getString(2));
				order.setEmployeeID(db.result.getInt(3));
				order.setOrderDate(db.result.getDate(4).toString());
				order.setRequiredDate(db.result.getDate(5).toString());
				order.setShippedDate(db.result.getDate(6).toString());
				order.setShipVia(db.result.getInt(7));
				order.setFreight(db.result.getDouble(8));
				order.setShipName(db.result.getString(9));
				order.setShipAddress(db.result.getString(10));
				order.setShipCity(db.result.getString(11));
				order.setShipRegion(db.result.getString(12));
				order.setShipPostalCode(db.result.getString(13));
				order.setShipCountry(db.result.getString(14));
				Data.add(order);			
				}
		} catch (Exception e) {
			
		}
		this.OrderID.setCellValueFactory(new PropertyValueFactory("OrderID"));
		this.CustomerID.setCellValueFactory(new PropertyValueFactory("CustomerID"));
		this.EmployeeID.setCellValueFactory(new PropertyValueFactory("EmployeeID"));
		this.OrderDate.setCellValueFactory(new PropertyValueFactory("OrderDate"));
		this.RequiredDate.setCellValueFactory(new PropertyValueFactory("RequiredDate"));
		this.ShippedDate.setCellValueFactory(new PropertyValueFactory("ShippedDate"));
		this.ShipVia.setCellValueFactory(new PropertyValueFactory("ShipVia"));
		this.Freight.setCellValueFactory(new PropertyValueFactory("Freight"));
		this.ShipName.setCellValueFactory(new PropertyValueFactory("ShipName"));
		this.ShipAddress.setCellValueFactory(new PropertyValueFactory("ShipAddress"));
		this.ShipCity.setCellValueFactory(new PropertyValueFactory("ShipCity"));
		this.ShipRegion.setCellValueFactory(new PropertyValueFactory("ShipRegion"));
		this.ShipPostalCode.setCellValueFactory(new PropertyValueFactory("ShipPostalCode"));
		this.ShipCountry.setCellValueFactory(new PropertyValueFactory("ShipCountry"));
		Table.setItems(Data);
		Delete.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				if(Table.getSelectionModel().getSelectedIndex() >= 0) {
					Alert delAlert = new Alert(AlertType.CONFIRMATION);
					delAlert.setTitle("Deleting Product");
					delAlert.setContentText("Are you sure!");
					Optional<ButtonType> result = delAlert.showAndWait();
					if(result.isPresent() && result.get() == ButtonType.OK) {
						OrderList orders = Table.getSelectionModel().getSelectedItem();
						int id = orders.getOrderID();
						try {
							Database db1 =  new Database();
							db1.preStatement = db1.connection.prepareStatement("DELETE FROM order_details WHERE OrderID= '"+id+"';");
							db1.preStatement.executeUpdate();
							Database db = new Database();
							db.preStatement = db.connection.prepareStatement("DELETE FROM orders WHERE OrderID= '"+id+"';");
							db.preStatement.executeUpdate();
							Table.refresh();
						} catch (Exception e) {
							Alert error = new Alert(AlertType.ERROR);
							error.setTitle("Error");
							error.setContentText(e.toString());
							error.show();
						}
					}
				}
				else {
					Alert error = new Alert(AlertType.ERROR);
					error.setTitle("Select Product");
					error.setContentText("Please Select an Item");
					error.show();
				}
				
			}
		});
	}

}
