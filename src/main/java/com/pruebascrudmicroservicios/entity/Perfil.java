package com.pruebascrudmicroservicios.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.pruebascrudmicroservicios.dto.PerfilDto;

@Entity
@Table(name = "PERFIL")
public class Perfil {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERFIL_ID_SEQ")
	@SequenceGenerator(name = "PERFIL_ID_SEQ", sequenceName = "PERFIL_ID_SEQ", allocationSize = 1)
	private Long id;
	
	@Column (name = "nombre")
	private String nombre;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_aplicacion")
	private Aplicacion aplicacion;
	
	public Perfil () { 
		
	}
	
	public Perfil (PerfilDto perfilDto) {
		this.id = perfilDto.getId();
		this.nombre = perfilDto.getNombre();
		this.aplicacion = perfilDto.getAplicacion();
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
		return "Perfil [id=" + id + ", nombre=" + nombre + ", aplicacion=" + aplicacion + ", getId()=" + getId()
				+ ", getNombre()=" + getNombre() + ", getAplicacion()=" + getAplicacion() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
