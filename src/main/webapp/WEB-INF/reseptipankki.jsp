<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Reseptipankki</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" />
</head>
<body>
	<h1>Reseptipankin reseptit:</h1>
	<table class="table table_striped">
		<tr>
			<th>reseptiId</th>
			<th>Annoksia</th>
			<th>Reseptin nimi</th>
			<th>Valmistusaika</th>
			<th>Ainesosat</th>
			<th>Ohje</th>
		</tr>
		<c:forEach items="${reseptit}" var="resepti">
			<tr>
				<td><p><c:out value="${resepti.reseptiId}" /></p></td>
				<td><p><c:out value="${resepti.annoksia}" /></p></td>
				<td><p><c:out value="${resepti.reseptiNimi}" /></p></td>
				<td><p><c:out value="${resepti.valmistusAika}" /></p></td>
				<td><p>
						<c:out value="${resepti.ainesosat}" />
					</p></td>
				<td><p>
						<c:out value="${resepti.ohje}" />
					</p></td>
				<td><a class="btn btn-primary" href="/muokkaa-resepti?reseptiid=<c:out value='${resepti.reseptiId}'/>" role="button">Muokkaa</a></td>
				<td><a class="btn btn-primary" href="/poista-resepti?reseptiid=<c:out value='${resepti.reseptiId}'/>" role="button">Poista</a></td>
			</tr>
		</c:forEach>
		
	</table>
	<p><a class="btn btn-primary"  href="/localhost:8080" role="button">Takaisin etusivulle</a></p>
</body>
</html>