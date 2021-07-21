<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ag Grid Hello World</title>
<script type="text/javascript" src="ag-grid/ag-grid-community.min.js"></script>
<script type="text/javascript">
	const columnDefs = [
		  { field: "make" },
		  { field: "model" },
		  { field: "price" }
		];

	// specify the data
	const rowData = [
	  { make: "Toyota", model: "Celica", price: 35000 },
	  { make: "Ford", model: "Mondeo", price: 32000 },
	  { make: "Porsche", model: "Boxter", price: 72000 }
	];

	// let the grid know which columns and what data to use
	const gridOptions = {
	  columnDefs: columnDefs,
	  rowData: rowData
	};

	// setup the grid after the page has finished loading
	document.addEventListener('DOMContentLoaded', () => {
	    const gridDiv = document.querySelector('#myGrid');
	    new agGrid.Grid(gridDiv, gridOptions);
	});
</script>
</head>
<body style="background-color: lightblue;">
	<div id="myGrid" style="height: 200px; width: 610px;"
		class="ag-theme-alpine"></div>
</body>
</html>