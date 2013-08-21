<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
<form id="file-upload" action="/upload_activity.do" enctype="multipart/form-data" method="post">
    <label for="file">GPX ou TCX exportés depuis Garmin Connect:</label></br>
    <input name="file" type="file" />
    <input type="submit" value="Save" />
</form>
</body>
</html>