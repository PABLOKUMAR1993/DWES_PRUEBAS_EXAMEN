<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
</head>
<body>
	
	<header>
		<h1>Estás en index.</h1>
	</header>
	
	<main>
		<ul>
			<li><a href="/empleados/todos">Ver todos los empleados</a></li> <!-- done -->
			<li><a href="/departamentos/todos">Ver todos los departamentos</a></li> <!-- done -->
			<li><a href="/perfiles/todos">Ver todos los perfiles</a></li> <!-- done -->
			<li><a href="/empleados/crear">Crear Empleado</a></li> <!-- done -->
			<li><a href="/departamentos/crear">Crear Departamento</a></li> <!-- done -->
			<li><a href="/perfiles/crear">Crear Perfil</a></li> <!-- done, with error -->
			<li><a href="/eliminar">Eliminar</a></li> <!-- done -->
			<li><a href="/empleados/buscador">Buscador</a></li> <!-- done -->
			<li><a href="/empleados/jefes">Lista de Jefes</a></li> <!-- done -->
		</ul>
	</main>
	
	<footer>
	<a href="/">Volver a login.</a>
	</footer>
	
</body>
</html>