<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sporty Shoes - Eshop</title>
<style>
.vertical-menu {
  width: 200px;
}

.vertical-menu a {
  background-color: #eee;
  color: black;
  display: block;
  padding: 12px;
  text-decoration: none;
}

.vertical-menu a:hover {
  background-color: #ccc;
}

.vertical-menu a.active {
  background-color: #04AA6D;
  color: white;
}

.flight-table {
  margin-left: auto;
  margin-right: auto;
}

div.content
{
    display: block;
    text-align: center;
}
</style>
</head>
<body>
	<h1>Sporty Shoes - Eshop - Welcome ${email }</h1>

	<div class="vertical-menu">
  		<a href="welcome" class="active">Home</a>
  		<c:if test="${empty email}"><a href="signin">Login</a></c:if>
  		<a href="faq">FAQ</a>
	</div>

<br>
<h3>Sporty Shoes - Order confirmed , thank you for buying with us!</h3>
<br>

	<c:if test="${not empty email}">
		<div class="footer"><a href='logout'>Logout</a></div>
	</c:if>
   
</body>
</html>
