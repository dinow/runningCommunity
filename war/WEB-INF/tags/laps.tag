<%@ tag language="java" body-content="scriptless" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="listOfLaps" required="true" type="java.util.List" %>

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