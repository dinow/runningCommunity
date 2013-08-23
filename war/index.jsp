<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.google.appengine.api.users.*" %>
<html>
<body>
	
	<%@ include file="header.jsp"%>
	
	<div style="width: 100%">
		Bienvenue dans la version <%= com.google.appengine.api.utils.SystemProperty.applicationVersion.get() %> de l'application<br/>
		<p>
			Nouveautées:<br/>
			Import des fichiers GPX/TCX provenant de:<br/>
			<ul>
				<li>Strava</li>
				<li>Garmin Connect</li>
				<li>IsmoothrunPro</li>
				<li>Polar</li>
				<li>Endomodo</li>
			</ul>
		
		</p>
	
	</div>
	
	
	
</body>
</html>