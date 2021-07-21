<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajax Methods</title>
<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="DataTables/jquery.dataTables.min.js"></script>

<link rel="stylesheet" type="text/css"
	href="DataTables/jquery.dataTables.min.css" />
<script type="text/javascript">
	$(document).ready(function() {
	     $("#search-form").submit(function (event) {
            //stop submit the form, we will post it manually.
            event.preventDefault();
            fire_ajax_submit();
        });
	});
	function fire_ajax_submit() {
        var search = {}
        search["username"] = $("#username").val();
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "http://localhost:8081/common/api/search",
            data: JSON.stringify(search),
            dataType: 'json',
            cache: false,
            timeout: 600000,
            success: function (data) {
                console.log("SUCCESS : ", data);
                var json = "<h4>Ajax Response</h4>&lt;pre&gt;" + JSON.stringify(data, null, 4) + "&lt;/pre&gt;";
                     $('#feedback').html(json);
            },
            error: function (e) {
                console.log("ERROR : ", e);
                var json = "<h4>Ajax Response</h4>&lt;pre&gt;" + e.responseText + "&lt;/pre&gt;";
                                            $('#feedback').html(json);
            }
        });
    }
</script>
</head>
<body style="width: 100%;height:100%;background-color: lightblue;">
 <form id="search-form">
  <input type="text" id="username"/>
  <button type="submit" id="bth-search">Search</button>
 </form>
 <div id="feedback"></div>
</body>
</html>