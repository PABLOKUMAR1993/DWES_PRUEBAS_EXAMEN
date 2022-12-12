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
		<h1>Listado de: ${ titulo }</h1>
	</header>
	
	<main>
	
		<!-- Tabla Empleados -->
	
		<table>
		
			<thead>
				<tr>
					<th>ID EMPLEADO</th>
					<th>NOMBRE</th>
					<th>APELLIDO</th>
					<th>CORREO</th>
					<th>SALARIO</th>
					<th>EDITAR</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach var="empleado" items="${ listaEmpleados }">
					<tr>
						<td>${ empleado.idEmpl }</td>
						<td>${ empleado.nombre }</td>
						<td>${ empleado.apellidos }</td>
						<td>${ empleado.correo }</td>
						<td>${ empleado.salario }</td>
						<td><a href="/empleados/editar/${ empleado.idEmpl }">editar</a></td>
					</tr>
				</c:forEach>
			</tbody>
			
		</table>
		
		<!-- Tabla Departamentos -->
	
		<table>
		
			<thead>
				<tr>
					<th>ID DEPARTAMENTOS</th>
					<th>NOMBRE</th>
					<th>DIRECCIÓN</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach var="departamento" items="${ listaDepartamentos }">
					<tr>
						<td>${ departamento.idDepar }</td>
						<td>${ departamento.nombre }</td>
						<td>${ departamento.direccion }</td>
					</tr>
				</c:forEach>
			</tbody>
			
		</table>
		
		<!-- Tabla Perfiles -->
	
		<table>
		
			<thead>
				<tr>
					<th>ID PERFIL</th>
					<th>NOMBRE</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach var="perfil" items="${ listaPerfiles }">
					<tr>
						<td>${ perfil.idPerfil }</td>
						<td>${ perfil.nombre }</td>
					</tr>
				</c:forEach>
			</tbody>
			
		</table>
		
		<a href="/index">Volver a Index.</a>
		
	</main>

</body>
</html>