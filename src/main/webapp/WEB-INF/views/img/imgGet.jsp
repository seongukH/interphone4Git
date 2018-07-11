<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Img GET
</h1>

<form action="/interphone2/image/register" method="post" enctype = "multipart/form-data">
  <input type="file" name="file" >
  
  <input type="text" name="uhome" value=${uhome} readonly>
  
  <input type="submit">
</form>
</body>
</html>
