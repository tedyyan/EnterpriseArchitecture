<%--
  Created by IntelliJ IDEA.
  User: rXing
  Date: 7/7/2019
  Time: 5:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/bootstrap.min.css"/>">
</head>
<body>
<div class="container">
    <h1>Spring Security 5 - Login Form</h1>

    <c:if test="${not empty errorMessge}">
        <div style="color:red; font-weight: bold; margin: 30px 0px;">${errorMessge}</div>
    </c:if>

    <form name='login' action="login" method='POST'>
        <table>
            <tr>
                <td>UserName:</td>
                <td><input type='text' name='username' value=''></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type='password' name='password'/></td>
            </tr>
            <tr>
                <td colspan='2'><input name="submit" type="submit" value="submit"/></td>
            </tr>
        </table>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>

    <p><a class="btn btn-primary" href="register" role="button">Register a new User</a></p>
</div>
</body>
</html>
