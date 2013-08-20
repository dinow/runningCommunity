<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>

	<c:set var="tcd" value="${fileContent}"/>
	
	<table border="1">
		<tr>
			<td>name</td><td>${tcd.author.name }</td>
		</tr>
		<tr>
			<td>langID</td><td>${tcd.author.langID }</td>
		</tr>
		<tr>
			<td>partNumber</td><td>${tcd.author.partNumber }</td>
		</tr>
		<tr>
			<td>build</td><td>${tcd.author.build }</td>
		</tr>
	</table>
	
	</br>
	
	<c:set var="activity" value="${tcd.activities.activity }"/>

	<table border="1">
		<tr><td>sport</td><td>${activity.sport}</td></tr>
		<tr><td>id</td><td>${activity.id}</td></tr>
		<tr><td>creator</td><td>${activity.creator.name}</br>${activity.creator.unitId}</br>${activity.creator.productID}</br>${activity.creator.version}</td></tr>
	</table>
	<br/>
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