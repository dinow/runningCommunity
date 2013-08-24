<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.google.appengine.api.users.*" %>
<div style="with:100%; background-color: #cdcdcd; height: 50px;">
	<%UserService userService = UserServiceFactory.getUserService();
		if (userService.getCurrentUser() != null) {
			String userName = userService.getCurrentUser().getNickname();
		%>
			Welcome <%=userName %>,
			&nbsp;<a href="/show_my_activities.do">My activities</a>
			&nbsp;<a href="/pages/upload_activity.jsp">Upload new activity</a>
			&nbsp;<a href="/show_others_activities.do">Other activities</a>
			&nbsp;<a href="/show_users.do">Show all users</a>
            &nbsp;<a href="<%= userService.createLogoutURL("/") %>">Logout</a>
		<%}else{%>
			&nbsp;<a href="/show_others_activities.do">Other activities</a>
            &nbsp;<a href="<%= userService.createLoginURL("/") %>">Login</a>
			<%
		}
	%>
</div>