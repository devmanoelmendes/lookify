<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Lookify</title>
</head>
<body>
	<a href="/songs/new"><button>Add New</button></a>
	<a href="/search/top"><button>Top 10 Songs</button></a>
	<form action="/search">
		<input type="text" name="artist">
		<input type="submit" value="Search Artists">
	</form>	
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
					<td><a href="/songs/${song.id}"><c:out value="${song.title}"/></a></td>
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