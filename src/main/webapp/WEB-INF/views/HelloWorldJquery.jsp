<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jQuery</title>
<script src="jquery/jquery-3.5.1.min.js"></script>

<link href="css/custom.css" rel="stylesheet">

<script>
	$(document).ready(function() {
		$("#myButton").click(function() {
			$("#helloWorldDiv").html("jQuery Hello world example");
		});
	});
</script>
</head>
<body>
	<button id="myButton">Print Hello World</button>
	</br>
	</br>
	<div id="helloWorldDiv"></div>
	<form action="/logout" method="post">
    	<input type="submit" value="Logout" />
    </form>
</body>
</html>