package dbtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataConnection {

	public static void main(String[] args) {
		//Register the database
		
		//Class.forName("oracle.jdbc.driver.JdbcDriver";
		
		try {
		Class.forName("org.h2.Driver");
		
		//Open connection for h2 DB
	 Connection con= DriverManager.getConnection("jdbc:h2:tcp://localhost/~/demo","sa","sa@123");
	 Statement st= con.createStatement();
	 int i= st.executeUpdate("insert into Details values(1, 'name', '1234')");
		if(i>0)
		System.out.println("record inserted");
		
		else
		System.out.println("Failed");	
		
		}catch (ClassNotFoundException e)
		{
			System.out.println("Driver not found");
		} catch (SQLException e)
		{
			System.out.println("Connection not established");
		}
		
		

		
	}

}
