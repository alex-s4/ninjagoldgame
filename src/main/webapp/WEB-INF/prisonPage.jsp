<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>The Prison</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Welcome to the debtor's prison. Pom!</h1>
	<h2>You are a prisoner!</h2>
    <a href="../">Go back</a>
    
    <form action="/processClick" method="post">   
        <input type="hidden" value="reset" name="selectC">
        <input type="submit" value="RELOAD">
    </form>
</body>
</html>