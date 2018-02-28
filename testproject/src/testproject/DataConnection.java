package testproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class DataConnection {

	public static void main(String[] args) {
		//Register the database
		
		//Class.forName("oracle.jdbc.driver.JdbcDriver";
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter Num");
		int sno1= sc.nextInt();
		//System.out.println("Enter name");
		//sc.nextLine();
		//String name=sc.nextLine();
		//System.out.println("Enter phone");
		//String ph= sc.nextLine();
		//try {
		//Class.forName("org.h2.Driver");
		
		//Open connection for mysql
	 //Connection con= DriverManager.getConnection("jdbc:h2:tcp://localhost/~/demo", "sa","sa@123");
	 //Statement st= con.createStatement();
	 //all DML operations use executeUpdate
	// int i= st.executeUpdate("insert into Details values(1, 'name1', '1234')");
	 //int j= st.executeUpdate("update Details set SNO = where SNO=1");

	// PreparedStatement ps= con.prepareStatement("insert into details values (?,?,?)");
	 //PreparedStatement ps= con.prepareStatement("update Details set mobile =? where name='Nalini' ");
	 //ps.setInt(1, sno);
	 //ps.setString(2, name);
	 //ps.setString(1, ph);
	 //int i= ps.executeUpdate();
	 
	 
	 
		//if(i>0)
		//System.out.println("record inserted");
		
	//	else
	//	System.out.println("Failed");	
		
	//	}catch (ClassNotFoundException e)
	//	{
	//		System.out.println("Driver not found");
	//	} catch (SQLException e)
	//	{
	//		System.out.println("Connection not established");
		//}
		
		
try {
	DriverManager.registerDriver( new org.h2.Driver() );

	Connection con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/demo","sa","sa@123");
	Statement st=con.createStatement();
	PreparedStatement ps= con.prepareStatement("select * from Details where sno=?");
	ps.setInt(1, sno1);

	//ResultSet rs= st.executeQuery("select * from Details");
	ResultSet rs=ps.executeQuery();
	
			while(rs.next())
				
			{
				int sno=rs.getInt("Sno");
				String name=rs.getString("name");
				String mob=rs.getString("mobile");
				System.out.println(sno +" " +name+ " " + mob);
			}
}	catch(SQLException e)
{
	e.printStackTrace();
}

	}		
	

}
