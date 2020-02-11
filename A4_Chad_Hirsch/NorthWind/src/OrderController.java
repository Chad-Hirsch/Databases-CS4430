/*
 * Chad Hirsch
 * CS4430
 * DUE: 11/12/2019
 */

import java.net.URL;
import java.sql.Date;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class OrderController implements Initializable{
	@FXML
	private  DatePicker OrderDate;
	@FXML
	private  DatePicker RequiredDate;
	@FXML
	private TextField Freight;
	@FXML
	private TextField ShipName;
	@FXML
	private TextField ShipAddress;
	@FXML
	private TextField ShipCity;
	@FXML
	private TextField ShipRegion;
	@FXML
	private TextField ShipCountry;
	@FXML
	private TextField CustomerID;
	@FXML
	private TextField EmployeeID;
	@FXML
	private DatePicker ShippedDate;
	@FXML
	private TextField ShipVia;
	@FXML
	private TextField ShipPostalCode;
	@FXML
	private TextField ProductID;
	@FXML
	private TextField UnitPrice;
	@FXML
	private TextField Quantity;
	@FXML
	private TextField Discount;
	@FXML
	private Button Save;
	int id = 0;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		Save.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if(CustomerID.getText().isEmpty() || Freight.getText().isEmpty() || ShipName.getText().isEmpty() ||
						ShipAddress.getText().isEmpty() || ShipCity.getText().isEmpty() || ShipRegion.getText().isEmpty() || ShipCountry.getText().isEmpty()
						|| EmployeeID.getText().isEmpty() ||ShipVia.getText().isEmpty() || ShipPostalCode.getText().isEmpty()){
					Alert empty = new Alert(AlertType.ERROR);
					empty.setTitle("Error");
					empty.setHeaderText("Please Fill All Fields!");
					empty.show();
				}

				else {
					try {
						Database db = new Database();
						db.preStatement = db.connection.prepareStatement("INSERT INTO orders(OrderDate,RequiredDate,Freight,ShipName,ShipAddress,"
								+ "ShipCity,ShipRegion,ShipCountry,CustomerID,EmployeeID,ShippedDate,ShipVia,ShipPostalCode)"
								+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);			
						db.preStatement.setString(1, OrderDate.valueProperty().get().toString());
						db.preStatement.setString(2, RequiredDate.valueProperty().get().toString());
						db.preStatement.setDouble(3, Double.valueOf(Freight.getText()));
						db.preStatement.setString(4, ShipName.getText());
						db.preStatement.setString(5, ShipAddress.getText());
						db.preStatement.setString(6, ShipCity.getText());
						db.preStatement.setString(7, ShipRegion.getText());
						db.preStatement.setString(8, ShipCountry.getText());
						db.preStatement.setString(9, CustomerID.getText());
						db.preStatement.setInt(10, Integer.valueOf(EmployeeID.getText()));
						db.preStatement.setString(11, ShippedDate.valueProperty().get().toString());
						db.preStatement.setInt(12, Integer.valueOf(ShipVia.getText()));
						db.preStatement.setString(13, ShipPostalCode.getText());
						db.preStatement.executeUpdate();
						db.result = db.preStatement.getGeneratedKeys();
						if(db.result.next()) {
							id = db.result.getInt(1);
						}
						Database db1 = new Database(); 
						db1.preStatement = db1.connection.prepareStatement("INSERT INTO order_details(OrderID,ProductID,UnitPrice,Quantity,Discount) VALUES(?,?,?,?,?)");
						db1.preStatement.setInt(1, id);
						db1.preStatement.setInt(2, Integer.valueOf(ProductID.getText()));
						db1.preStatement.setDouble(3, Double.valueOf(UnitPrice.getText()));
						db1.preStatement.setInt(4,Integer.valueOf(Quantity.getText()));
						db1.preStatement.setDouble(5, Double.valueOf(Discount.getText()));
						db1.preStatement.executeUpdate();
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Data Saved");
						alert.setHeaderText("Data Saved");
						Optional<ButtonType> result = alert.showAndWait();
						if(result.get()==ButtonType.OK){
							Freight.clear();
							OrderDate.setValue(null);
							RequiredDate.setValue(null);
							ShippedDate.setValue(null);
							ShipName.clear();
							ShipAddress.clear();
							ShipCity.clear();
							ShipRegion.clear();
							ShipCountry.clear();
							CustomerID.clear();
							EmployeeID.clear();
							ShipVia.clear();
							ShipPostalCode.clear();
							ProductID.clear();
							UnitPrice.clear();
							Quantity.clear();
							Discount.clear();
						}
					} catch (Exception e) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Data Not Saved");
						alert.setHeaderText(e.toString());
						Optional<ButtonType> result = alert.showAndWait();
					}
				}
				
			}
		});
		
	}

}
