<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Deltagerliste</title>
</head>
<body>
	<h2>Deltagerliste</h2>
	
	<table class="pure-table">
		<tr bgcolor="#cccccc">
			<th>Kjønn</th>
			<th align="left">Navn</th>
			<th align="left">Mobil</th>
		</tr>
		<c:forEach items="${festdeltagere}" var="fd">
			<c:choose>
				<c:when test="${fd.mobil == brukernavn}">
					<tr bgcolor="#aaffaa">
						<td align="center">${fd.kjonn == "mann" ? "&#9794;" : "&#9792;"}</td>
						<td>${fd.fornavn} ${fd.etternavn}</td>
						<td>${fd.mobil}</td>
					</tr>
				</c:when>
				<c:otherwise>
					<tr bgcolor="#ffffff">
						<td align="center">${fd.kjonn == "mann" ? "&#9794;" : "&#9792;"}</td>
						<td>${fd.fornavn} ${fd.etternavn}</td>
						<td>${fd.mobil}</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</table>
	<p>
		<a href="Loggut">Ferdig</a>
	</p>
</body>
</html>