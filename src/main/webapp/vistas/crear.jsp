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
		<h1>CREAR ${ titulo }</h1>
	</header>
	
	<main>
	
		<!-- Empleado -->
		<fieldset>
			<legend>EMPLEADO</legend>
			<form method="post" action="/empleados/crear">
			
				<label for="idEmpl">ID EMPLEADAO:</label>
				<input id="idEmpl" name="idEmpl" />
				<label for="nombre">NOMBRE:</label>
				<input id="nombre" name="nombre" />
				<label for="apellidos">APELLIDO:</label>
				<input id="apellidos" name="apellidos" />
				<label for="correo">CORREO:</label>
				<input id="correo" name="correo" />
				<label for="password">CONTRASEÑA:</label>
				<input id="password" name="password" />
				<label for="salario">SALARIO:</label>
				<input id="salario" name="salario" />
				<label for="fechaIngreso">FECHA INGRESO:</label>
				<input type="date" id="fechaIngreso" name="fechaIngreso" />
				<label for="fechaNacimiento">FECHA NACIMIENTO:</label>
				<input type="date" id="fechaNacimiento" name="fechaNacimiento" />
				
				<label for="idPerfil">PERFIL:</label>
				<select name="idPerfil" id="idPerfil" >
					<c:forEach var="perfil" items="${ listaPerfiles }">
						<option value="${ perfil.idPerfil }">${ perfil.idPerfil } - ${ perfil.nombre }</option>
					</c:forEach>
				</select>
					
				<label for="idDepar">DEPARTAMENTO:</label>
				<select name="idDepar" id="idDepar" >
					<c:forEach var="departamento" items="${ listaDepartamentos }">
						<option value="${ departamento.idDepar }">${ departamento.idDepar } - ${ departamento.nombre }</option>
					</c:forEach>
				</select>
				
				<button type="submit">Crear Empleado</button>
			</form>
			<p>${ empleadoCreado }</p>
		</fieldset>
		
		
		<!-- Departamento -->
		<fieldset>
			<legend>DEPARTAMENTO</legend>
			
			<form method="post" action="/departamentos/crear">
			
				<label for="idDepar">ID DEPARTAMENTO:</label>
				<input name="idDepar" />
				<label for="nombre">NOMBRE:</label>
				<input name="nombre" />
				<label for="direccion">DIRECCIÓN:</label>
				<input name="direccion" />

				
				<label for="idEmpl">JEFE DEPARTAMENTO:</label>
				<select name="idEmpl">
					<c:forEach var="empleado" items="${ listaEmpleados }">
						<option value="${ empleado.idEmpl }">${ empleado.idEmpl } - ${ empleado.nombre }</option>
					</c:forEach>
				</select>

				<button type="submit">Crear Departamento</button>
				
			</form>
			
			<p>${ departamentoCreado }</p>
		</fieldset>
		
		
		<!-- Perfil -->
		<fieldset>
			<legend>PERFIL</legend>
			
			<form method="post" action="/perfiles/crear">
			
				<label for="idPerfil">ID PERFIL:</label>
				<input name="idPerfil" />
				<label for="nombre">NOMBRE:</label>
				<input name="nombre" />

				<button type="submit">Crear Perfil</button>
				
			</form>
			
			<p>${ perfilCreado }</p>
		</fieldset>
		
		<a href="/index">Volver a inicio.</a>
		
	</main>
	
</body>
</html>