<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />
<table>
<c:forEach items="${parks}" var="park">
	<tr>
		<td>
			<img src="img/parks/${park.parkCode.toLowerCase()}.jpg" />
		</td>
		<td class="parkcontent">
			<h1 id="parktitle">${park.parkName }</h1>
			<p id="state">${park.state }</p>
			<p id="description">${park.parkDescription }</p>
			<p>Number of reviews: ${surveyMap.get(park.parkName) }</p>
		</td>
	</tr>
</c:forEach>
</table>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />