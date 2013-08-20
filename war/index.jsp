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
	Bienvenue <%=userName %></br>
	Voici la liste des actions possibles:</br>
	
	<ul>
	
	
	<% if (userService.getCurrentUser() == null) { %>
            <li><p><a href="<%= userService.createLoginURL("/") %>">Se connecter</a></p></li>
        <% } else { %>
            <li><a href="/show_activities.do">show_activities</a></li>
            <li><p><a href="<%= userService.createLogoutURL("/") %>">Se déconnecter</a></p></li>
        <% } %>
	
	</ul>
	
	
	
</body>
</html>