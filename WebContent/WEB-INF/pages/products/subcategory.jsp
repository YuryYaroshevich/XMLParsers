<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:forEach var="subcategory" items="${category.subcategories}">
	<tr>
		<td></td>
		<td>${subcategory.name}</td>
	</tr>
	<%@ include file="good.jsp"%>
</c:forEach>