package com.example.model.entityBeans;
import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;


@Entity
@Table(name="departamentos")
public class Departamento implements Serializable {
	
	
	// Atributos
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_depar")
	private int idDepar;

	private String direccion;

	private String nombre;

	//uni-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name="jefe_depar")
	private Empleado empleado;

	
	// Constructores
	
	
	public Departamento() {	}
	
	public Departamento(int idDepar, String direccion, String nombre, Empleado empleado) {
		super();
		this.idDepar = idDepar;
		this.direccion = direccion;
		this.nombre = nombre;
		this.empleado = empleado;
	}


	// Getters & Setters
	

	public int getIdDepar() {
		return this.idDepar;
	}

	public void setIdDepar(int idDepar) {
		this.idDepar = idDepar;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	
	// hashCode & equals
	
	
	@Override
	public int hashCode() {
		return Objects.hash(idDepar);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Departamento))
			return false;
		Departamento other = (Departamento) obj;
		return idDepar == other.idDepar;
	}
	
	
	// toString
	

	@Override
	public String toString() {
		return "Departamento [idDepar=" + idDepar + ", direccion=" + direccion + ", nombre=" + nombre + ", empleado="
				+ empleado + "]";
	}

	
}