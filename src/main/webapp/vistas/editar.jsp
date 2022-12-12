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
		<h1>EDITAR</h1>
	</header>
	
	<main>
	
		
			<ul>
				<li>ID: ${ empleado.idEmpl }</li>
				<li>Nombre: ${ empleado.nombre }</li>
				<li>Apellidos: ${ empleado.apellidos }</li>
				<li>Correo: ${ empleado.correo }</li>
				<li>Contraseña: ${ empleado.password }</li>
				<li>Salario: ${ empleado.salario }</li>
				<li>Fecha Ingreso: ${ empleado.fechaIngreso }</li>
				<li>Fecha Nacimiento: ${ empleado.fechaNacimiento }</li>
				<li>Perfil: ${ empleado.perfile.nombre }</li>
				<li>Departamento: ${ empleado.departamento.nombre }</li>
			</ul>
			
			<!-- Se podría expandir con todos los campos -->
			<form method="post" action="/empleados/editar">
				<fieldset>
					<legend>CAMPOS A EDITAR:</legend>
					<p>Nombre: ${ empleado.nombre }</p>
					<input name="nombre" placeholder="Nuevo Nombre"/>
					<p>Apellidos: ${ empleado.apellidos }</p>
					<input name="apellidos" placeholder="Nuevo Apellido"/>
					<input type="submit" value="Editar"/>
				</fieldset>
			</form>
		
		<p>${ mensajeEditar }</p>

		<a href="/index">Volver a Index.</a>

	</main>

</body>
</html>