<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Reseptipankki</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" />
</head>
<body>
	<h1>Tervetuloa reseptipankkiin</h1>

	<h3>Reseptipankin reseptit:</h3>
	<c:forEach items="${reseptit}" var="resepti">
		<tr>
			<td><c:out value="${resepti.reseptiNimi}" /></td>
		</tr><br>
	</c:forEach>
	<br>
	<p>
	<a class="btn btn-primary" href="listaa-reseptit" role="button">Listaa kaikki reseptit</a>
	</p>
	<br>
	<p>
	<a class="btn btn-primary" href="lisaa-resepti" role="button">Lisää resepti</a>
	</p>
</body>
</html>