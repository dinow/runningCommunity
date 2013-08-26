<%@ tag language="java" body-content="scriptless" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="listOfLaps" required="true" type="java.util.List" %>
<%@ attribute name="detailedView" required="true" type="java.lang.Boolean" %>

<c:if test="${detailedView == false}">
	<table border="1">
		<tr>
			<th>Lap</th>
			<th>Temps</th>
			<th>Distance</th>
			<th>Allure</th>
			<th>Vitesse</th>
			<th>Calories</th>
			<th>BPM Moyen</th>
			<th>BPM Max.</th>
			<th>Diff. Km/h</th>
			<th>Diff. Min/Km</th>
		</tr>
		<c:forEach var="lap" items="${listOfLaps }">
			<tr class="${lap.css }">
				<td>${lap.number }</td>
				<td>${lap.totalTime}</td>
				<td>${lap.distanceMeters}</td>
				<td>${lap.pace}</td>
				<td>${lap.speed}</td>
				<td>${lap.calories}</td>
				<td>${lap.averageHeartRateBpm}</td>
				<td>${lap.maximumHeartRateBpm}</td>
				<td>${lap.kmHeureDiffAverageActivity}</td>
				<td>${lap.timeDiffAverageActivity}</td>
			</tr>
		</c:forEach>
	</table>
</c:if>

<c:if test="${detailedView == true}">
	<table border="1">
		<tr>
			<th>startTime</th>
			<th>totalTimeSeconds</th>
			<th>totalTime</th>
			<th>distanceMeters</th>
			<th>maximumSpeed</th>
			<th>calories</th>
			<th>averageHeartRateBpm</th>
			<th>maximumHeartRateBpm</th>
			<th>speed</th>
			<th>pace</th>
			<th>kmHeureDiffAverageActivity</th>
			<th>timeDiffAverageActivity</th>
		</tr>
		<c:forEach var="lap" items="${listOfLaps }">
			<tr class="${lap.css }">
				<td><nobr>${lap.strStartTime}</nobr></td>
				<td>${lap.totalTimeSeconds}</td>
				<td>${lap.totalTime}</td>
				<td>${lap.distanceMeters}</td>
				<td>${lap.maximumSpeed}</td>
				<td>${lap.calories}</td>
				<td>${lap.averageHeartRateBpm}</td>
				<td>${lap.maximumHeartRateBpm}</td>
				<td>${lap.speed}</td>
				<td>${lap.pace}</td>
				<td>${lap.kmHeureDiffAverageActivity}</td>
				<td>${lap.timeDiffAverageActivity}</td>
			</tr>
		</c:forEach>
	</table>
</c:if>