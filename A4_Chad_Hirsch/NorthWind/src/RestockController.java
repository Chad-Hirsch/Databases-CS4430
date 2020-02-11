/*
 * Chad Hirsch
 * CS4430
 * DUE: 11/12/2019
 */

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class RestockController implements Initializable{

	@FXML
	private TextField ProductName;
	@FXML
	private TextField SupplierID;
	@FXML
	private TextField CategoryID;
	@FXML
	private TextField QuantityPerUnit;
	@FXML
	private TextField UnitPrice;
	@FXML
	private TextField UnitInStock;
	@FXML
	private TextField UnitsPerOrder;
	@FXML
	private TextField ReorderLevel;
	@FXML
	private TextField Discontinued;
	@FXML
	private Button Save;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Save.setOnAction(new EventHandler<ActionEvent>() {
				
			@Override
			public void handle(ActionEvent arg0) {
				if(ProductName.getText().isEmpty() || SupplierID.getText().isEmpty() || CategoryID.getText().isEmpty() ||
						QuantityPerUnit.getText().isEmpty() || UnitPrice.getText().isEmpty() || UnitInStock.getText().isEmpty() || UnitsPerOrder.getText().isEmpty()
						|| ReorderLevel.getText().isEmpty() ||Discontinued.getText().isEmpty()){
					Alert empty = new Alert(AlertType.ERROR);
					empty.setTitle("Error");
					empty.setHeaderText("Please Fill All Fields!");
					empty.show();
				}
				else {
					try {
						Database db = new Database();
						db.preStatement = db.connection.prepareStatement("INSERT INTO products(ProductName,SupplierID,CategoryID,QuantityPerUnit,UnitPrice,UnitsInStock,UnitsOnOrder,ReorderLevel,Discontinued)"
								+ "VALUES(?,?,?,?,?,?,?,?,?)");
						db.preStatement.setString(1,ProductName.getText());
						db.preStatement.setInt(2, Integer.valueOf(SupplierID.getText()));
						db.preStatement.setInt(3, Integer.valueOf(CategoryID.getText()));
						db.preStatement.setString(4, QuantityPerUnit.getText());
						db.preStatement.setDouble(5,Double.valueOf(UnitPrice.getText()));
						db.preStatement.setInt(6, Integer.valueOf(UnitInStock.getText()));
						db.preStatement.setInt(7, Integer.valueOf(UnitsPerOrder.getText()));
						db.preStatement.setInt(8, Integer.valueOf(ReorderLevel.getText()));
						db.preStatement.setString(9,Discontinued.getText());
						db.preStatement.executeUpdate();
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Data Saved");
						alert.setHeaderText("Data Saved");
						Optional<ButtonType> result = alert.showAndWait();
						if(result.get()==ButtonType.OK){
							ProductName.clear();
							SupplierID.clear();
							CategoryID.clear();
							QuantityPerUnit.clear();
							UnitPrice.clear();
							UnitInStock.clear();
							UnitsPerOrder.clear();
							ReorderLevel.clear();
							Discontinued.clear();
						}
					} catch (Exception e) {
						Alert error = new Alert(AlertType.ERROR);
						error.setTitle("Select Product");
						error.setContentText(e.toString());
						error.show();
					}
				}
				
			}
		});
		
	}

}
