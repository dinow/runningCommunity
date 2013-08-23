<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.google.appengine.api.users.*" %>
<html>
<body>
	<%@ include file="header.jsp"%>
	<c:set var="activity" value="${fileContent}" />
	<table border="1">
		<tr><th colspan="2">Informations sur l'activité</th></tr>
		<tr>
			<th>id</th>
			<td>${activity.id}</td>
		</tr>
		<tr>
			<th>name</th>
			<td>${activity.name }</td>
		</tr>
		<tr>
			<th>description</th>
			<td>${activity.description }</td>
		</tr>
		<tr>
			<th>dateDebut</th>
			<td>${activity.dateDebut }</td>
		</tr>
		<tr>
			<th>totalDistance</th>
			<td>${activity.totalDistance }</td>
		</tr>
		<tr>
			<th>pace</th>
			<td>${activity.pace }</td>
		</tr>
		<tr>
			<th>speed</th>
			<td>${activity.speed }</td>
		</tr>
		<tr>
			<th>totalTime</th>
			<td>${activity.totalTimeStr }</td>
		</tr>
		<tr>
			<th>totalTime (seconds)</th>
			<td>${activity.totalTime }</td>
		</tr>
		<tr>
			<th>averageBpm</th>
			<td>${activity.averageBpm }</td>
		</tr>
		<tr>
			<th>maxBpm</th>
			<td>${activity.maxBpm }</td>
		</tr>
		<tr>
			<th>elevationPositive</th>
			<td>${activity.elevationPositive }</td>
		</tr>
		<tr>
			<th>totalCalories</th>
			<td>${activity.totalCalories }</td>
		</tr>
		
	</table>
	
	<br />
	<h3>Laps identiques selon la distance, temps moyen : ${activity.averageSecondForLapsBySameDistance } (${activity.averageTimeForLapsBySameDistance }) écart maximun : ${activity.maxDeviationSecondForLapsBySameDistance }</h3>
	<table border="1">
		<tr>
			<th>startTime</th>
			<th>totalTimeSeconds</th>
			<th>deviationSeconds</th>
			<th>totalTime</th>
			<th>deviationTime</th>
			<th>distanceMeters</th>
			<th>pace</th>
			<th>speed</th>
			<th>calories</th>
			<th>averageHeartRateBpm</th>
			<th>maximumHeartRateBpm</th>
		</tr>
		<c:forEach var="lap" items="${activity.lapsBySameDistance }">
			<tr>
				<td>${lap.startTime}</td>
				<td>${lap.totalTimeSeconds}</td>
				<td>${lap.deviationTimeSeconds}</td>
				<td>${lap.totalTime}</td>
				<td>${lap.deviationTime}</td>
				<td>${lap.distanceMeters}</td>
				<td>${lap.pace}</td>
				<td>${lap.speed}</td>
				<td>${lap.calories}</td>
				<td>${lap.averageHeartRateBpm}</td>
				<td>${lap.maximumHeartRateBpm}</td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<h3>Laps identiques selon le temps, distance moyenne : ${activity.averageDistanceForLapsBySameTime } écart maximun : ${activity.maxDeviationDistanceForLapsBySameTime }</h3>
	<table border="1">
		<tr>
			<th>startTime</th>
			<th>totalTimeSeconds</th>
			<th>deviationMeters</th>
			<th>totalTime</th>
			<th>distanceMeters</th>
			<th>pace</th>
			<th>speed</th>
			<th>calories</th>
			<th>averageHeartRateBpm</th>
			<th>maximumHeartRateBpm</th>
		</tr>
		<c:forEach var="lap" items="${activity.lapsBySameTime }">
			<tr>
				<td>${lap.startTime}</td>
				<td>${lap.totalTimeSeconds}</td>
				<td>${lap.deviationMeters}</td>
				<td>${lap.totalTime}</td>
				<td>${lap.distanceMeters}</td>
				<td>${lap.pace}</td>
				<td>${lap.speed}</td>
				<td>${lap.calories}</td>
				<td>${lap.averageHeartRateBpm}</td>
				<td>${lap.maximumHeartRateBpm}</td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<h3>Laps bruts</h3>
	<table border="1">
		<tr>
			<th>startTime</th>
			<th>totalTimeSeconds</th>
			<th>distanceMeters</th>
			<th>calories</th>
			<th>averageHeartRateBpm</th>
			<th>maximumHeartRateBpm</th>
			
		</tr>
		<c:forEach var="lap" items="${activity.laps }">
			<tr>
				<td>${lap.startTime}</td>
				<td>${lap.totalTimeSeconds}</td>
				<td>${lap.distanceMeters}</td>
				<td>${lap.calories}</td>
				<td>${lap.averageHeartRateBpm}</td>
				<td>${lap.maximumHeartRateBpm}</td>	
			</tr>

		</c:forEach>

	</table>
	
</body>


</html>