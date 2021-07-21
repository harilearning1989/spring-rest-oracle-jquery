<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>jQuery UI Accordion - Default functionality</title>
<link rel="stylesheet" href="jquery/jquery-ui.css">
<script type="text/javascript" src="jquery/jquery-3.5.1.min.js">
	
</script>

<script type="text/javascript" src="jquery/jquery-ui.min.js">
	
</script>
<script>
	$(function() {
		$("#accordion").accordion();
		$("#dialog").dialog();
		$( "#datepicker" ).datepicker();
	});

	$(function() {
		var availableTags = [ "ActionScript", "AppleScript", "Asp", "BASIC",
				"C", "C++", "Clojure", "COBOL", "ColdFusion", "Erlang",
				"Fortran", "Groovy", "Haskell", "Java", "JavaScript", "Lisp",
				"Perl", "PHP", "Python", "Ruby", "Scala", "Scheme" ];
		$("#tags").autocomplete({
			source : availableTags
		});
	});
</script>
</head>

<body>
	<div id="accordion">
		<h3>Android</h3>

		<div>
			<p>Android is an open source and Linux-based operating system for
				mobile devices such as smartphones and tablet computers. Android was
				developed by the Open Handset Alliance, led by Google, and other
				companies.</p>
			<div class="ui-widget">
				<label for="tags">Tags: </label> <input id="tags">
			</div>
			<p>
				Date: <input type="text" id="datepicker">
			</p>
			<div id="dialog" title="Basic dialog">
				<p>This is the default dialog which is useful for displaying
					information. The dialog window can be moved, resized and closed
					with the 'x' icon.</p>
			</div>
		</div>

		<h3>CSS</h3>

		<div>
			<p>CSS is the acronym for "Cascading Style Sheet". This tutorial
				covers both the versions CSS1,CSS2 and CSS3, and gives a complete
				understanding of CSS, starting from its basics to advanced concepts.
			</p>
		</div>

		<h3>AngularJS</h3>

		<div>
			<p>AngularJS is a very powerful JavaScript library. It is used in
				Single Page Application (SPA) projects. It extends HTML DOM with
				additional attributes and makes it more responsive to user actions.
				AngularJS is open source, completely free, and used by thousands of
				developers around the world. It is licensed under the Apache license
				version 2.0.</p>

			<ul>
				<li>List item one</li>
				<li>List item two</li>
				<li>List item three</li>
			</ul>

		</div>

		<h3>PHP</h3>

		<div>
			<p>The PHP Hypertext Preprocessor (PHP) is a programming language
				that allows web developers to create dynamic content that interacts
				with databases. PHP is basically used for developing web based
				software applications. This tutorial helps you to build your base
				with PHP.</p>

			<p>Before proceeding with this tutorial you should have at least
				basic understanding of computer programming, Internet, Database, and
				MySQL etc is very helpful.</p>

		</div>
	</div>
</body>
</html>