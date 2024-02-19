package com.pruebascrudmicroservicios.dto;

import com.pruebascrudmicroservicios.entity.Aplicacion;

public class AplicacionDto {

	private Long id;
	private String nombre;
	
	public AplicacionDto () {
		
	}
	
	public AplicacionDto (Long id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	
	public AplicacionDto (Aplicacion aplicacion) {
		this.id = aplicacion.getId();
		this.nombre = aplicacion.getNombre();
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
	
	
}
