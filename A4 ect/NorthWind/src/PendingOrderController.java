import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class PendingOrderController implements Initializable {

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
	private ObservableList<OrderList> DataList;
	
	
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		DataList = FXCollections.observableArrayList();
		try {
			Database db = new Database();
			db.preStatement = db.connection.prepareStatement("SELECT * FROM orders WHERE ShippedDate IS NULL");
			db.result = db.preStatement.executeQuery();
			while (db.result.next()) {
				OrderList order = new OrderList();
				order.setOrderID(db.result.getInt(1));
				order.setCustomerID(db.result.getString(2));
				order.setEmployeeID(db.result.getInt(3));
				order.setOrderDate(db.result.getDate(4).toString());
				order.setRequiredDate(db.result.getDate(5).toString());
				order.setShippedDate("NULL");
				order.setShipVia(db.result.getInt(7));
				order.setFreight(db.result.getDouble(8));
				order.setShipName(db.result.getString(9));
				order.setShipAddress(db.result.getString(10));
				order.setShipCity(db.result.getString(11));
				order.setShipRegion(db.result.getString(12));
				order.setShipPostalCode(db.result.getString(13));
				order.setShipCountry(db.result.getString(14));
				DataList.add(order);			
				}
			
		}catch (Exception e) {
			Alert error = new Alert(AlertType.ERROR);
			error.setTitle("Error");
			error.setContentText(e.toString());
			error.show();
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
		Table.setItems(DataList);
	}

}
