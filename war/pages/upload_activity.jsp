<%@ page contentType="text/html; charset=UTF-8" %>
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
<form id="file-upload" action="/upload_activity.do" enctype="multipart/form-data" method="post">
    <label for="file">GPX ou TCX exportés depuis Garmin Connect:</label></br>
    <input name="file" type="file" />
    <input type="submit" value="Save" />
</form>
</body>
</html>