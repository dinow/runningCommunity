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
		Version: ${rh:getCleanVersion()}<br/>
		Contact: <a href="mailto:didiernowak@gmail.com?subject=Question sur cap@hfr">didiernowak@gmail.com</a><br/>
		GitHub: <a href="https://github.com/dinow/runningCommunity">https://github.com/dinow/runningCommunity</a><br/>
		Lien HFR: <a href="http://forum.hardware.fr/forum2.php?config=hfr.inc&cat=13&subcat=430&post=21633&page=1&p=1&sondage=0&owntopic=1&trash=0&trash_post=0&print=0&numreponse=0&quote_only=0&new=0&nojs=0">[Topikunik] Course à pieds, athlétisme, conseils</a></br/>
		<br />
		Remerciements à <b>Angelus</b> et <b>Cazeloof</b> pour leur participations au développment et à tous les autres participants pour leurs input...<br/>
		<br />
		Application en beta version, aucune garantie au sujet de la persistance des données uploadées, c'est juste pour le fun (pour l'instant :D).<br/>
	</div>
	
	
	
</body>
</html>