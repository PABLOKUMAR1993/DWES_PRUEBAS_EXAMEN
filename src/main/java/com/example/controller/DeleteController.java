package com.example.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.model.dao.DepartamentoDaoInt;
import com.example.model.dao.EmpleadoDaoInt;
import com.example.model.dao.PerfileDaoInt;


@Controller
public class DeleteController {

	
	// Atributos.
	
	
	@Autowired
	private EmpleadoDaoInt empleadoDao;
	
	@Autowired
	private DepartamentoDaoInt departamentoDao;
	
	@Autowired
	private PerfileDaoInt perfilDao;
	
	
	// Métodos.
	
	
	@GetMapping( "/eliminar" )
	public String eliminarDepartamentoMostrar( Model model ) {
		
		model.addAttribute( "listaEmpleados", empleadoDao.buscarTodos() );
		model.addAttribute( "listaDepartamentos", departamentoDao.buscarTodos() );
		model.addAttribute( "listaPerfiles", perfilDao.buscarTodos() );
		return "eliminar";
		
	}
	
	
}
