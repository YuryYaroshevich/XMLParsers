<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/tableborder.css" type="text/css" media="screen" />
<title>Products</title>
</head>
<body>
	<h2>Products</h2>
	<table>
		<c:forEach var="category" items="${categories}">
			<tr>
				<td>${category.name}</td>
				<td></td>
			</tr>
			<%@ include file="subcategory.jsp" %>
		</c:forEach>
	</table>

	<form action="controller" method="get">
		<input type="hidden" name="command" value="NO_COMMAND" /> <input
			type="submit" value="BACK" />
	</form>
</body>
</html>