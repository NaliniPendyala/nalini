<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<form method="get" action="InterestServlet">
<Table width="100%">
<Tr>
<TD> Enter name: </TD><TD><input name= "name" type="text"></TD> 
</Tr>
<Tr>
<TD> Enter email: </TD><TD><input name= "email" type="text"></TD> 
</Tr>
<Tr>
<TD> Enter principal: </TD><TD><input name= "principal" type="text"></TD> 
</Tr>
<Tr>
<TD> Enter tenure: </TD><TD><input name= "tenure" type="text"></TD> 
</Tr>
</Table>
<input type="submit">
</form>
</body>
</html>