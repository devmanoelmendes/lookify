<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Details</title>
</head>
<body>	
	<p> Title: <c:out value="${song.title}"/></p>
	<p> Artist: <c:out value="${song.artist}"/></p>
	<p> Rating (1-10): <c:out value="${song.rating}"/></p>
	<a href="/songs"><button>Dashboard</button></a>
	<form action="/songs/${song.id}/delete" method="POST">
		<input type="hidden" name="_method" value="DELETE">
		<input type="submit" value="Delete">
	</form>
</body>
</html>