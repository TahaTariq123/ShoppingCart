<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Item Confirmed</title>
</head>
<body>
    <h3>${success}</h3>
    <br/>
    <br/>
    Go To <a href="<c:url value='/admin' />">List of items</a>
    <br/>
    Go to<a href="<c:url value='/home' />">homepage</a> 
</body>
 
</html>