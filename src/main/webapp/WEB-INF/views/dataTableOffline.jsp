<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="utf-8" />
<title>JQuery Datatables</title>

<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="bootstrap/bootstrap.min.js"></script>
<script type="text/javascript" src="DataTables/datatables.min.js"></script>

<link href="bootstrap/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="DataTables/datatables.min.css" />

<script type="text/javascript">
	$(document).ready(function() {
		var table = $('#employeesTable').DataTable({
			"sAjaxSource" : "/common/employee",
			"sAjaxDataProp" : "",
			"order" : [ [ 0, "asc" ] ],
			"aoColumns" : [ {
				"mData" : "empID"
			}, {
				"mData" : "namePrefix"
			}, {
				"mData" : "lastName"
			}, {
				"mData" : "firstName"
			}, {
				"mData" : "eMail"
			}, {
				"mData" : "fathersName"
			} ]
		})
	});
</script>
</head>

<body>
	<h1>Data Table Offline</h1>
	<table id="employeesTable" class="display">

		<!-- Header Table -->
		<thead>
			<tr>
				<th>Emp Id</th>
				<th>Name Prefix</th>
				<th>Last Name</th>
				<th>First Name</th>
				<th>EMail</th>
				<th>Fathers Name</th>
			</tr>
		</thead>
		<!-- Footer Table -->
		<tfoot>
			<tr>
				<th>Emp Id</th>
				<th>Name Prefix</th>
				<th>Last Name</th>
				<th>First Name</th>
				<th>EMail</th>
				<th>Fathers Name</th>
			</tr>
		</tfoot>
	</table>

</body>
</html>