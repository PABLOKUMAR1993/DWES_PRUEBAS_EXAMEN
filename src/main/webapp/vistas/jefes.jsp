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
		<h1>Lista de Jefes.</h1>
	</header>
	
	<main>
		
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>NOMBRE</th>
					<th>APELLIDOS</th>
					<th>CORREO</th>
					<th>SALARIO</th>
					<th>DEPARTAMENTO</th>
					<th>PERFIL</th>
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
						<td>${ empleado.departamento.nombre }</td>
						<td>${ empleado.perfile.nombre }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
	</main>
	
</body>
</html>