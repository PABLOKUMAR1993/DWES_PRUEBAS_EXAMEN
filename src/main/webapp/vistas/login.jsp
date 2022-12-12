<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<header>
	<h1>LOGIN</h1>
	</header>
	
	<main>
	
		<form method="get" action="/login">
		
			<label for="idEmpleado">Id:</label>
			<input type="number" name="idEmpleado" id="idEmpleado" />
			<label for="password">Contraseña:</label>
			<input type="text" name="password" id="password" />
			
			<button type="submit">Entrar</button>
			
		</form>
		
		<!-- Error -->
		
		<p>${ mensajeErrorLogin }</p>
		
	</main>
	
</body>
</html>