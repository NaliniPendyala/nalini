package FirstApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SecondServlet
 */
@WebServlet("/Second")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	HttpSession session = request.getSession();
	//response.getWriter().println(session.getAttribute("sno"));
	//response.getWriter().println(session.getAttribute("name"));
	//response.getWriter().println(session.getAttribute("phno"));
	
	//	response.getWriter().println(request.getParameter("sno"));
	//	response.getWriter().println(request.getParameter("name"));
		
	//	response.getWriter().println(request.getParameter("phno"));
	PrintWriter out = response.getWriter();
	
	try {
		DriverManager.registerDriver( new org.h2.Driver() );

		Connection con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/demo","sa","sa@123");
		Statement st=con.createStatement();
		PreparedStatement ps= con.prepareStatement("select * from Details where sno=?");
		ps.setInt(1, Integer.parseInt(session.getAttribute("sno").toString()));
		ResultSet rs=ps.executeQuery();
		
		while(rs.next())
			
		{
			out.println(rs.getInt("sno") +" " +rs.getString("name")+ " " + rs.getString("mobile"));
		}
		
		
		
		
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
		
		
	}

}
