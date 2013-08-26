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
	<h1>Liste des challenges</h1>
	<c:if test="${empty challenges}">
		Il n'y a pas encore de challenges!
	</c:if>
	<c:if test="${challenges != null}">
		<c:forEach items="${challenges}" var="challenge">
			<tags:challenge challenge="${challenge}"  />
		</c:forEach>
	</c:if>
	</div>
</body>
</html>