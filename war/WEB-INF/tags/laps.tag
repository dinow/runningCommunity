<%@ tag language="java" body-content="scriptless" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="listOfLaps" required="true" type="java.util.List" %>

<table border="1">
	<tr>
		<th>startTime</th>
		<th>totalTimeSeconds</th>
		<th>distanceMeters</th>
		<th>maximumSpeed</th>
		<th>calories</th>
		<th>averageHeartRateBpm</th>
		<th>maximumHeartRateBpm</th>

	</tr>
	<c:forEach var="lap" items="${listOfLaps }">
		<tr>
			<td>${lap.startTime}</td>
			<td>${lap.totalTimeSeconds}</td>
			<td>${lap.distanceMeters}</td>
			<td>${lap.maximumSpeed}</td>
			<td>${lap.calories}</td>
			<td>${lap.averageHeartRateBpm}</td>
			<td>${lap.maximumHeartRateBpm}</td>

		</tr>

	</c:forEach>

</table>