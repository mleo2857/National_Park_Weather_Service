<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />
<c:url value="/parkDetail" var="detail">
	<c:param name="id" value="${park.parkCode}"/>
</c:url>
<div class="background">
	<div>
		<img id="parkimg" src="img/parks/${park.parkCode.toLowerCase()}.jpg" />
		<table>
			<tr><td class="parktitle">${park.parkName }</td>
				<td class="quote">"${park.inspirationalQuote}"
			- ${park.inspirationalQuoteSource}</td>
			</tr>
		</table>
		<h3>${park.state }</h3>
		<p>${park.parkDescription }</p>
		<table>
		<tr>
			<td class="parkdataleft"><strong>Climate: </strong>${park.climate}</td>
			<td><strong>Acres: </strong><fmt:formatNumber  value="${park.acreage}"/></td>
		</tr>
		<tr>
			<td class="parkdataleft"><strong>Year Founded: </strong>${park.yearFounded}</td>
			<td><strong>Elevation: </strong><fmt:formatNumber  value="${park.elevationInFeet}"/> ft.</td>
		</tr>
		<tr>
			<td class="parkdataleft"><strong>Yearly Visitors: </strong><fmt:formatNumber  value="${park.annualVisitorCount}"/></td>
			<td><strong>Miles of Trail: </strong><fmt:formatNumber  value="${park.milesOfTrail}"/></td>
		</tr>
		<tr>
			<td class="parkdataleft"><strong>Animal Species: </strong>${park.numberOfAnimalSpecies}</td>
			<td><strong>Number of Campsites: </strong><fmt:formatNumber  value="${park.numberofCampSites}"/></td>
		</tr>
		</table>	
		
		<p>Fee: $${park.entryFee}</p>
		
	</div>
	<div>
		<form action="${detail}" method="GET">
			<input type="hidden" name="id" value="${park.parkCode}"/>
			<input type="radio" name="temp" value="Fahrenheit">Fahrenheit<br>
			<input type="radio" name="temp" value="Celsius">Celsius<br>
			<input type="submit" value="Submit"/>
		</form>
		<div class="forecast">
		<c:forEach items="${weather}" var="day">
			<div class="day">
			<img class="weatherimg" src="img/weather/${day.forecast}.png"/>
			<c:choose>
				<c:when test="${tempChoice == 'Fahrenheit'}">
					<p><strong>High: </strong>${day.high} F</p>
					<p><strong>Low: </strong>${day.low} F</p>
				</c:when>
				<c:when test="${tempChoice == 'Celsius'}">
					<p><strong>High: </strong><fmt:formatNumber type="number" maxFractionDigits="1" value="${(day.high - 32) * (5/9)}"/> C</p>
					<p><strong>Low: </strong><fmt:formatNumber type="number" maxFractionDigits="1" value="${(day.low - 32) * (5/9)}"/> C</p>
				</c:when>
			</c:choose>	
				<p class="weathertype">${day.forecastName}</p>
				
				
				<c:choose>
					<c:when test="${day.high > 75}">
						<p>Bring an extra gallon of water</p>
					</c:when>	
					<c:when test="${day.low < 20}">
						<p>Be careful of frigid temperatures!</p>
					</c:when>
				</c:choose>
				<c:choose>
					<c:when test="${day.high - day.low > 20}">
						<p>Wear breathable layers!</p>
					</c:when>	
				</c:choose>
				<c:choose>
					<c:when test="${day.forecast == 'snow'}">
						<p>Pack Snow Shoes!</p>
					</c:when>
					<c:when test="${day.forecast == 'rain'}">
						<p>Pack rain gear and wear waterproof shoes!</p>
					</c:when>
					<c:when test="${day.forecast == 'sunny'}">
						<p>Pack sunblock!</p>
					</c:when>
					<c:when test="${day.forecast == 'thunderstorms'}">
						<p>Seek shelter and avoid hiking on exposed ridges!</p>
					</c:when>
				</c:choose>
				</div>
		</c:forEach>
		</div>
	</div>
</div>







