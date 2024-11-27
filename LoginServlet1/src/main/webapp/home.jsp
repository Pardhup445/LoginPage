<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String name=(String)session.getAttribute("name");
		String email=(String)session.getAttribute("email");
		String desig=(String)session.getAttribute("desig");
		String salary=(String)session.getAttribute("salary");
		String password=(String)session.getAttribute("password");
	%>
   <h1>Welcome<% out.println(" "+name); %></h1>
   <p>Your Profile Details Are as Follows</p>
   Email:<% out.println(email); %><br>
   Designation:<% out.println(desig); %><br>
   Salary:<% out.println(salary); %><br>
   Password:<% out.println(password); %><br>
</body>
</html>