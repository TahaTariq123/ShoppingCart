<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
	<h1>Welcome to shopping cart</h1>
	<a href="<c:url value='/log' />">Customer Login</a>
	</br>
	<a href="<c:url value='/reg' />">Customer Registration</a>
	</br>
	<a href="<c:url value='/admin' />">Admin</a>
</body>
</html>