package com.pruebascrudmicroservicios.dto;

import com.pruebascrudmicroservicios.entity.Perfil;
import com.pruebascrudmicroservicios.entity.Usuario;

public class UsuarioDto {

	private Long id;
	private String nombre;
	private Perfil perfil;
	
	public UsuarioDto () {
		
	}
	
	public UsuarioDto (Long id, String nombre, Perfil perfil) {
		this.id = id;
		this.nombre = nombre;
		this.perfil = perfil;
	}
	
	public UsuarioDto (Usuario usuario) {
		this.id = usuario.getId();
		this.nombre = usuario.getNombre();
		this.perfil = usuario.getPerfil();
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
		return "UsuarioDto [id=" + id + ", nombre=" + nombre + ", perfil=" + perfil + ", getId()=" + getId()
				+ ", getNombre()=" + getNombre() + ", getPerfil()=" + getPerfil() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
