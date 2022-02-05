<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>ItemList</title>
 
    <style>
        tr:first-child{
            font-weight: bold;
            background-color: #C6C9C4;
        }
    </style>
 
</head>
 
 
<body>
    <h2>${shopname}</h2>
    
     <table>
        <tr>
            <td>Name</td><td>Price</td><td>Unit</td><td>Quantity</td><td></td>
        </tr>
        <c:forEach items="${items}" var="item">
            <tr>
            <td>${item.iname}</td>
            <td>${item.price}</td>
            <td>${item.unit}</td>
            <td>${item.qty}</td>
            <td><a href="<c:url value='/add-${item.iname}-item' />">Add to Cart</a></td>
            </tr>
        </c:forEach>
         
     </table>
    
    <br/>
    <a href="<c:url value='/next-${nextshop}-shop' />">Next Shop</a>
</body>
</html>