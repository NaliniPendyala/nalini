package testproject;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public TestServlet() {
        super();
    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
	
	RequestDispatcher rd= request.getRequestDispatcher("testHTML.html");		
	
	boolean flag=true;
	
	
	
	if(request.getParameter("text1") == "") 
	{
	out.println("please enter text1 value");
	flag=false;
	}
	
	
		if(request.getParameter("text2") == "")
		{
		out.println("please enter text2 value");
		flag=false;
		}
		
		if(request.getParameter("text3") == "") {
		out.println("please enter text3 value");
		flag=false;
		}
		
	
	
	if(request.getParameter("radio") ==null)
	{
		out.println("please enter radio value");
		flag=false;
	}
	

	if (!flag)
	rd.include(request, response);
	
	else
	{	
//	out.println(request.getParameter("text1"));
	//out.println(request.getParameter("text2"));
//	out.println(request.getParameter("text3"));

//	out.println(request.getParameter("radio"));
		
		response.sendRedirect("message.html");
	}
 }
}
