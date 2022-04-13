<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
.footer {
    bottom: 0%;
    position: fixed;
}

div.gallery {
  margin: 5px;
  border: 1px solid #ccc;
  float: left;
  width: 180px;
}

div.gallery:hover {
  border: 1px solid #777;
}

div.gallery img {
  width: 100%;
  height: auto;
}

div.desc {
  padding: 15px;
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
	<div class="gallery"><img src=<c:out value="${shoes.simage}"></c:out>>
		
  			<div class="desc">Model: <c:out value="${shoes.smodelname}"></c:out><BR>Company: <c:out value="${shoes.scompany}"></c:out><BR>Category: <c:out value="${shoes.scategory}"></c:out><BR>Size: <c:out value="${shoes.ssize}"></c:out><BR>Price: <c:out value="${shoes.sprice}"></c:out></div></div>


	<c:if test="${empty email}">
	<center><h1>Please <a href='signin'>Log In</a> to buy Shoe</h1></center>
	</c:if>
	
	
	<c:if test="${not empty email}">
		<BR><BR><BR><BR>
		<form action="purchase" method="post">
			<label for="numberofshoes">Number Of Shoes To Buy:</label>
			<input type="number" id="nshoes" name="nshoes" value="1" min="1" max="100">
    		<input type="submit" value="Buy">
  		</form>
		<div class="footer"><a href='logout'>Logout</a></div>
	</c:if>
	
</body>
</html>