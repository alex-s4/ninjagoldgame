<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Ninja Gold Game</title>
        <link rel="stylesheet" href="../css/style.css">
    </head>
    <body>
    	<div>
    		<h2>Your Gold: <input type="text" value="${totalGold}" disabled></h2>
    		<label></label>
    	</div>

        <div class="main-box">
            <div class="fcontainer">
                <h3>Farm</h3>
                <p>(earns 10-20 gold)</p>
                <form action="/processClick" method="post">    
                    <input type="hidden" value="farm" name="selectB">
                    <input type="submit" value="Find Gold!">
                </form>
            </div>
    
            <div class="fcontainer">
                <h3>Cave</h3>
                <p>(earns 5-10 gold)</p>
                <form action="/processClick" method="post">
                    <input type="hidden" value="cave" name="selectB">
                    <input type="submit" value="Find Gold!">
                </form>
            </div>

            <div class="fcontainer">
                <h3>House</h3>
                <p>(earns 2-5 gold)</p>
                <form action="/processClick" method="post">
                    <input type="hidden" value="house" name="selectB">
                    <input type="submit" value="Find Gold!">
                </form>
            </div>

            <div class="fcontainer">
                <h3>Quest</h3>
                <p>(earns/takes 0-50 gold)</p>
                <form action="/processClick" method="post">   
                    <input type="hidden" value="quest" name="selectB">
                    <input type="submit" value="Find Gold!">
                </form>
            </div>

            <div class="fcontainer">
                <h3>Spa</h3>
                <p>(takes 5-20 gold)</p>
                <form action="/processClick" method="post">   
                    <input type="hidden" value="spa" name="selectB">
                    <input type="submit" value="Find Gold!">
                </form>
            </div>

        </div>

        <form action="/processClick" method="post">   
            <input type="hidden" value="reset" name="selectB">
            <input type="submit" value="RESET">
        </form>

        <div class="cbox">
            <c:forEach var="log" items="${activityLog}">
            	<p>${log}</p>
            </c:forEach>

        </div>

        
        

            
            
            
        
        
        
    </body>
</html>