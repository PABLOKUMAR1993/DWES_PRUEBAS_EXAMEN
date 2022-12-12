package com.example.model.dao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.model.entityBeans.Departamento;
import com.example.repository.DepartamentoRepository;


@Repository
public class DepartamentoDaoImpl implements DepartamentoDaoInt {

	
	// Atributos.
	
	
	@Autowired
	private DepartamentoRepository departamentoRepo;
	
	
	// Métodos.
	
	
	@Override
	public List<Departamento> buscarTodos() { return departamentoRepo.findAll(); }

	@Override
	public Departamento buscarUno( int idDepar ) { return departamentoRepo.findById( idDepar ).orElse( null ); }

	@Override
	public boolean crearDepartamento( Departamento departamento ) {
		
		List<Departamento> listaDepartamentos = departamentoRepo.findAll();
		
		if( listaDepartamentos.contains( departamento ) ) {
			return false;
		} else {
			try {
				departamentoRepo.save( departamento );
				return true;
			} catch( Exception e ) {
				e.printStackTrace();
				return false;
			}
		}
		
	}

	@Override
	public boolean eliminarDepartamento( Departamento departamento ) {
		
		try {
			departamentoRepo.delete( departamento );
			return true;
		} catch( Exception e ) {
			e.printStackTrace();
			return false;
		}
		
	}

	
}
