<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
	<h1>Liste des activités</h1>
	<form:form method="post" action="save.html" modelAttribute="activityCategoryForm">
			<c:forEach items="${activityCategoryForm.activityCategories}" var="activityCategory">
				<div id="${activityCategory.id}">
					<span>${activityCategory.label}</span>
					<table border="1px">
						<tr>
							<th>ID</th>
							<th>Date</th>
							<th>Distance</th>
							<th>Temps</th>
							<th>Allure</th>
							<th>D+</th>
						</tr>
						<c:forEach items="${activityCategory.activities}" var="activity">
							<tr>
								<td>${activity.id}</td>
								<td>${activity.dateDebut }</td>
								<td>${activity.distance }</td>
								<td>${activity.time }</td>
								<td>${activity.pace }</td>
								<td>${activity.denivele }</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</c:forEach>
	
	</form:form>
</body>
</html>