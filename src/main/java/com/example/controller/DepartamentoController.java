package com.example.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.model.dao.DepartamentoDaoInt;
import com.example.model.dao.EmpleadoDaoInt;
import com.example.model.entityBeans.Departamento;


@Controller
@RequestMapping( "/departamentos" )
public class DepartamentoController {

	
	// Atributos.
	
	
	@Autowired
	private DepartamentoDaoInt departamentoDao;
	
	@Autowired
	private EmpleadoDaoInt empleadoDao;
	
	
	// Métodos.
	
	
	@GetMapping( "/todos" )
	public String verDepartamentos( Model model ) {
		
		model.addAttribute( "titulo", "Departamentos" );
		model.addAttribute( "listaDepartamentos", departamentoDao.buscarTodos() );
		return "verTodos";
	
	}
	
	@GetMapping( "/crear" )
	public String crearDepartamentoMostrar( Model model ) {
		
		model.addAttribute( "listaEmpleados", empleadoDao.buscarTodos() );
		model.addAttribute( "titulo", "DEPARTAMENTO" );
		return "crear";
		
	}
	
	@PostMapping( "/crear" )
	public String crearDepartamento( Departamento departamento, @RequestParam("idEmpl") int idEmpl, Model model ) {
		
		departamento.setEmpleado( empleadoDao.buscarUno( idEmpl ) );
		
		if( departamentoDao.crearDepartamento( departamento ) ) {
			model.addAttribute( "departamentoCreado", "El departamento ha sido creado" );
			return "crear";
		} else {
			model.addAttribute( "departamentoCreado", "El departamento NO ha sido creado" );
			return "crear";
		}

	}
	
	@GetMapping( "/eliminar/{idDepar}" )
	public String eliminarDepartamento( @PathVariable( "idDepar" ) int idDepar, Model model ) {
		
		Departamento departamento = departamentoDao.buscarUno( idDepar );
		
		if( departamentoDao.eliminarDepartamento( departamento ) ) {
			model.addAttribute( "mensajeDepartamento", "Departamento eliminado." );
			return "eliminar";
		} else {
			model.addAttribute( "mensajeDepartamento", "Departamento NO eliminado." );
			return "eliminar";
		}

	}
	
}

























