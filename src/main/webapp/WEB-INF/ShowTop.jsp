<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Top Ten Songs</title>
</head>
<body>
	<h1>Top Ten Songs</h1>
	<table>
		<thead>
		  <tr>
			<th>Rating</th>
			<th>Title</th>
			<th>Artist</th>
		  </tr>
		</thead>
		<tbody>
			<tr>
				<c:forEach var="song" items="${songs}">
				  <tr>
					<td><c:out value="${song.rating}"/></td>
					<td><a href="/songs/${song.id}"><c:out value="${song.title}"/></a></td>
					<td><c:out value="${song.artist}"/></td>
				  </tr>
				</c:forEach>
			</tr>
		</tbody>
	</table>
	<a href="/songs"><button>Dashboard</button></a>
</body>
</html>