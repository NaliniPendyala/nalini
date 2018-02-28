<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
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

	Connection con =DriverManager.getConnection("jdbc:h2:tcp://localhost/~/demo","sa","sa@123");
	Statement st=con.createStatement();
	PreparedStatement ps= con.prepareStatement("select * from Details where sno=?");
	ps.setInt(1, Integer.parseInt(session.getAttribute("sno").toString()));
	ResultSet rs=ps.executeQuery();%>
	<table>
	<tr>
	<th>Sno</th>
	<th>Name</th>
	<th>Phno</th>
    </tr>
	<% while(rs.next())
	{%>
	<tr>
	<td><%=rs.getInt("sno")%></td>
	<td><%=rs.getString("name")%></td>
	<td><%=rs.getString("mobile")%></td>
	</tr> 
	<%}%>
	</table>
	
<% 	
	
}
catch(SQLException e)
{
	e.printStackTrace();
}
	

%>

</body>
</html>