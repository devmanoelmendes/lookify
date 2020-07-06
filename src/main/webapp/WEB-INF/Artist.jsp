<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Search</title>
</head>
<body>
	<p>Songs by artist: <c:out value="${artist}"/></p>
	<form action="/search">
		<input type="text" name="artist">
		<input type="submit" value="Search Artists">
	</form>
	<a href="/songs"><button>Dashboard</button></a>
	<table>
		<thead>
		  <tr>
			<th>Name</th>
			<th>Rating</th>
			<th>Actions</th>
		  </tr>
		</thead>
		<tbody>
			<tr>
				<c:forEach var="song" items="${songs}">
				  <tr>
					<td><c:out value="${song.title}"/></td>
					<td><c:out value="${song.rating}"/></td>
					<td>
						<form action="/songs/${song.id}/delete" method="POST">
							<input type="hidden" name="_method" value="DELETE">
							<input type="submit" value="Delete">
						</form>					
					</td>
				  </tr>
				</c:forEach>
			</tr>
		</tbody>
	</table>
</body>
</html>