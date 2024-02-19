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

import com.pruebascrudmicroservicios.dto.UsuarioDto;

@Entity
@Table(name = "USUARIO")
public class Usuario {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUARIO_ID_SEQ")
	@SequenceGenerator(name = "USUARIO_ID_SEQ", sequenceName = "USUARIO_ID_SEQ", allocationSize = 1)
	private Long id;
	
	@Column (name = "nombre")
	private String nombre;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_perfil")
	private Perfil perfil;
	
	public Usuario () {
		
	}
	
	public Usuario (UsuarioDto usuarioDto) {
		this.id = usuarioDto.getId();
		this.nombre = usuarioDto.getNombre();
		this.perfil = usuarioDto.getPerfil();
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

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", perfil=" + perfil + ", getId()=" + getId()
				+ ", getNombre()=" + getNombre() + ", getPerfil()=" + getPerfil() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
