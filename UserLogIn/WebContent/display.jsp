<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
try {
		DriverManager.registerDriver( new org.h2.Driver() );

		Connection con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/demo","sa","sa@123");
		Statement st=con.createStatement();
		PreparedStatement ps= con.prepareStatement("select * from Info where email=?");
		ps.setString(1,request.getParameter("email"));
		ResultSet rs=ps.executeQuery();
		
		if(rs.next()){
	     %>
		<table>
		<tr>
		<th>Name</th>
		<th>Email</th>
		<th>phno</th>
		<% 
		if(rs.getString("role").equals("emp" ))
	     {		
		%>
		<th>Employee</th>
		<% }else{%>
		<th>Student</th>
		<%}%>
	    </tr>
		<tr>
		<td><%=rs.getString("name")%></td>
		<td><%=rs.getString("email")%></td>
		<td><%=rs.getString("phno")%></td>
		<td><%=rs.getString("role")%></td>
		</tr> 
		</table>
		
	<% 	
		
		}
		
}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
		%>
		
</body>
</html>