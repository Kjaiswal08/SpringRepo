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
	
	<form action="upload" method="post" enctype="multipart/form-data">
	        <label for="file1">Enter File:</label>
	        <input type="file" name="file" id="file1"><br>
	        <input type="submit" value="Upload">
	    </form>
		
	
</body>
</html>
