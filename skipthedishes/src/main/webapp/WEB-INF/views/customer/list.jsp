<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Vanhack - Skip The Dishes Challenge - Sylvio Antonio</title>
	<c:url value="/" var="contextPath" />
	<c:url value="/resources/css" var="cssPath" />
	
	<!-- Bootstrap -->
	<link rel="stylesheet" href="${cssPath}/bootstrap.min.css" />
	<link rel="stylesheet" href="${cssPath}/css/bootstrap-theme.min.css" />
	
	<style type="text/css">
	body {
		padding: 60px 0px;
	}
	</style>
</head>
<body>
	<div class="container">
		<h2>List of Customers</h2>
		<p>${success}</p>
		<p>${fail}</p>
		<table class="table table-bordered table-hover">
			<thead class="thead-dark">
				<tr>
					<th><fmt:message key="customer.name" /></th>
					<th><fmt:message key="customer.email" /></th>
					<th><fmt:message key="customer.phone" /></th>
					<th><fmt:message key="customer.zipcode" /></th>
					<th><fmt:message key="customer.geoposition" /></th>
					<th><fmt:message key="customer.birthday" /></th>
				</tr>
			</thead>
			<c:forEach items="${customers}" var="customer">
				<tr>
					<td>${customer.name}</td>
					<td>${customer.email}</td>
					<td>${customer.phone}</td>
					<td>${customer.zipCode}</td>
					<td>${customer.geoPosition}</td>
					<td>${customer.birthday}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>