<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/bootstrap.min.css"/>">
</head>
<body>
<div class="container">
    <sec:authorize access="isAuthenticated()">
        <p>Welcome Back, <sec:authentication property="name"/></p>
        <p><a href="logout">Logout</a></p>
    </sec:authorize>
    
    <sec:authorize access="isAuthenticated()">
        <p><a href="addCar">Add a new Car</a></p>
    </sec:authorize>

</div>
</body>
</html>
