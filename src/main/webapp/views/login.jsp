<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
<style>
    .error {
        color: #ff0000;
    }
</style>
</head>
<body>
	<h3>Enter Login details :</h3>
	<form:form method="POST" modelAttribute="user">
        <form:input type="hidden" path="id" id="id"/>
        <table>
            <tr>
                <td><label for="uname">Username: </label> </td>
                <td><form:input path="uname" id="uname"/></td>
                <td><form:errors path="uname" cssClass="error"/></td>
            </tr>
            <tr>
                <td><label for="upass">Password: </label> </td>
                <td><form:input path="upass" id="upass"/></td>
                <td><form:errors path="upass" cssClass="error"/></td>
            </tr>
     		<tr>
                <td colspan="3">
                            <input type="submit" value="Login"/>
               	</td>
            </tr>
        </table>
    </form:form>
</body>
</html>