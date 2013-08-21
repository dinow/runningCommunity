<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>

	<c:set var="gpx" value="${fileContent}" />
	<table border="1">
		<tr><th colspan="2">Informations sur le fichier</th></tr>
		<tr>
			<td>metadata</td>
			<td>${gpx.metadata }</td>
		</tr>
	</table>
	</br>
	<h3>Informations sur le trk "${gpx.trk.name}"</h3>
	<table border="1">
		<tr><th>lon</th><th>lat</th><th>ele</th><th>time</th></tr>
		<c:forEach var="trkpt" items="${gpx.trk.trkseg.trkpts }">
			<tr>
				<td>${trkpt.lon }</td>
				<td>${trkpt.lat }</td>
				<td>${trkpt.ele }</td>
				<td>${trkpt.time }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>