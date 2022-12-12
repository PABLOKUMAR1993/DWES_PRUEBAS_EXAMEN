package com.example.model.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.model.entityBeans.Perfile;
import com.example.repository.PerfileRepository;


@Repository
public class PerfileDaoImpl implements PerfileDaoInt {

	
	// Atributos.
	
	
	@Autowired
	private PerfileRepository perfilRepo;
	
	
	// Métodos.
	
	
	@Override
	public List<Perfile> buscarTodos() { return perfilRepo.findAll(); }


	@Override
	public Perfile buscarUno(int idPerfil) { return perfilRepo.findById( idPerfil ).orElse( null ); }


	@Override
	public boolean crearPerfil(Perfile perfil) { //No funciona bien, si coinciden datos, modifica.
		
		List<Perfile> listaPerfiles = perfilRepo.findAll();
		
		if( listaPerfiles.contains( perfil ) ) { return false; }
		else {
			try {
				perfilRepo.save( perfil );
				return true;
			} catch( Exception e ) {
				e.printStackTrace();
				return false;
			}
		}
		
	}


	@Override
	public boolean eliminarPerfil(Perfile perfil) {
		
		try {
			perfilRepo.delete( perfil );
			return true;
		} catch( Exception e ) {
			e.printStackTrace();
			return false;
		}
		
	}

	
}
