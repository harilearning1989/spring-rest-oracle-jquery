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
    <script src="./js/home.js"></script>
    <link href="./css/custom.css" rel="stylesheet">
</head>
<body>
<button id="myButton">Print Hello World</button>
</br>
</br>
<div id="helloWorldDiv"></div>

<form id="search-form">
    <div>
        <label>State</label>
        <div>
            <input type="text" id="state"/>
        </div>
    </div>
    <div>
        <div>
            <button type="submit" id="bth-search">Search</button>
        </div>
    </div>
</form>

<div id="feedback"></div>

</body>
</html>
