package com.example.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.model.dao.PerfileDaoInt;
import com.example.model.entityBeans.Perfile;


@Controller
@RequestMapping( "/perfiles" )
public class PerfileController {

	
	// Atributos.
	
	
	@Autowired
	private PerfileDaoInt perfilDao;
	
	
	// Métodos.
	
	
	@GetMapping( "/todos" )
	public String verPerfiles( Model model ) {
		
		model.addAttribute( "titulo", "Perfiles" );
		model.addAttribute( "listaPerfiles", perfilDao.buscarTodos() );
		return "verTodos";
	
	}
	
	@GetMapping( "/crear" )
	public String crearPerfilMostrar( Model model ) {
		
		model.addAttribute( "titulo", "PERFIL" );
		return "crear";
		
	}
	
	@PostMapping( "/crear" ) //No funciona bien, si coinciden datos, modifica.
	public String crearPerfil( Perfile perfil, Model model ) {
		
		if( perfilDao.crearPerfil( perfil ) ) {
			model.addAttribute( "perfilCreado", "El perfil ha sido creado" );
			return "crear";
		} else {
			model.addAttribute( "perfilCreado", "El perfil NO ha sido creado" );
			return "crear";
		}
		
	}
	
	@GetMapping( "/eliminar/{idPerfil}" )
	public String eliminarDepartamento( @PathVariable( "idPerfil" ) int idPerfil, Model model ) {
		
		Perfile perfil = perfilDao.buscarUno( idPerfil );
		
		if( perfilDao.eliminarPerfil( perfil ) ) {
			model.addAttribute( "mensajePerfil", "Perfil eliminado." );
			return "eliminar";
		} else {
			model.addAttribute( "mensajePerfil", "Perfil NO eliminado." );
			return "eliminar";
		}

	}
	
}
