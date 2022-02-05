<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Admin</title>
 
    <style>
        tr:first-child{
            font-weight: bold;
            background-color: #C6C9C4;
        }
    </style>
 
</head>
 
 
<body>
    <h2>List of Items</h2>  
    <table>
        <tr>
            <td>Name</td><td>Price</td><td>Unit</td><td>shopno</td><td></td><td></td>
        </tr>
        <c:forEach items="${items}" var="item">
            <tr>
            <td>${item.iname}</td>
            <td>${item.price}</td>
            <td>${item.unit}</td>
            <td>${item.shopno}</td>
            <td><a href="<c:url value='/edit-${item.iname}-item' />">edit</a></td>
            <td><a href="<c:url value='/delete-${item.iname}-item' />">delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <a href="<c:url value='/newitem' />">Add New Item</a>
    <br/>
    <a href="<c:url value='/fill' />">Add a predefined List of Items in database</a>
    <br/>
    <a href="<c:url value='/home' />">Go to Homepage</a>
</body>
</html>