<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>

 <!-- Bootstrap 3.3.4 -->
    <link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    
    
	<title>Home</title>
</head>
<body>
<h1>
	회원정보 입력
</h1>

<div class="form-group row pull-right"></div>

<form role="form" method="post">

	<div class="form-group">
		<label for="inputEmail" class="sr-only">User ID</label>
        <input type="text" name="uid" id="inputEmail" class="form-control" placeholder="User Id" required autofocus>
        
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" name="upw" id="inputPassword" class="form-control" placeholder="Password" required>
	
		<label for="inputName" class="sr-only">User Name</label>
        <input type="text" name="uname" id="inputName" class="form-control" placeholder="User Name" required>
	
		<label for="home" class="sr-only">User Home</label>
        <input type="text" name="uhome" id="inputHome" class="form-control" placeholder="User Home" required>
	</div>
						
	<!-- 				
	id:<input type="text" name="userId"> <br>
	pw:<input type="text" name="userPw"> <br>
	name:<input type="text" name="userName"> <br>
	age:<input type="text" name="userAge"> <br>
	gender:<input type="text" name="userGender"> <br>
	email:<input type="text" name="userEmail"> <br>
	hobby:<input type="text" name="userHobby"> <br>
 -->	
	<button class="btn btn-primary" type="submit">Sign Up</button>
</form>

</div>

</body>
</html>
