<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="DataTables/jquery.dataTables.min.js"></script>

<link rel="stylesheet" type="text/css"
	href="DataTables/jquery.dataTables.min.css" />
	
<script type="text/javascript">
	$(document).ready(function() {

	 // Setup - add a text input to each footer cell
        $('#empTable thead tr').clone(true).appendTo( '#empTable thead' );
        $('#empTable thead tr:eq(1) th').each( function (i) {
            var title = $(this).text();
            $(this).html( '<input type="text" placeholder="Search '+title+'" />' );

            $( 'input', this ).on( 'keyup change', function () {
                if ( table.column(i).search() !== this.value ) {
                    table
                        .column(i)
                        .search( this.value )
                        .draw();
                }
            } );
        } );

		var table = $('#empTable').DataTable({
			"sAjaxSource" : "/common/employee",
			"sAjaxDataProp" : "",
			orderCellsTop: true,
            fixedHeader: true,
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
	<table id="empTable" class="display">

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