<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

 <!-- Bootstrap 3.3.4 -->
    <link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    
    
	<title>Home</title>
</head>
<body>



<div class="container">

	<img src="/resources/image/gachon.jpg"/>
		
      <form class="form-signin" role="form" action="loginPost" method="post">
      
      
        <h2 class="form-signin-heading">로그인 서비스를 이용하실 수 있습니다.</h2>
        
        
        <label for="inputEmail" class="sr-only">User ID</label>
        <input type="text" name="uid" id="inputEmail" class="form-control" placeholder="User Id" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" name="upw" id="inputPassword" class="form-control" placeholder="Password" required>
        
        
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      	<a href = /interphone2/signup>Sign Up</a>
      </form>

    </div> <!-- /container -->
    
    

<!-- 
<form role="form" method="post">
	id:<input type="text" name="userId"> <br>
	pw:<input type="text" name="userPw"> <br>
	

	<button type="submit">Sign In</button>
</form>
 -->
</body>
</html>
