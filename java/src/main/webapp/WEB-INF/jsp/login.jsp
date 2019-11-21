<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<h2>Please Log in</h2>

<c:url var="loginURL" value="/login"/>
<form:form method="POST" action="${loginURL}" modelAttribute="Login">
	<div>
		<div>
			<label for="username">Name: </label>
			<form:input path="username"/>
			<form:errors path="username" cssClass="error"/>
		
		</div>
		<div>
			<label for="email">Email: </label>
			<form:input path="email" />
			<form:errors path="email" cssClass="error" />
		</div>
		<div>
			<label for="verifyEmail">Verify Email: </label>
			<form:input path="verifyEmail" />
			<form:errors path="verifyEmail" cssClass="error" />
		</div>
		<div>
			<label for="password">Password: </label>
			<form:input path="password" />
			<form:errors path="password" cssClass="error" />
		</div>
		<div>
			<label for="verifyPassword">Verify Password: </label>
			<form:input path="verifyPassword" />
			<form:errors path="verifyPassword" cssClass="error" />
		</div>
		<div>
			<input type="submit" name="SubmitForm" value="submit"/>
		</div>
	</div>
</form:form>