<%@ tag language="java" body-content="scriptless"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ attribute name="challenge" required="true" type="be.dno.running.entities.Challenge"%>
<table border="1">
	<tr>
		<th colspan="2">Informations sur le challenge</th>
	</tr>
	
	<tr>
		<th>Nom</th>
		<td>${challenge.name }</td>
	</tr>
	<tr>
		<th>Début</th>
		<td>${challenge.startDate }</td>
	</tr>
	<tr>
		<th>Fin</th>
		<td>${challenge.endDate }</td>
	</tr>
	<tr>
		<th>Distance</th>
		<td>${challenge.distance }</td>
	</tr>
	<tr>
		<th>Dénivellé</th>
		<td>${challenge.elevation }</td>
	</tr>

</table>