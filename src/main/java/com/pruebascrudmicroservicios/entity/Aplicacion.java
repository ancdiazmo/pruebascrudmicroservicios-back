package com.pruebascrudmicroservicios.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.pruebascrudmicroservicios.dto.AplicacionDto;

@Entity
@Table(name = "APLICACION")
public class Aplicacion {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APLICACION_ID_SEQ")
	@SequenceGenerator(name = "APLICACION_ID_SEQ", sequenceName = "APLICACION_ID_SEQ", allocationSize = 1)
	private Long id;
	
	@Column (name = "nombre")
	private String nombre;
	
	public Aplicacion () {
		
	}
	
	public Aplicacion (AplicacionDto aplicacionDto) {
		this.id = aplicacionDto.getId();
		this.nombre = aplicacionDto.getNombre();
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

	@Override
	public String toString() {
		return "Aplicacion [id=" + id + ", nombre=" + nombre + ", getId()=" + getId() + ", getNombre()=" + getNombre()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
}
