package com.example.model.dao;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.model.entityBeans.Empleado;
import com.example.repository.EmpleadoRepository;


@Repository
public class EmpleadoDaoImpl implements EmpleadoDaoInt {

	
	// Atributos
	
	
	@Autowired
	EmpleadoRepository empleadoRepo;
	
	
	// Métodos Implementados.
	
	
	@Override
	public List<Empleado> buscarTodos() { return empleadoRepo.findAll(); }
	
	@Override
	public Empleado buscarUno(int idEmpleado) { return empleadoRepo.findById( idEmpleado ).orElse(null); }

	@Override
	public boolean comprobarEmpleado( int idEmpleado ) {
		
		Optional<Empleado> op = empleadoRepo.findById( idEmpleado );
		
		if( op.isPresent() ) return true;
		else return false;
		
	}

	@Override
	public boolean crearEmpleadao( Empleado empleado ) {
		
		List<Empleado> listaEmpleado = empleadoRepo.findAll();
		
		if( listaEmpleado.contains( empleado ) ) {
			return false;
		} else {
			try {
				empleadoRepo.save( empleado );
				return true;
			} catch( Exception e ) {
				e.printStackTrace();
				return false;
			}
		}
		
	}

	@Override
	public boolean eliminarEmpleado( Empleado empleado ) {
		
		try {
			empleadoRepo.delete( empleado );
			return true;
		} catch( Exception e ) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean editarEmpleado( Empleado empleado ) {
		
		try {
			empleadoRepo.save( empleado );
			return true;
		} catch( Exception e ) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public List<Empleado> buscarPorDepartamento( int idDepar ) {
		
		List<Empleado> listaEmpleadosFiltrada = empleadoRepo.buscarPorDepartamento( idDepar );
		return listaEmpleadosFiltrada;
		
	}

	@Override
	public List<Empleado> mostrarJefes() {
		
		List<Empleado> listaJefes = empleadoRepo.mostrarJefes();
		return listaJefes;
		
	}
	

}

















