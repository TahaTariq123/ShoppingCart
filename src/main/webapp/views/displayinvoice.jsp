<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Invoice</title>
 
    <style>
        tr:first-child{
            font-weight: bold;
            background-color: #C6C9C4;
        }
    </style>
 
</head>
 
 
<body>
    <h2>Invoice</h2>
     <h3>${username}</h3>	
     <table>
        <tr>
            <td>Name</td><td>Price</td><td>Unit</td><td>Quantity</td>
        </tr>
        <c:forEach items="${items}" var="item">
            <tr>
            <td>${item.iname}</td>
            <td>${item.price}</td>
            <td>${item.unit}</td>
            <td>${item.qty}</td>
            </tr>
        </c:forEach>
     </table>
     
     <h3>total amount to pay :</h3><h3>${total}</h3>
      
    <br/>
    <a href="<c:url value='/home' />">Go to homepage</a>
</body>
</html>