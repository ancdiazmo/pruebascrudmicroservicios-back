package com.pruebascrudmicroservicios.dto;

import com.pruebascrudmicroservicios.entity.Aplicacion;
import com.pruebascrudmicroservicios.entity.Perfil;

public class PerfilDto {

	private Long id;
	private String nombre;
	private Aplicacion aplicacion;
	
	public PerfilDto () {
		
	}
	
	public PerfilDto (Long id, String nombre, Aplicacion aplicacion) {
		this.id = id;
		this.nombre = nombre;
		this.aplicacion = aplicacion;
	}
	
	public PerfilDto (Perfil perfil) {
		this.id = perfil.getId();
		this.nombre = perfil.getNombre();
		this.aplicacion = perfil.getAplicacion();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Aplicacion getAplicacion() {
		return aplicacion;
	}

	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}

	@Override
	public String toString() {
		return "PerfilDto [id=" + id + ", nombre=" + nombre + ", aplicacion=" + aplicacion + ", getId()=" + getId()
				+ ", getNombre()=" + getNombre() + ", getAplicacion()=" + getAplicacion() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
