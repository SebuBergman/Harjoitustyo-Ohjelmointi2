<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link href="styles/demo.css" rel="stylesheet" type="text/css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css">
<title>Lis‰‰ Resepti</title>
<style type="text/css">
label {
	display: block;
	width: 8em;
	float: left;
}
</style>
</head>
<body>
<h1>Lis‰‰ Resepti</h1>
	<form action="/lisaa-resepti" method="post">
		<p>
			<label>Annoksia:</label> <input type="text" value="" name="annoksia"
				size="50" />
		</p>
		<p>
			<label>Reseptinimi:</label> <input type="text" value="" name="reseptiNimi"
				size="50" />
		</p>
		<p>
			<label>ValmistusAika:</label> <input type="text" value="" name="valmistusAika"
				size="50" />
		</p>
		<p>
			<label>Ainesosat:</label> <input type="text" value="" name="ainesosat"
				size="50" />
		</p>
		<p>
			<label>Ohje:</label> <input type="text" value="" name="ohje"
				size="50" />
		</p>

		<p>
		<a class="btn btn-primary" href="/listaa-reseptit" role="button">Peruuta</a>
		<input type="submit" name="submit-button" class="btn btn-success" value="Tallenna" />
		</p>
	</form>

</body>
</html>