<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.google.appengine.api.users.*" %>
<div class="headerDiv">
	<%UserService userService = UserServiceFactory.getUserService();
		if (userService.getCurrentUser() != null) {
			String userName = userService.getCurrentUser().getNickname();
		%>
			<span class="loggedUser">Connecté en tant que <%=userName %></span>
			&nbsp;|&nbsp;<a href="./home.jsp" title="Retour à la page d'accueil">Accueil</a>
			&nbsp;|&nbsp;<a href="/show_my_activities.do" title="Voir mes activités">Mes activités</a>
			&nbsp;|&nbsp;<a href="/pages/upload_activity.jsp" title="Uploader une activité">Uploader activité</a>
			&nbsp;|&nbsp;<a href="/show_others_activities.do" title="Voir les activités publiques">Activités Publiques</a>
            &nbsp;|&nbsp;<a href="<%= userService.createLogoutURL("/") %>" title="Se déconnecter">Déconnection</a>
		<%}else{%>
			&nbsp;|&nbsp;<a href="/show_others_activities.do" title="Voir les activités publiques">Activités Publiques</a>
            &nbsp;|&nbsp;<a href="<%= userService.createLoginURL("/") %>" title="Se connecter">Connection</a>
			<%
		}%>
		&nbsp;|&nbsp;<a href="./about.jsp" title="A propos du site">A propos</a>
</div>