<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://caphfr.appsport.com/taglib/functions" prefix="rh"%>
<%@taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<html>
<head>
	<title>CAP@HFR</title>
	<link rel="stylesheet" type="text/css" href="../css/style.css" />
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="mainPage">
	<h1>Liste des activités</h1>
	<c:if test="${activities == null} ">
		No activities
	</c:if>
	<c:if test="${activities != null}">
		<c:forEach items="${activities}" var="activity">
			<tags:activity activity="${activity}"  />

			<br />
			
		<c:if test="${! rh:isCollectionEmpty(activity.lapsBySameDistance) }">
				<h3>Laps identiques selon la distance, temps moyen :
					${activity.averageSecondForLapsBySameDistance } écart maximun :
					${activity.maxDeviationSecondForLapsBySameDistance }</h3>
				<tags:laps listOfLaps="${activity.lapsBySameDistance}" />
				<br />
			</c:if>
			<c:if test="${! rh:isCollectionEmpty(activity.lapsBySameTime) }">
				<h3>Laps identiques selon le temps, distance moyenne :
					${activity.averageDistanceForLapsBySameTime } écart maximun :
					${activity.maxDeviationDistanceForLapsBySameTime }</h3>
				<tags:laps listOfLaps="${activity.lapsBySameTime}" />
				<br />
			</c:if>
			<c:if test="${! rh:isCollectionEmpty(activity.laps) }">
				<h3>Laps bruts</h3>
				<tags:laps listOfLaps="${activity.laps}" />
				<br />
			</c:if>
			<hr />
			
			<br />
		</c:forEach>
	</c:if>
	</div>
</body>
</html>