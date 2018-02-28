package UserLogIn;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/detailsSevlet")
public class detailsSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public detailsSevlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		boolean flag= true;

		 if(request.getParameter("name").equals("") )
		 {
			 request.setAttribute("name", "Please enter name");
			 flag=false;
		 }
		 
		
		 if(request.getParameter("email").equals("") ) {
			 request.setAttribute("email", "Please enter email");
		 flag=false;
		 }
		
		 if (flag)
		 {
		try {
			Class.forName("org.h2.Driver");
			
			//Open connection for h2
		 Connection con= DriverManager.getConnection("jdbc:h2:tcp://localhost/~/demo", "sa","sa@123");
		
		 PreparedStatement ps= con.prepareStatement("insert into Info values (?,?,?,?,?)");
		
		 ps.setString(1, request.getParameter("name"));
		 ps.setString(2, request.getParameter("pwd"));
		 ps.setString(3, request.getParameter("email"));
		 ps.setString(4,request.getParameter("phno"));
		 ps.setString(5,request.getParameter("role"));
	
		int i= ps.executeUpdate();
		 if (i>0)
		 {
			 response.sendRedirect("login.jsp");
		
		 }
		 
		 }catch (ClassNotFoundException e)
		 {
		 	System.out.println("Driver not found");
		 }
		 	catch (SQLException e)
		 {
		 	System.out.println("Connection not established");
		  }
		 	
		
		
		 }
		 else {
			 response.setContentType("text/html");
			 RequestDispatcher rd= request.getRequestDispatcher("Registration.jsp");
			 rd.forward(request, response);
		 }
		 }
		
		
	
		//session.setAttribute("name", request.getParameter("name"));
		
	

	
}
