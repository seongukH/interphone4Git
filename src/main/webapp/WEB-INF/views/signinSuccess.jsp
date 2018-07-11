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
	Sign in Success 
</h1>

<P>  The time on the server is ${serverTime}. </P>

<a href = /interphone2/list>Member list</a>
<a href = /interphone2/board/listAll>Board list</a>
<a href = /interphone2/air/registJSON>air list</a>
<a href = /interphone2/indivisual/viewAll>main display</a>
<a href = /interphone2/image/register>uploade image</a>
<p> ${MemberVO.uname} 님 환영합니다.</p>

</body>
</html>
