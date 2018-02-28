<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="detailsSevlet" method=get>

Enter role: <select name="role">
  <option value="emp">Employee</option>
  <option value="stu">Student</option>
 </select>
 <br>
Enter the user name:<input name="name" type=text>

<%if(request.getAttribute("name")!=null)
{
out.println(request.getAttribute("name"));
}
%>
<br>
Enter the password: <input name="pwd" type=password>


<br>
Enter the email Id:<input name="email" type=text>
<%if(request.getAttribute("email")!=null)
{
out.println(request.getAttribute("email"));
}
%>
<br>
Enter the Phone Number:<input name="phno" type=text>
<input type=submit>
</form>

</body>
</html>