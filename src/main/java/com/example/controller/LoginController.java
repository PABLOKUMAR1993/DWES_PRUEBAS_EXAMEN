package com.example.controller;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.dao.EmpleadoDaoInt;
import com.example.model.entityBeans.Empleado;


@Controller
public class LoginController {

	
	@Autowired
	private EmpleadoDaoInt empleadoDao;
	
	
	@GetMapping( "/login" )
	public String login( @RequestParam("idEmpleado") int idEmpleado, @RequestParam("password") String password, HttpSession sesion, Model model ) {
	
		if( empleadoDao.comprobarEmpleado( idEmpleado ) ) {
			
			Empleado empleado = empleadoDao.buscarUno( idEmpleado );

			if( empleado.getPassword().equals( password ) ) {
				sesion.setAttribute( "empleado", empleado );
				model.addAttribute( "mensajeErrorLogin", "usuario y contraseña ok" );
				return "index";
			} else {
				model.addAttribute( "mensajeErrorLogin", "El usuario existe, pero la contraseña es erronea." );
				return "login";
			}
			
		} else {
			
			model.addAttribute( "mensajeErrorLogin", "El usuario no existe." );
			return "login";
			
		}
		
	}
	
}
