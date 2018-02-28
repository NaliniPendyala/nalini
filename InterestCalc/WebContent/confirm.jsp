<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirm</title>
</head>
<body>
<%
float si= Float.parseFloat(request.getAttribute("si").toString());
out.println("The Simple Interest is "+ si);
try {
	Class.forName("org.h2.Driver");
	
	Connection con= DriverManager.getConnection("jdbc:h2:tcp://localhost/~/demo", "sa","sa@123");
	PreparedStatement ps= con.prepareStatement("insert into loan values (?,?,?,?,?,?)");
	ps.setString(1,request.getParameter("name"));
	ps.setString(2, request.getParameter("email"));
	ps.setFloat(3, Float.parseFloat(request.getParameter("principal")));
	ps.setFloat(4, si);
	ps.setInt(5, Integer.parseInt(request.getParameter("tenure")));
	ps.setString(6, "pending");		
	ps.setFloat(parameterIndex, x);
}catch(Exception e) {
	e.printStackTrace();	
}

	}

</body>
</html>