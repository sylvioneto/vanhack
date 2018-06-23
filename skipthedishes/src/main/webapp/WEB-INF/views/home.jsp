<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
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
	<div id="introduction" class="container">
		<h3>Vanhack - Skip the Dishes challenge</h3>
		<p>
			Description: In this project, I created a java application to help
			restaurants to find customers based on their location. <br> The
			same URL return the results in HTML and JSON, it is up to requester
			decides what he wants. <br> Project built in Java, Spring MVC,
			Hibernate. <br> Contact: sylvio.pedroza@gmail.com <br>
			Github: https://github.com/sylvioneto <br>
		</p>
	</div>
	<div id="pageLinks" class="container">
		<div>
			<label>Customer list in HTML</label> <a href="/skipthedishes/customers">click here</a>
		</div>
		<div>
			<label>Customer list in JSON</label> <a href="/skipthedishes/customers.json">click here</a>
		</div>
		<div>
			<form action="/skipthedishes/customers.json" method="GET">
				<label>Zip Code</label> 
				<input name="zipCode" type="text"/> Ex: B3W 0K1
				<br>
				<label>Geo Position</label> 
				<input name="geoPosition" type="text"/> Ex: 54.36426, -120.06526
				<br>
				<button type="submit" class="btn btn-primary">Get JSON</button>
			</form>
		</div>
	</div>
</body>
</html>