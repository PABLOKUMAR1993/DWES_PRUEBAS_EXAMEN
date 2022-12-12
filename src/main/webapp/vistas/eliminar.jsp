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
		<h1>ELIMINAR</h1>
	</header>
	
	<main>
		
		<h2>Empleados</h2>
		<ul>
			<c:forEach var="empleado" items="${ listaEmpleados }">
				<li>${ empleado.nombre } ${ empleado.apellidos } - <a href="/empleados/eliminar/${ empleado.idEmpl }">Eliminar.</a></li>
			</c:forEach>
		</ul>
		<p>${ mensajeEmpleado }</p>
		
		<!-- NO USAR, LOCO, JODERAS LA BBDD -->
		<h2>Departamentos</h2>
		<ul>
			<c:forEach var="departamento" items="${ listaDepartamentos }">
				<li>${ departamento.nombre } ${ departamento.direccion } - <a href="/departamentos/eliminar/${ departamento.idDepar }">Eliminar.</a></li>
			</c:forEach>
		</ul>
		<p>${ mensajeDepartamento }</p>	
		
		<!-- NO USAR, LOCO, JODERAS LA BBDD -->
		<h2>Empleados</h2>
		<ul>
			<c:forEach var="perfil" items="${ listaPerfiles }">
				<li>${ perfil.nombre } - <a href="/perfiles/eliminar/${ perfil.idPerfil }">Eliminar.</a></li>
			</c:forEach>
		</ul>
		<p>${ mensajePerfil }</p>
		
		<a href="/index">Volver a inicio.</a>
		
	</main>

</body>
</html>