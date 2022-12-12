package com.example.model.dao;
import java.util.List;
import com.example.model.entityBeans.Perfile;


public interface PerfileDaoInt {
	
	List<Perfile> buscarTodos();
	Perfile buscarUno( int idPerfil );
	boolean crearPerfil( Perfile perfil );
	boolean eliminarPerfil( Perfile perfil );

}
