<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="tags" tagdir="/WEB-INF/tags" %>
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
			<th>activityCategory</th>
			<td>${activity.activityCategory}</td>
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
	
	Ok...
	
</body>


</html>