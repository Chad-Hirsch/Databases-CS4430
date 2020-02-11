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

public class CustomerController implements Initializable{

	@FXML
	private TextField CustomerID;
	@FXML
	private TextField ContactName;
	@FXML
	private TextField ContactTitle;
	@FXML
	private TextField Address;
	@FXML
	private TextField Country;
	@FXML
	private TextField Phone;
	@FXML
	private TextField Fax;
	@FXML
	private TextField CompanyName;
	@FXML
	private TextField City;
	@FXML
	private TextField Region;
	@FXML
	private TextField PostalCode;
	@FXML
	private Button Save;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Save.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				if(CustomerID.getText().isEmpty() || ContactName.getText().isEmpty() || ContactTitle.getText().isEmpty() ||
						Address.getText().isEmpty() || Country.getText().isEmpty() || Phone.getText().isEmpty() || Fax.getText().isEmpty()
						|| CompanyName.getText().isEmpty() ||City.getText().isEmpty() || Region.getText().isEmpty() || PostalCode.getText().isEmpty()){
					Alert empty = new Alert(AlertType.ERROR);
					empty.setTitle("Error");
					empty.setHeaderText("Please Fill All Fields!");
					empty.show();
				}
				else {
					try {
						Database db = new  Database();
						db.preStatement = db.connection.prepareStatement("INSERT INTO customers(CustomerID,ContactName,ContactTitle,"
								+ "Address,Country,Phone,Fax,CompanyName,City,Region,PostalCode) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
						db.preStatement.setString(1, CustomerID.getText());
						db.preStatement.setString(2, ContactName.getText());
						db.preStatement.setString(3, ContactTitle.getText());
						db.preStatement.setString(4, Address.getText());
						db.preStatement.setString(5, Country.getText());
						db.preStatement.setString(6, Phone.getText());
						db.preStatement.setString(7, Fax.getText());
						db.preStatement.setString(8, CompanyName.getText());
						db.preStatement.setString(9, City.getText());
						db.preStatement.setString(10, Region.getText());
						db.preStatement.setString(11, PostalCode.getText());
						db.preStatement.executeUpdate();
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Data Saved");
						alert.setHeaderText("Data Saved");
						Optional<ButtonType> result = alert.showAndWait();
						if(result.get()==ButtonType.OK){
							CustomerID.clear();
							ContactName.clear();
							ContactTitle.clear();
							Address.clear();
							Country.clear();
							Phone.clear();
							Fax.clear();
							CompanyName.clear();
							City.clear();
							Region.clear();
							PostalCode.clear();
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
