<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1"> 



 <!-- Bootstrap 3.3.4 -->
    <link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />


	<title>Home</title>
</head>
<body>
	<div class="container">
		<h1>
			Hello world!  
		</h1>

		<P>  The time on the server is ${serverTime}. </P>

		<a href = /interphone2/signup>Sign Up</a>
		<a href = /interphone2/signin>Sign In</a>
		
	
	</div>
	
	
	


</body>
</html>
