import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DbExample {

	public static void main(String[] args) {
		
		try {
			
			Class.forName("org.h2.Driver");
			
		Connection conn= DriverManager.getConnection("jdbc:h2:tcp://localhost/~/demo","sa","sa@123");
	
		PreparedStatement ps= conn.prepareStatement("insert into Details values(?,?,?)" );
	}catch( Exception e)
		{
		System.out.println(e);
		}

}
}
