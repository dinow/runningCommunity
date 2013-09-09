<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://caphfr.appsport.com/taglib/functions" prefix="rh"%>
<%@taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<html>
<head>
	<title>CAP@HFR</title>
	<link rel="stylesheet" type="text/css" href="../css/style.css" />
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="mainPage">
	<c:set var="activity" value="${fileContent}" />
	<tags:activity activity="${activity}"  />

	<h3>Résumé</h3>

	<form action="/saveAction.do" method="post">
		Activité privée: <input type="checkbox" value="private" name="private" /> <br/> 
		Type d'activité: 
		<select name="type">
			<option value="run" selected="selected">Run</option>
			<option value="race">Race</option>
			<option value="SL">SL</option>
			<option value="Workout">Workout</option>
			<option value="Other">Other</option>
		</select><br/>
		Nom de l'activité: <input type="text" name="name"><br/>
		<input type="submit" value="Update" />
		<input type="hidden" name="activityId" value="${activity.id}"/>
	</form>
	</div>

</body>


</html>