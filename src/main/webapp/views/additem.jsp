<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>New Item</title>
 
<style>
 
    .error {
        color: #ff0000;
    }
</style>
 
</head>
 
<body>
 
    <h2>New Item</h2>
  
    <form:form method="POST" modelAttribute="item">
        <form:input type="hidden" path="id" id="id"/>
        <table>
            <tr>
                <td><label for="iname">Name: </label> </td>
                <td><form:input path="iname" id="iname"/></td>
                <td><form:errors path="iname" cssClass="error"/></td>
            </tr>
            
            <tr>
                <td><label for="price">Price: </label> </td>
                <td><form:input path="price" id="price"/></td>
                <td><form:errors path="price" cssClass="error"/></td>
            </tr>
     		
     		<tr>
                <td><label for="unit">Unit: </label> </td>
                <td><form:input path="unit" id="unit"/></td>
                <td><form:errors path="unit" cssClass="error"/></td>
            </tr>
     		
     		<tr>
                <td><label for="shopno">Shop No: </label> </td>
                <td><form:input path="shopno" id="shopno"/></td>
                <td><form:errors path="shopno" cssClass="error"/></td>
            </tr>
     		
            <tr>
                <td colspan="3">
                    <c:choose>
                        <c:when test="${edit}">
                            <input type="submit" value="Update"/>
                        </c:when>
                        <c:otherwise>
                            <input type="submit" value="Add Item"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </table>
    </form:form>
</body>
</html>