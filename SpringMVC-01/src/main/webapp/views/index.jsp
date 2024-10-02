<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>My First JSP Page</title>
</head>
<body>
    <h1>Welcome to My First JSP Page!</h1>
    <%
        // Java code block
        String message = "Hello, World!";
        out.println("<p>" + message + "</p>");
    %>
    <p>The current date and time is: <%= new java.util.Date() %></p>
	<form action="add">
			Enter 1st number=<input type="text" name="nums1"></br>
			Enter 2nd number=<input type="text" name="nums2"></br>
			<input type="submit">
		</form>
		
	
	<form action="employee"  method="POST">
			Enter Employee Id=<input type="text" name="empid"></br>
			Enter Employee Name=<input type="text" name="empname"></br>
			<input type="submit">
	</form>
	
	<form action="getemployee"  method="GET">
		
		This returns a list of employee which are not from the Database and are stored  in a list
		when the above action is runned.
		<input type="submit">
	</form>
	
	<form action="getemployee1"  method="GET">
		This returns a list of employee from database.
			<input type="submit">
		</form>
		
		
		<form action="getoneemployee"  method="GET">
				This returns a single employee by id.
				Enter Employee Id=<input type="text" name="empid"></br>
					<input type="submit">
				</form>
				
	<form action="getemployeebyname"  method="GET">
					This returns a list of employee by iName.
					Enter Employee Id=<input type="text" name="empname"></br>
				<input type="submit">
	</form>
</body>
</html>
