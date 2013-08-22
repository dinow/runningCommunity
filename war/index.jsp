<%@ page contentType="text/html; charset=UTF-8" %>
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
</body>
</html>