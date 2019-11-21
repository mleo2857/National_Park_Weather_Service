<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<c:url value="/CSS/nationalPark.css" var="cssHref" />
<link rel="stylesheet" href="${cssHref}" />
	<title>
		National Park Geek 
	</title>
</head>
<body>
	<header>
			<c:url  var="logoImgSrc" value="/img/logo.png" />
			<img   id="logo" src="${logoImgSrc}" alt="National Parks Geek">
		</header>
		<nav>
			<ul>
				<c:url var="homePageHref" value="/" />
				<li><a href="${homePageHref}">Home</a></li>
				<c:url var="loginPageHref" value="/login"/>
				<li><a href="${loginPageHref}">Login</a></li>
				<c:url var="surveyInputHref" value="/survey" />
				<li><a href="${surveyInputHref}">Survey</a></li>
				<c:url var="surveyPageHref" value="/surveyResults"/>
				<li><a href="${surveyPageHref}">Survey Page</a></li>
			</ul>
		</nav>
		<div id="container" class="wrapper">