<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
    <script type="text/javascript" src="jquery/jquery-3.6.0.min.js"></script>
     <script src="https://unpkg.com/ag-grid-community/dist/ag-grid-community.min.js"></script>
    <script type="text/javascript">
    var empRowData;
    $(document).ready(function(){
     var jqxhr = $.ajax( "http://localhost:8081/csv/readEmp" )
       .done(function(data) {
            empRowData = data;
            $.each (data, function (i) {
                //console.log (i);
                //console.log (data[i]);
                console.log (data[i].firstName);
            });
       }).fail(function(error) {
         console.log( "error" + error);
       }).always(function() {
         console.log( "complete" );
       });

    });

    const columnDefs = [
      { field: "make" },
      { field: "model" },
      { field: "price" }
    ];

    const rowData = [
      { make: "Toyota", model: "Celica", price: 35000 },
      { make: "Ford", model: "Mondeo", price: 32000 },
      { make: "Porsche", model: "Boxter", price: 72000 }
    ];

    const gridOptions = {
      columnDefs: columnDefs,
      rowData: rowData
    };

    const empColumnDefs = [
          { field: "firstName" },
          { field: "lastName" },
          { field: "address" },
          { field: "city" },
          { field: "county" },
          { field: "state" },
          { field: "zip" },
          { field: "companyName" }
        ];

    const empGridOptions = {
       columnDefs: empColumnDefs,
       rowData: empRowData
    };

    document.addEventListener('DOMContentLoaded', () => {
        //const gridDiv = document.querySelector('#myGrid');
        //new agGrid.Grid(gridDiv, gridOptions);

        const empGridDiv = document.querySelector('#empGrid');
        new agGrid.Grid(empGridDiv, empGridOptions);
    });

    </script>
</head>
<body>
<div id="myGrid" style="height: 200px; width:610px;" class="ag-theme-alpine"></div>
<div id="empGrid" style="height: 500px; width:90%;" class="ag-theme-alpine"></div>
</div>
</body>
</html>