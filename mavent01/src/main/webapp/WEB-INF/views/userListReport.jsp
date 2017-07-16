
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>userListReport</title>
</head>
<body>

	<table border="1">
		<thead>

			<tr>
				<td>ID</td>
				<td>UserName</td>
				<td>First Name</td>
				<td>Last Name</td>
			</tr>

		</thead>
		<tbody>
			<c:forEach items="${userList}" var="user">
				<tr>
					<td>${user.id}</td>
					<td>${user.username}</td>
					<td>${user.firstname}</td>
					<td>${user.lastname}</td>
				</tr>



			</c:forEach>

		</tbody>

	</table>
	<spring:url value="/report/?type=xls" var="xlsURL"    />
	<spring:url value="/report/?type=pdf" var="pdfURL"    />
<a href="${xlsURL}">EXcel</a>
<a href="${pdfURL}">PDF</a>
</body>
</html>