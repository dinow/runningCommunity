<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.google.appengine.api.users.*" %>
<html>
<body>
<%UserService userService = UserServiceFactory.getUserService();
		String userName = "anonyme";
		if (userService.getCurrentUser() != null) {
			userName = userService.getCurrentUser().getNickname();
		}
	%>
	Bienvenue <%=userName %>,&nbsp;<a href="/show_activities.do">Show activities</a>&nbsp;<a href="/pages/upload_activity.jsp">Upload activities</a>&nbsp;
	<% if (userService.getCurrentUser() == null) { %>
            <a href="<%= userService.createLoginURL("/") %>">Se connecter</a>
        <% } else { %>
            <a href="<%= userService.createLogoutURL("/") %>">Se déconnecter</a>
        <% } %>
	<h1>Liste des activités</h1>
	<form:form method="post" action="save.html"
		modelAttribute="activityCategoryForm">
		<c:forEach items="${activityCategoryForm.activityCategories}"
			var="activityCategory">
			<div id="${activityCategory.id}">
				<span>${activityCategory.label}</span>
				<c:forEach items="${activityCategory.activities}" var="activity">
					<c:set var="activity" value="${activity}" />
					<table border="1">
						<tr>
							<th colspan="2">Informations sur l'activité</th>
						</tr>
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
					<h3>Laps identiques selon la distance, temps moyen :
						${activity.averageSecondForLapsBySameDistance } écart maximun :
						${activity.maxDeviationSecondForLapsBySameDistance }</h3>
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
						<c:forEach var="lap" items="${activity.lapsBySameDistance }">
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
					<br />
					<h3>Laps identiques selon le temps, distance moyenne :
						${activity.averageDistanceForLapsBySameTime } écart maximun :
						${activity.maxDeviationDistanceForLapsBySameTime }</h3>
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
						<c:forEach var="lap" items="${activity.lapsBySameTime }">
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

							</tr>

						</c:forEach>

					</table>
				<br/>
				<hr/>
				</c:forEach>

			</div>
		</c:forEach>

	</form:form>
</body>
</html>