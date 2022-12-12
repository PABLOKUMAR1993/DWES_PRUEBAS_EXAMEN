package com.example.model.dao;
import java.util.List;
import com.example.model.entityBeans.Departamento;


public interface DepartamentoDaoInt {

	List<Departamento> buscarTodos();
	Departamento buscarUno( int idDepar );
	boolean crearDepartamento( Departamento departamento );
	boolean eliminarDepartamento( Departamento departamento );
	
}
