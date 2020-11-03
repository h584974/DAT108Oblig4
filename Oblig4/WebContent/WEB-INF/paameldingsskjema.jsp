<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="js/PaameldingsskjemaController.js" defer></script>
<meta charset="UTF-8">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<link rel="stylesheet"
	href="CSS/PaameldingsskjemaStyle.css">
<title>Påmelding</title>
</head>
<body>
	<h2>Påmelding</h2>
	<form method="post" class="pure-form pure-form-aligned" action="PaameldingPost">
		<fieldset>
			<div class="pure-control-group">
				<label for="fornavn">Fornavn:</label> <input type="text"
					name="fornavn" value="${fornavn}" placeholder="Skriv ditt fornavn" required/> 
					<font color="red">${fornavnFeilmelding}</font>
			</div>
			<div class="pure-control-group">
				<label for="etternavn">Etternavn:</label> <input type="text"
					name="etternavn" value="${etternavn}" placeholder="Skriv ditt etternavn" required /> 
					<font color="red">${etternavnFeilmelding}</font>
			</div>
			<div class="pure-control-group">
				<label for="mobil">Mobil (8 siffer):</label> <input type="number"
					name="mobil" value="${mobil}" placeholder="Skriv ditt mobilnummer" minlength="8" maxlength="8" required/> 
					<font color="red">${mobilFeilmelding}</font>
			</div>
			<div class="pure-control-group" id="passord">
				<label for="password">Passord:</label> <input type="password"
					name="passord" value="" placeholder="Skriv passord" required/> 
					<font color="red">${passordFeilmelding}</font>
			</div>
			<div class="pure-control-group">
				<label for="passordRepetert">Passord repetert:</label> <input
					type="password" name="passordRepetert"
					value="" placeholder="Repeter passord" required/> 
					<font color="red">${passordrepetertFeilmelding}</font>
			</div>
			<div class="pure-control-group">
				<label for="kjonn">Kjønn:</label> <input type="radio" name="kjonn"
					value="mann"
					 />&ensp;mann&ensp;&ensp;
				<input type="radio" name="kjonn" value="kvinne"
					 />&ensp;kvinne
				<font color="red">${kjonnFeilmelding}</font>
			</div>
			<div class="pure-controls">
				<button type="submit" class="pure-button pure-button-primary">Meld
					meg på</button>
			</div>
		</fieldset>
	</form>
</body>
</html>