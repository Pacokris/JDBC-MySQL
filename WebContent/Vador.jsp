<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>StarWars</title>
	</head>
	<body>
    	<ul>
	        <c:forEach var="force" items="${ Vador }">
	            <li><c:out value="${ force.name }"/><c:out value="${ force.surname }"/></li>
	        </c:forEach>
    	</ul> 
	</body>
</html>