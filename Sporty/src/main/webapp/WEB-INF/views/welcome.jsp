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
  		<a href="#" class="active">Home</a>
  		<c:if test="${empty email}"><a href="signin">Login</a></c:if>
  		<a href="faq">FAQ</a>
	</div>
	
	<div>
		<c:forEach items="${shoes}" var="entry">
   <%-- 		<div class="gallery"><a target="_blank" href="buy?Sid=<c:out value="${entry.sid}"></c:out>"><img src=<c:out value="${entry.simage}"></c:out> alt="Cinque Terre" width="600" height="400"></a>
  			<div class="desc">Model: <c:out value="${entry.smodelname}"></c:out><BR>Company: <c:out value="${entry.scompany}"></c:out><BR>Category: <c:out value="${entry.scategory}"></c:out><BR>Size: <c:out value="${entry.ssize}"></c:out><BR>Price: <c:out value="${entry.sprice}"></c:out></div></div>
		--%>
			<div class="gallery"><form method="POST" action="buy">
			<input type="hidden" name="sid" value="${entry.sid}">
	<input type="image" src="${entry.simage}" alt="Submit Form" width="180" height=auto/>
	</form>
  			<div class="desc">Model: <c:out value="${entry.smodelname}"></c:out><BR>Company: <c:out value="${entry.scompany}"></c:out><BR>Category: <c:out value="${entry.scategory}"></c:out><BR>Size: <c:out value="${entry.ssize}"></c:out><BR>Price: <c:out value="${entry.sprice}"></c:out></div></div>
		
		</c:forEach>	
	</div>
	<c:if test="${not empty email}">
	<div class="footer"><a href='logout'>Logout</a></div>
	</c:if>
</body>
</html>