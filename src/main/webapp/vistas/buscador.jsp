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
		<h1>BUSCADOR</h1>
	</header>

	<main>
	
		<h2>Filtar por departamento</h2>
		<form method="get" action="/empleados/buscador/departamento">
			<label>Filtrar por Departamento:</label>
			<select name="idDepar">
				<c:forEach var="departamento" items="${ listaDepartamentos }">
					<option value="${ departamento.idDepar }">${ departamento.nombre }</option>
				</c:forEach>
			</select>
			<button type="submit">Ver.</button>
		</form>
		
		<ul>
			<c:forEach var="empleado" items="${ listadoEmpleados }">
				<li>${ empleado.idEmpl } - ${ empleado.nombre } - ${ empleado.apellidos } - ${ empleado.departamento.nombre }</li>
			</c:forEach>
		</ul>		
	
		<a href="/empleados/buscador">Volver a buscador.</a>
		<a href="/index">Volver a inicio.</a>
		
	</main>

</body>
</html>