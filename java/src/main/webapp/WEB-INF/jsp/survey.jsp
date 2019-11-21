<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<h2>Survey</h2>

<c:url var="formAction" value="/survey"/>
<form:form method="POST" action="${formAction}" modelAttribute="surveyPost">
<div class="formInputGroup">
	<label for="nationalPark">Favorite National Park: </label>
	<form:select path="parkCode" name="park" id="nationalPark">
		<option value="CVNP">Cuyahoga Valley</option>
		<option value="ENP">Everglades</option>
		<option value="GCNP">Grand Canyon</option>
		<option value="GNP">Glacier</option>
		<option value="GSMNP">Great Smoky Mountains</option>
		<option value="GTNP">Grand Teton</option>
		<option value="MRNP">Mount Rainier</option>
		<option value="RMNP">Rocky Mountain</option>
		<option value="YNP">Yellowstone</option>
		<option value="YNP2">Yosemite</option>
	</form:select>
</div>
<div class="formInputGroup">
	<label for="emailAddress">Email: </label>
	<form:input path="emailAddress" />
	<form:errors path="emailAddress" cssClass="error" />
</div>
<div class="formInputGroup">
	<label for="state">State: </label>
	<form:select path="state" name="state" id="state">
		<option value="AL">Alabama</option>
		<option value="AK">Alaska</option>
		<option value="AZ">Arizona</option>
		<option value="AR">Arkansas</option>
		<option value="CA">California</option>
		<option value="CO">Colorado</option>
		<option value="CT">Connecticut</option>
		<option value="DE">Delaware</option>
		<option value="DC">District Of Columbia</option>
		<option value="FL">Florida</option>
		<option value="GA">Georgia</option>
		<option value="HI">Hawaii</option>
		<option value="ID">Idaho</option>
		<option value="IL">Illinois</option>
		<option value="IN">Indiana</option>
		<option value="IA">Iowa</option>
		<option value="KS">Kansas</option>
		<option value="KY">Kentucky</option>
		<option value="LA">Louisiana</option>
		<option value="ME">Maine</option>
		<option value="MD">Maryland</option>
		<option value="MA">Massachusetts</option>
		<option value="MI">Michigan</option>
		<option value="MN">Minnesota</option>
		<option value="MS">Mississippi</option>
		<option value="MO">Missouri</option>
		<option value="MT">Montana</option>
		<option value="NE">Nebraska</option>
		<option value="NV">Nevada</option>
		<option value="NH">New Hampshire</option>
		<option value="NJ">New Jersey</option>
		<option value="NM">New Mexico</option>
		<option value="NY">New York</option>
		<option value="NC">North Carolina</option>
		<option value="ND">North Dakota</option>
		<option value="OH">Ohio</option>
		<option value="OK">Oklahoma</option>
		<option value="OR">Oregon</option>
		<option value="PA">Pennsylvania</option>
		<option value="RI">Rhode Island</option>
		<option value="SC">South Carolina</option>
		<option value="SD">South Dakota</option>
		<option value="TN">Tennessee</option>
		<option value="TX">Texas</option>
		<option value="UT">Utah</option>
		<option value="VT">Vermont</option>
		<option value="VA">Virginia</option>
		<option value="WA">Washington</option>
		<option value="WV">West Virginia</option>
		<option value="WI">Wisconsin</option>
		<option value="WY">Wyoming</option>
	</form:select>
</div>
<div class="formInputGroup">
	<label for="activityLevel">Activity Level: </label>
	<form:select path="activityLevel" >
		<option value="Inactive">Inactive</option>
		<option value="Sedentary">Sedentary</option>
		<option value="Active">Active</option>
		<option value="Extremely Active">Extremely Active</option>
	</form:select>
</div>
<input type="submit" name="submitForm" value="Submit"/>
</form:form>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />