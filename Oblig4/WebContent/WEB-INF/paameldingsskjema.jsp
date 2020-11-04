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
	<form id="rootform" method="post" class="pure-form pure-form-aligned" action="PaameldingPost">
		<fieldset>
			<div class="pure-control-group">
				<label for="fornavn">Fornavn:</label> <input type="text"
					name="fornavn" value="${fornavn}" placeholder="Fornavn" pattern=".{2,}" required/> 
					<font color="red">${fornavnFeilmelding}</font>
			</div>
			<div class="pure-control-group">
				<label for="etternavn">Etternavn:</label> <input type="text"
					name="etternavn" value="${etternavn}" placeholder="Etternavn" pattern=".{2,}" required /> 
					<font color="red">${etternavnFeilmelding}</font>
			</div>
			<div class="pure-control-group">
				<label for="mobil">Mobil (8 siffer):</label> <input type="text"
					name="mobil" value="${mobil}" placeholder="Mobilnummer" pattern="[0-9]{8}" required/> 
					<font color="red">${mobilFeilmelding}</font>
			</div>
			<div class="pure-control-group" id="passorddiv">
				<label for="password">Passord:</label> <input type="password"
					name="passord" placeholder="Passord" id="passord" pattern=".{8,64}" required 
					onmouseover="this.parentElement.querySelector('#passordinfo').textContent = 'Passordstyrke regnes ut ifra lengde. 1-7 er ugyldig. 8-15 er svakt. 16-64 er sterkt.'"
					onmouseout="this.parentElement.querySelector('#passordinfo').textContent = '${passordFeilmelding}'"
					oninput="
						if(this.value.length < 8) {
							this.style.border = 'solid blue';
							this.parentElement.querySelector('#passordinfo').textContent = this.value;
						} else if(this.textContent.length < 16) {
							this.style.border = 'solid yellow'
						} else {
							this.style.border = 'solid green'
						}
					"/> 
					<font id="passordinfo" color="red">${passordFeilmelding}</font>
			</div>
			<div class="pure-control-group">
				<label for="passordRepetert">Passord repetert:</label> <input
					type="password" name="passordRepetert"
					placeholder="Repeter passord" required/> 
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
					meg på</button>&ensp;
				<button type="submit" form="logginn" class="pure-button pure-button-primary">Logg inn</button>
			</div>
		</fieldset>
	</form>
	<form action="Logginn" method="get" id="logginn"></form>
</body>
</html>