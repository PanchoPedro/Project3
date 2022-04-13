<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sporty Shoes - Admin Page</title>
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



</style>
</head>
<body>
	<h1>Sporty Shoes - Admin Portal - Welcome ${email }</h1>

	<div class="vertical-menu">
  		<a href="adminhome" class="active">Admin Home</a>
  		<c:if test="${empty email}"><a href="signin">Login</a></c:if>
  		<a href="browseproducts">Browse Products</a>
  		<a href="manageproducts">Manage Products</a>
  		<a href="browsecompanies">Browse Companies</a>
  		<a href="managecompanies">Manage Companies</a>
  		<a href="browsecategories">Browse Categories</a>
  		<a href="managecategories">Manage Categories</a>
  		<a href="browseusers">Browse Users</a>
  		<a href="searchusers">Search Users</a>
  		<a href="purchasereports">Purchase Reports</a>
	</div>
	<form action="searchuser" method="POST">
					<input type="email" id="email"  name="email" placeholder="Email"/> 
					 <input type="submit" value="Search User by email" />
				</form>
	
	<c:if test="${not empty email}">
	<div class="footer"><a href='logout'>Logout</a></div>
	</c:if>
</body>
</html>