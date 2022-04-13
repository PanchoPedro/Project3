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

</style>
</head>
<body>
	<h1>Sporty Shoes - Eshop - Welcome ${email }</h1>

	<div class="vertical-menu">
  		<a href="welcome" class="active">Home</a>
  		<c:if test="${empty email}"><a href="signin">Login</a></c:if>
  		<a href="faq">FAQ</a>
	</div>
	<h1 style="color:red;">
						${error }</h1>
	<div>
					<h2 class='sign'>Sign In!!</h2>
					
					
				</div>
				<form action="login" method="POST">
					<input type="text" id="login" class="fadeIn second" name="email"
						placeholder="Email"
						/> 
						<input type="password" 
						id="password" class="fadeIn third" name="password"
						placeholder="Password"/> <input type="submit"
						class="fadeIn fourth" value="Log In" />
				</form>
				
				
				<div class="register-box">	
<div>
<BR><BR><BR>
<h2>Or Register Here</h2>
</div>
	<form action="register" method="post">
		<label><b>Enter your first name</b></label><br/> <input type="text" id="firstname" name="firstname" placeholder="Your name.." required="required"><br>
		<label><b>Enter your last name</b></label><br/> <input type="text" id="surname" name="surname" placeholder="Your last name.." required="required"><br>
		<label><b>Enter your email : </b></label><br/><input type="email" name="email" required="required"><br>
		<label><b>Enter your phone number :</b></label><br/><input type="tel" id="phone" name="phone" placeholder="format 0351911111111" pattern="[0]{1}[0-9]{12}" required="required"><br>
		<label><b>Enter your password : </b></label><br/><input type="password" name="password" required="required"><br>
		<label><b>Enter your of birth</b></label><br/><input type="date" id="dateofbirth" name="dateofbirth"><br>
		<button type="submit"><b>Register</b></button>
		<br>

	</form>
	
</div>
				
		
</body>
</html>