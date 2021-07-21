<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="ag-grid/ag-grid-enterprise.min.js"></script>
<script type="text/javascript">
	var gridOptions = {
		  columnDefs: [
		    { field: 'athlete', minWidth: 220 },
		    { field: 'country', minWidth: 200 },
		    { field: 'year' },
		    { field: 'sport', minWidth: 200 },
		    { field: 'gold' },
		    { field: 'silver' },
		    { field: 'bronze' },
		  ],

		  defaultColDef: {
		    flex: 1,
		    minWidth: 100,
		  },

		  // use the server-side row model instead of the default 'client-side'
		  rowModelType: 'serverSide',
		};

		// setup the grid after the page has finished loading
		document.addEventListener('DOMContentLoaded', function () {
		  var gridDiv = document.querySelector('#myGrid');
		  new agGrid.Grid(gridDiv, gridOptions);

		  agGrid
		    .simpleHttpRequest({
		      url: 'https://www.ag-grid.com/example-assets/olympic-winners.json',
		    })
		    .then(function (data) {
		      // setup the fake server with entire dataset
		      var fakeServer = createFakeServer(data);

		      // create datasource with a reference to the fake server
		      var datasource = createServerSideDatasource(fakeServer);

		      // register the datasource with the grid
		      gridOptions.api.setServerSideDatasource(datasource);
		    });
		});

		function createServerSideDatasource(server) {
		  return {
		    getRows: function (params) {
		      console.log('[Datasource] - rows requested by grid: ', params.request);

		      // get data for request from our fake server
		      var response = server.getData(params.request);

		      // simulating real server call with a 500ms delay
		      setTimeout(function () {
		        if (response.success) {
		          // supply rows for requested block to grid
		          params.success({ rowData: response.rows });
		        } else {
		          params.fail();
		        }
		      }, 500);
		    },
		  };
		}

		function createFakeServer(allData) {
		  return {
		    getData: function (request) {
		      // take a copy of the data to return to the client
		      var requestedRows = allData.slice();

		      return {
		        success: true,
		        rows: requestedRows,
		      };
		    },
		  };
		}
</script>
</head>
<body style="background-color: lightblue;">
	<div id="myGrid" style="height: 100%;" class="ag-theme-alpine-dark">
	</div>
</body>
</html>