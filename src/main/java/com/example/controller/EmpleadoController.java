package com.example.controller;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.model.dao.DepartamentoDaoInt;
import com.example.model.dao.EmpleadoDaoInt;
import com.example.model.dao.PerfileDaoInt;
import com.example.model.entityBeans.Empleado;


@Controller
@RequestMapping( "/empleados" )
public class EmpleadoController {

	
	// Atributos.
	
	
	@Autowired
	private EmpleadoDaoInt empleadoDao;
	
	@Autowired
	private DepartamentoDaoInt departamentoDao;
	
	@Autowired
	private PerfileDaoInt perfilDao;
	
	
	// Métodos.
	
	
	@GetMapping( "/todos" )
	public String verEmpleados( Model model ) {
		
		model.addAttribute( "titulo", "Empleados" );
		model.addAttribute( "listaEmpleados", empleadoDao.buscarTodos() );
		return "verTodos";
	
	}
	
	@GetMapping( "/crear" )
	public String crearEmpleadoMostrar( Model model ) {
		
		model.addAttribute( "listaDepartamentos", departamentoDao.buscarTodos() );
		model.addAttribute( "listaPerfiles", perfilDao.buscarTodos() );
		model.addAttribute( "titulo", "EMPLEADO" );
		return "crear";
		
	}
	
	@PostMapping( "/crear" )
	public String crearEmpleado( @RequestParam( "idPerfil" ) int idPerfil, @RequestParam( "idDepar" ) int idDepar, Empleado empleado, Model model ) {
		
		empleado.setDepartamento( departamentoDao.buscarUno( idDepar ) );
		empleado.setPerfile( perfilDao.buscarUno( idPerfil ) );
		
		if( empleadoDao.crearEmpleadao( empleado ) ) {
			model.addAttribute( "empleadoCreado", "El empleado ha sido creado" );
			return "crear";
		} else {
			model.addAttribute( "empleadoCreado", "El empleado NO ha sido creado" );
			return "crear";
		}
		
		
	}
	
	@GetMapping( "/eliminar/{idEmpl}" )
	public String eliminarDepartamento( @PathVariable( "idEmpl" ) int idEmpl, Model model ) {
		
		Empleado empleado = empleadoDao.buscarUno( idEmpl );
		
		if( empleadoDao.eliminarEmpleado( empleado ) ) {
			model.addAttribute( "mensajeEmpleado", "Empleado eliminado." );
			return "eliminar";
		} else {
			model.addAttribute( "mensajeEmpleado", "Empleado NO eliminado." );
			return "eliminar";
		}

	}
	
	@GetMapping( "/editar/{idEmpl}" )
	public String editarEmpleadoMostrar( @PathVariable( "idEmpl" ) int idEmpl, HttpSession sesion ) {
		
		Empleado empleado = empleadoDao.buscarUno( idEmpl );
		sesion.setAttribute( "empleado", empleado );
		return "editar";
		
	}
	
	@PostMapping( "/editar" )
	public String editarEmpleadoId( @RequestParam( "nombre" ) String nombre, @RequestParam( "apellidos" ) String apellidos, HttpSession sesion, Model model ) {
		
		Empleado empleado = ( Empleado ) sesion.getAttribute( "empleado" );
		
		if( nombre != "" ) { empleado.setNombre( nombre ); }
		if( apellidos != "" ) { empleado.setApellidos( apellidos ); }
		
		if( empleadoDao.editarEmpleado(empleado) ) {
			model.addAttribute( "mensajeEditar", "Empleado Editado" );
			return "editar";
		} else {
			model.addAttribute( "mensajeEditar", "Empleado NO Editado" );
			return "editar";
		}
		
	}
	
	@GetMapping( "/buscador" )
	public String buscadorEmpleadosMostrar( Model model ) {
		
		model.addAttribute( "listaDepartamentos", departamentoDao.buscarTodos() );
		return "buscador";
		
	}
	
	@GetMapping( "/buscador/departamento" )
	public String buscadorEmpleados( @RequestParam( "idDepar" ) int idDepar, Model model ) {
		
		model.addAttribute( "listadoEmpleados", empleadoDao.buscarPorDepartamento( idDepar ) );
		return "buscador";
		
	}
	
	@GetMapping( "/jefes" )
	public String verJefes( Model model ) {
		
		model.addAttribute( "listaEmpleados", empleadoDao.mostrarJefes() );
		return "jefes";
		
	}
	
	//CONTROL DE FECHAS
	@InitBinder
	public void initBinder ( WebDataBinder webdataBinder ) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		webdataBinder.registerCustomEditor( Date.class, new CustomDateEditor( sdf, false ) );
		
	}
	
}
