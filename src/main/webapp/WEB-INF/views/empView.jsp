<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h3>Employees List</h3>
<table border="2" width="70%" cellpadding="2">
	<tr>
		<th>First Name</th>
		<th>Last Name</th>
	</tr>
	<c:forEach var="emp" items="${empDataList}">
		<tr>
			<td>${emp.firstName}</td>
			<td>${emp.lastName}</td>
		</tr>
	</c:forEach>
</table>
<br />
<a href="empform">Add New Employee</a>