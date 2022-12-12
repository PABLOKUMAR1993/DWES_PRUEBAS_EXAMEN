package com.example.model.dao;

import java.util.List;

import com.example.model.entityBeans.Empleado;

public interface EmpleadoDaoInt {
	
	List<Empleado> buscarTodos();
	Empleado buscarUno( int idEmpleado );
	boolean comprobarEmpleado( int idEmpleado );
	boolean crearEmpleadao( Empleado empleado );
	boolean eliminarEmpleado( Empleado empleado );
	boolean editarEmpleado( Empleado empleado );
	List<Empleado> buscarPorDepartamento( int idDepar );
	List<Empleado> mostrarJefes();
	
}
