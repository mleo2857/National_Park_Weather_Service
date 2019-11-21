<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<table>
	<c:forEach items="${parks}" var="park">
		<tr class="parktile">
		<c:url value="/parkDetail" var="detail">
			<c:param name="id" value="${park.parkCode}"/>
			<c:param name="temp" value="${tempChoice}"/>
		</c:url>
			<td class="parkimage">
				<a href="${detail}"><img src="img/parks/${park.parkCode.toLowerCase()}.jpg" /></a>
			</td>
			<td class="parkcontent">
				<h1 id="parktitle"><a href="${detail}">${park.parkName}</a></h1>
				<p id="state"><strong>${park.state }</strong></p>
				<p id="description" >${park.parkDescription }</p>
			</td>
		</tr>
		
	</c:forEach>
	
</table>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />