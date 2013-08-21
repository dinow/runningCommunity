<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>

	<c:set var="tcd" value="${fileContent}" />
	<table border="1">
		<tr><th colspan="2">Informations sur le fichier</th></tr>
		<tr>
			<td>name</td>
			<td>${tcd.author.name }</td>
		</tr>
		<tr>
			<td>langID</td>
			<td>${tcd.author.langID }</td>
		</tr>
		<tr>
			<td>partNumber</td>
			<td>${tcd.author.partNumber }</td>
		</tr>
		<tr>
			<td>build</td>
			<td>${tcd.author.build }</td>
		</tr>
	</table>
	</br>
	<c:set var="activity" value="${tcd.activities.activity }" />
	<table border="1">
		<tr><th colspan="2">Informations sur l'activité et appareil</th></tr>
		<tr>
			<td>sport</td>
			<td>${activity.sport}</td>
		</tr>
		<tr>
			<td>id</td>
			<td>${activity.id}</td>
		</tr>
		<tr>
			<td>creator</td>
			<td>
				name: ${activity.creator.name}</br>
				unitId: ${activity.creator.unitId}</br>
				productID: ${activity.creator.productID}</br>
				${activity.creator.version}
			</td>
		</tr>
	</table>
	<br />
	<table border="1">
		<tr><th colspan="6">Informations calculées</th></tr>
		<tr>
			<td>totalTime</td><td>${tcd.totalTime}</td>
			<td>averageBpm</td><td>${tcd.averageBpm}</td>
			<td>totalDistance</td><td>${tcd.totalDistance}</td>
		</tr>
		<tr>
			<td>totalCalories</td><td>${tcd.totalCalories}</td>
			<td>maxBpm</td><td>${tcd.maxBpm}</td>
			<td>elevationPositive</td><td>${tcd.elevationPositive}</td>
		</tr>
	</table>
	<br />
	<h3>Laps identiques selon la distance, temps moyen : ${tcd.averageSecondForLapsBySameDistance } écart maximun : ${tcd.maxDeviationSecondForLapsBySameDistance }</h3>
	<table border="1">
		<tr>
			<th>startTime</th>
			<th>totalTimeSeconds</th>
			<th>distanceMeters</th>
			<th>maximumSpeed</th>
			<th>calories</th>
			<th>averageHeartRateBpm</th>
			<th>maximumHeartRateBpm</th>
			<th>intensity</th>
			<th>triggerMethod</th>
		</tr>
		<c:forEach var="lap" items="${tcd.lapsBySameDistance }">
			<tr>
				<td>${lap.startTime}</td>
				<td>${lap.totalTimeSeconds}</td>
				<td>${lap.distanceMeters}</td>
				<td>${lap.maximumSpeed}</td>
				<td>${lap.calories}</td>
				<td>${lap.averageHeartRateBpm}</td>
				<td>${lap.maximumHeartRateBpm}</td>
				<td>${lap.intensity}</td>
				<td>${lap.triggerMethod}</td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<h3>Laps identiques selon le temps, distance moyenne : ${tcd.averageDistanceForLapsBySameTime } écart maximun : ${tcd.maxDeviationDistanceForLapsBySameTime }</h3>
	<table border="1">
		<tr>
			<th>startTime</th>
			<th>totalTimeSeconds</th>
			<th>distanceMeters</th>
			<th>maximumSpeed</th>
			<th>calories</th>
			<th>averageHeartRateBpm</th>
			<th>maximumHeartRateBpm</th>
			<th>intensity</th>
			<th>triggerMethod</th>
		</tr>
		<c:forEach var="lap" items="${tcd.lapsBySameTime }">
			<tr>
				<td>${lap.startTime}</td>
				<td>${lap.totalTimeSeconds}</td>
				<td>${lap.distanceMeters}</td>
				<td>${lap.maximumSpeed}</td>
				<td>${lap.calories}</td>
				<td>${lap.averageHeartRateBpm}</td>
				<td>${lap.maximumHeartRateBpm}</td>
				<td>${lap.intensity}</td>
				<td>${lap.triggerMethod}</td>
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
			<th>maximumSpeed</th>
			<th>calories</th>
			<th>averageHeartRateBpm</th>
			<th>maximumHeartRateBpm</th>
			<th>intensity</th>
			<th>triggerMethod</th>
		</tr>
		<c:forEach var="lap" items="${activity.laps }">
			<tr>
				<td>${lap.startTime}</td>
				<td>${lap.totalTimeSeconds}</td>
				<td>${lap.distanceMeters}</td>
				<td>${lap.maximumSpeed}</td>
				<td>${lap.calories}</td>
				<td>${lap.averageHeartRateBpm}</td>
				<td>${lap.maximumHeartRateBpm}</td>
				<td>${lap.intensity}</td>
				<td>${lap.triggerMethod}</td>
			</tr>

		</c:forEach>

	</table>
	
</body>


</html>