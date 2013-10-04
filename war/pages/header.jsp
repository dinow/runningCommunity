<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.google.appengine.api.users.*" %>
<%@ page import="be.dno.running.persistence.GenericDao" %>
<%@ page import="be.dno.running.entities.User" %>
<div class="headerDiv">
	<%UserService userService = UserServiceFactory.getUserService();
		if (userService.getCurrentUser() != null) {
			GenericDao<User> userDao = new GenericDao<User>(User.class);
			User user = userDao.getById(userService.getCurrentUser().getUserId());
			if (user == null){
				user = new User();
				user.setGoogleUserName(userService.getCurrentUser().getNickname());
				user.setUserID(userService.getCurrentUser().getUserId());
				user = userDao.create(user);
			}	
		%>
			<a href="/pages/home.jsp" title="Retour à la page d'accueil">Accueil</a>
			&nbsp;|&nbsp;<a href="/show_my_activities.do" title="Voir mes activités">Mes activités</a>
			&nbsp;|&nbsp;<a href="/pages/upload_activity.jsp" title="Uploader une activité">Uploader activité</a>
			&nbsp;|&nbsp;<a href="/show_others_activities.do" title="Voir les activités publiques">Activités publiques</a>
			&nbsp;|&nbsp;<a href="/show_all_challenges.do" title="Voir les challenges">Challenges</a>
			&nbsp;|&nbsp;<a href="/edit_profile.do" title="Profil">Profil</a>
            &nbsp;|&nbsp;<a href="<%= userService.createLogoutURL("/") %>" title="Se déconnecter">Déconnection</a>
		<%}else{%>
			<a href="/show_others_activities.do" title="Voir les activités publiques">Activités publiques</a>
            &nbsp;|&nbsp;<a href="<%= userService.createLoginURL("/login.do") %>" title="Se connecter">Connection</a>
			<%
		}%>
		&nbsp;|&nbsp;<a href="/pages/about.jsp" title="A propos du site">A propos</a>
		
		<%
		if (userService.getCurrentUser() != null) {
			String userName = userService.getCurrentUser().getNickname();
		%>
		&nbsp;|&nbsp;<span class="loggedUser">Connecté en tant que <%=userName %></span>
		<%
		}
		%>
</div>