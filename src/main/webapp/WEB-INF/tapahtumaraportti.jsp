<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" />
<title>Insert title here</title>
</head>
<body>

	<h1>Tapahtumaraportti</h1>
	<p>
		<c:out value="${viesti}" />
	<p>
	<p>
		<a href="/listaa-reseptit">Resepti</a>
	</p>
</body>
</html>