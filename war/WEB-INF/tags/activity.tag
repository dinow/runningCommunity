<%@ tag language="java" body-content="scriptless"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ attribute name="activity" required="true" type="be.dno.running.entities.Activity"%>
<table border="1">
	<tr>
		<th colspan="2">Informations sur l'activité</th>
	</tr>
	<%--<tr>
		<th>id</th>
		<td>${activity.id}</td>
	</tr> --%>
	<tr>
		<th>Nom</th>
		<td>${activity.name }</td>
	</tr>
	<tr>
		<th>Description</th>
		<td>${activity.description }</td>
	</tr>
	<tr>
		<th>Date</th>
		<td>${activity.strDateDebut}</td>
	</tr>
	<tr>
		<th>Distance</th>
		<td>${activity.totalDistance }</td>
	</tr>
	<tr>
		<th>Allure moyenne</th>
		<td>${activity.pace }</td>
	</tr>
	<tr>
		<th>Vitesse moyenne</th>
		<td>${activity.speed }</td>
	</tr>
	<tr>
		<th>Temps total</th>
		<td>${activity.totalTimeStr }</td>
	</tr>
	<tr>
		<th>BPM Moyen</th>
		<td>${activity.averageBpm }</td>
	</tr>
	<tr>
		<th>BPM Max.</th>
		<td>${activity.maxBpm }</td>
	</tr>
	<tr>
		<th>Elevation</th>
		<td>${activity.elevationPositive }</td>
	</tr>
	<tr>
		<th>Calories</th>
		<td>${activity.totalCalories }</td>
	</tr>
	
	<tr>
		<th>Meilleurs temps</th>
		<td>
			<c:forEach items="${activity.bestTimes}" var="bestTime">
				${bestTime.distance }k : ${bestTime.display }<br/>
			</c:forEach>
		
		</td>
	</tr>

</table>