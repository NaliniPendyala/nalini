package FirstApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SimpleServlet")

public class SimpleServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
	// PrintWriter p = res.getWriter();
	 //p.print("Welcome");
		
		Enumeration<String> headerNames= req.getHeaderNames();
		
		//PrintWriter p = res.getWriter(
		PrintWriter out = res.getWriter();
		//res.setIntHeader("Refresh", 5);
		res.setContentType("text/html");

		
		while(headerNames.hasMoreElements()) {
				
			String name= headerNames.nextElement();
			//out.println(name + "" + req.getHeader(name));
					
				}
		//res.addHeader("sdasd", "asdasd");
		//Collection<String> headerNamesRes= res.getHeaderNames();
		//Iterator<String> i = headerNamesRes.iterator();
	//	out.print("response headers");
		
//		while(i.hasNext())
	//	{
		//String headerName = i.next();
		//out.println(headerName  + " " +res.getHeader(headerName));
	//}
		
		try {
				Class.forName("org.h2.Driver");
				
				//Open connection for h2
			 Connection con= DriverManager.getConnection("jdbc:h2:tcp://localhost/~/demo", "sa","sa@123");
			 PreparedStatement ps= con.prepareStatement("insert into Details values (?,?,?)");
			 ps.setInt(1, Integer.parseInt(req.getParameter("sno")));
			 ps.setString(2, req.getParameter("name"));
			 ps.setString(3,req.getParameter("phno"));
		
			int i= ps.executeUpdate();
			
			 if (i>0)
			 {
				 out.println("The records are inserted");
			
			 }
			
			 			 
	}catch (ClassNotFoundException e)
	{
		System.out.println("Driver not found");
	}
		catch (SQLException e)
	{
		System.out.println("Connection not established");
     }
		
		
		
		
		//out.println(req.getParameter("firstname"));
	//	out.println(req.getParameter("lastname"));
	//	out.println(req.getParameter("add1"));
	//	out.println(req.getParameter("add2"));
		
		//String [] checkboxvalues;
		//checkboxvalues= req.getParameterValues("check");
		
	//for(String val :checkboxvalues)
		//{
			//out.println(val);
	//	}
		//redirect this out put to a html. To do that we use RequestDispatcher interface. Used to redirect servelt output to a html, servlet ijsp.
		
		
		// redirect to redirect.html
		HttpSession session= req.getSession();
		session.setAttribute("sno", req.getParameter("sno"));
		res.sendRedirect("second.jsp");
		
		//RequestDispatcher rd= req.getRequestDispatcher("Second");
	
//		rd.forward(req, res);
		
		//usign include mehod.
		 //rd.include(req,res);
		//There is another method called sendRedirect whch we can use over RequestDispatcher method.
		
		//res.sendRedirect("redirect.html");
		
		// sessions are created by server for every new request
		
		
		//place data to pass in header
		


		
		
		
		
	}
}
