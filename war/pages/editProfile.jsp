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
		<h3>Edition utilisateur</h3>
		<form action="/save_profile.do" method="post"> <!-- TODO: Checker javascript -->
			Id Google : ${user.googleUserName }<br/>
			Pseudo HFR: <input type="text" name="hfrUserName" value="${user.hfrUserName }"><br/>
			Taille: <input type="text" name="taille" value="${user.taille }">cm<br/>
			Poids: <input type="text" name="poids" value="${user.poids }">kg<br/>
			IMC: ${user.IMC }<br/>
			<input type="submit" value="Save" />
		</form>
		</div>
	</body>
</html>