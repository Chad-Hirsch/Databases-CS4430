import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class OrderList {
	public SimpleIntegerProperty OrderID;
	public StringProperty CustomerID;
	public SimpleIntegerProperty EmployeeID;
	public StringProperty OrderDate;
	public StringProperty RequiredDate;
	public StringProperty ShippedDate;
	public SimpleIntegerProperty ShipVia;
	public SimpleDoubleProperty Freight;
	public StringProperty ShipName;
	public StringProperty ShipAddress;
	public StringProperty ShipCity;
	public StringProperty ShipRegion;
	public StringProperty ShipPostalCode;
	public StringProperty ShipCountry;
	
	public OrderList() {
		OrderID = new SimpleIntegerProperty();
		CustomerID = new SimpleStringProperty();
		EmployeeID = new SimpleIntegerProperty();
		OrderDate = new SimpleStringProperty();
		RequiredDate = new SimpleStringProperty();
		ShippedDate = new SimpleStringProperty();
		ShipVia = new SimpleIntegerProperty();
		Freight = new SimpleDoubleProperty();
		ShipName = new SimpleStringProperty();
		ShipAddress = new SimpleStringProperty();
		ShipCity = new SimpleStringProperty();
		ShipRegion = new SimpleStringProperty();
		ShipPostalCode = new SimpleStringProperty();
		ShipCountry = new SimpleStringProperty();
	}

	public int getOrderID() {
		return this.OrderID.get();
	}

	public void setOrderID(int orderID) {
		this.OrderID.set(orderID);
	}

	public String getCustomerID() {
		return this.CustomerID.get();
	}

	public void setCustomerID(String customerID) {
		this.CustomerID.set(customerID);
	}

	public int getEmployeeID() {
		return this.EmployeeID.get();
	}

	public void setEmployeeID(int employeeID) {
		this.EmployeeID.set(employeeID);
	}

	public String getOrderDate() {
		return this.OrderDate.get();
	}

	public void setOrderDate(String orderDate) {
		this.OrderDate.set(orderDate);
	}

	public String getRequiredDate() {
		return this.RequiredDate.get();
	}

	public void setRequiredDate(String requiredDate) {
		this.RequiredDate.set(requiredDate);
	}

	public String getShippedDate() {
		return this.ShippedDate.get();
	}

	public void setShippedDate(String shippedDate) {
		this.ShippedDate.set(shippedDate);
	}

	public int getShipVia() {
		return this.ShipVia.get();
	}

	public void setShipVia(int shipVia) {
		this.ShipVia.set(shipVia);
	}

	public double getFreight() {
		return this.Freight.get();
	}

	public void setFreight(double freight) {
		this.Freight.set(freight);
	}

	public String getShipName() {
		return this.ShipName.get();
	}

	public void setShipName(String shipName) {
		this.ShipName.set(shipName);
	}

	public String getShipAddress() {
		return this.ShipAddress.get();
	}

	public void setShipAddress(String shipAddress) {
		this.ShipAddress.set(shipAddress);
	}

	public String getShipCity() {
		return this.ShipCity.get();
	}

	public void setShipCity(String shipCity) {
		this.ShipCity.set(shipCity);
	}

	public String getShipRegion() {
		return this.ShipRegion.get();
	}

	public void setShipRegion(String shipRegion) {
		this.ShipRegion.set(shipRegion);
	}

	public String getShipPostalCode() {
		return this.ShipPostalCode.get();
	}

	public void setShipPostalCode(String shipPostalCode) {
		this.ShipPostalCode.set(shipPostalCode);
	}

	public String getShipCountry() {
		return this.ShipCountry.get();
	}

	public void setShipCountry(String shipCountry) {
		this.ShipCountry.set(shipCountry);
	}
	

}
