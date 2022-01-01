<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link href="styles/demo.css" rel="stylesheet" type="text/css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css">
<title>Muokkaa Resepti</title>
<style type="text/css">
label {
	display: block;
	width: 8em;
	float: left;
}
</style>
</head>
<body>
<h1>Muokkaa Resepti</h1>
	<form action="/muokkaa-resepti" method="post">
	<p> 													<%-- reseptipankki.getAnnoksia(); --%>
			<label>ReseptiId:</label> <input type="text" value="<c:out value='${resepti.reseptiId}' />" name="reseptiid"
				size="50" />
		</p>
		<p>
			<label>Annoksia:</label> <input type="text" value="<c:out value='${resepti.annoksia}' />" name="annoksia"
				size="50" />
		</p>
		<p>
			<label>Reseptinimi:</label> <input type="text" value="<c:out value='${resepti.reseptiNimi}' />" name="reseptiNimi"
				size="50" />
		</p>
		<p>
			<label>ValmistusAika:</label> <input type="text" value="<c:out value='${resepti.valmistusAika}' />" name="valmistusAika"
				size="50" />
		</p>
		<p>
			<label>Ainesosat:</label> <input type="text" value="<c:out value='${resepti.ainesosat}' />" name="ainesosat"
				size="50" />
		</p>
		<p>
			<label>Ohje:</label> <input type="text" value="<c:out value='${resepti.ohje}' />" name="ohje"
				size="50" />
		</p>

		<p>
		<a class="btn btn-primary" href="/listaa-reseptit" role="button">Peruuta</a>
		<input type="submit" name="submit-button" class="btn btn-success" value="Update the Recipe" />
		</p>
	</form>

</body>
</html>