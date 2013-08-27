<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>CAP@HFR</title>
	<link rel="stylesheet" type="text/css" href="../css/style.css" />
</head>
	<body>
		<%@ include file="header.jsp"%>
		<div class="mainPage">
		<h3>Créer un nouveau challenge</h3>
		<form action="/createChallenge.do" method="post"> <!-- TODO: Checker javascript -->
			Nom: <input type="text" name="name"><br/>
			Date de début: <input type="date" name="startDate"/> <br/> 
			Date de fin: <input type="date" name="endDate"/> <br/> 
			Distance à parcourir: <input type="text" name="distance">Km<br/>
			Dénivelé minimum: <input type="text" name="elevation">m<br/>
			Temps minimum: <input type="text" name="time">sec.<br/>
			Type de comparaison: <select name="Comptype"><option>Moins que</option><option>Plus que</option></select><br/>
			<input type="submit" value="Save" />
		</form>
		</div>
	</body>
</html>