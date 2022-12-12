package com.example.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.model.entityBeans.Empleado;


public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> { 
	
	@Query( "select e from Empleado e where e.departamento.idDepar = ?1" )
	List<Empleado> buscarPorDepartamento( int idDepar );
	
	@Query( value = "select * from empleados e inner join departamentos d on e.id_empl = d.jefe_depar", nativeQuery = true )
	List<Empleado> mostrarJefes();
	
}
