<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.google.appengine.api.users.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://caphfr.appsport.com/taglib/functions" prefix="rh"%>
<html>
<head>
	<title>CAP@HFR</title>
	<link rel="stylesheet" type="text/css" href="../css/style.css" />
</head>
<body>
	
	<%@ include file="header.jsp"%>
	<div class="mainPage">
		Bienvenue dans l'application de gestion des activités du team CAP@HFR (et invités :o)<br/>
			Nouveautées:<br/>
			Import des fichiers GPX/TCX provenant de:<br/>
			<ul>
				<li>Strava</li>
				<li>Garmin Connect</li>
				<li>IsmoothrunPro</li>
				<li>Polar</li>
				<li>Endomodo</li>
			</ul>
			<br/>
			Edition utilisateurs, création de challenges (mais non actifs), regroupement des laps par distance / temps
	</div>
</body>
</html>