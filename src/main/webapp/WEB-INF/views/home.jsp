<%--
  Created by IntelliJ IDEA.
  User: Hari
  Date: 18-07-2021
  Time: 00:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <script src="./jquery/jquery-3.5.1.min.js"></script>
    <script src="bootstrap/bootstrap.min.js"></script>
    <script type="text/javascript" src="DataTables/datatables.min.js"></script>
    <script src="./js/home.js"></script>
    <link href="./css/custom.css" rel="stylesheet">
    <link href="bootstrap/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="DataTables/datatables.min.css"/>
</head>
<body>
<button id="myButton">Print Hello World</button>
</br>
</br>
<div id="helloWorldDiv"></div>

<form id="search-form">
    <div>
        <label>Mandal</label>
        <div>
            <input type="text" id="mandal"/>
        </div>
    </div>
    <div>
        <div>
            <button type="submit" id="bth-search">Search</button>
        </div>
    </div>
</form>

<div id="feedback"></div>
<div class="row" style="width:100%">
    <div class="row" style="width:100%">
        <div class="col" style="width:50%">
            <table id="example" class="display">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Village</th>
                    <th>LOANEE</th>
                    <th>Crop</th>
                    <th>Amount</th>
                </tr>
                </thead>
            </table>
        </div>
        <div class="col" style="width:50%"></div>
    </div>
    <div class="row" style="width:100%">
        <div class="col" style="width:50%"></div>
        <div class="col" style="width:50%"></div>
    </div>
</div>

</body>
</html>
