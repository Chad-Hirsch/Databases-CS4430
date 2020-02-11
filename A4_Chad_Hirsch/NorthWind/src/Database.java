/*
 * Chad Hirsch
 * CS4430
 * DUE: 11/12/2019
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
	public Connection connection = null;
	public PreparedStatement preStatement = null;
	public ResultSet result = null;
		private final static String CONNECTION_URL = "jdbc:mysql://localhost/northwind";
		public Database() {
			try {
				connection = DriverManager.getConnection(CONNECTION_URL,"root","");
			} catch (SQLException e) {
				System.out.println("Cannot Connect to the Database:  " + e.getMessage());
			}
		}

}
