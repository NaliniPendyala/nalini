package InterestCalc;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns="/InterestServlet",initParams=@WebInitParam(name="rate", value="5"))


public class InterestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public InterestServlet() {
        super();

    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*try {
	Class.forName("org.h2.Driver");
	
	Connection con= DriverManager.getConnection("jdbc:h2:tcp://localhost/~/demo", "sa","sa@123");
	PreparedStatement ps= con.prepareStatement("insert into loan values (?,?,?,?,?)");
	ps.setString(1,request.getParameter("name"));
	ps.setString(2, request.getParameter("email"));
	ps.setFloat(3, Float.parseFloat(request.getParameter("principal")));
	
			
	ps.setFloat( , 3);
	ps.setString('principal", 3);
			
	ps.setFloat(parameterIndex, x);
}catch(Exception e) {
	e.printStackTrace();	
}

	}*/
		
		Float si;
		Float p=Float.parseFloat(request.getParameter("principal"));
		Float rate;
		ServletConfig s= getServletConfig();
		rate=Float.parseFloat(s.getInitParameter("rate"));
		int t= Integer.parseInt(request.getParameter("tenure"));
		si=(p*t*rate)/100;
		
		request.setAttribute("si",si);
	RequestDispatcher rd= request.getRequestDispatcher("confirm.jsp");
		
		
	}


	}


