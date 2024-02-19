package com.pruebascrudmicroservicios.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.pruebascrudmicroservicios.dto.PerfilDto;
import com.pruebascrudmicroservicios.dto.UsuarioDto;
import com.pruebascrudmicroservicios.entity.Perfil;
import com.pruebascrudmicroservicios.entity.Usuario;
import com.pruebascrudmicroservicios.exception.SqlException;
import com.pruebascrudmicroservicios.respository.UsuarioRespository;

@Service
public class UsuarioService {

	private UsuarioRespository usuarioRespository;
	
	public UsuarioService (UsuarioRespository usuarioRespository) {
		this.usuarioRespository = usuarioRespository;
	}

	public List<UsuarioDto> obtenerTodos() {
		List<Usuario> usuarioEntities = usuarioRespository.findAll();
		List<UsuarioDto> usuariosDtos = usuarioEntities.stream().
				map((entity) -> new UsuarioDto (entity)).collect(Collectors.toList());
		
		return usuariosDtos;
	}

	public UsuarioDto obtenerById(Long id) {
		Usuario usuario = usuarioRespository.findById(id).orElse(new Usuario ());
		return new UsuarioDto (usuario);
	}

	public UsuarioDto guardar(UsuarioDto usuarioDto) {
		Usuario usuario = usuarioRespository.save(new Usuario (usuarioDto));
		return new UsuarioDto (usuario);
	}

	public boolean borrar(UsuarioDto usuarioDto) throws SqlException {
		try {
			usuarioRespository.delete(new Usuario (usuarioDto));
		} catch (Exception e) {
			throw new SqlException ("Ha ocurrido un error en el borrado del usuario");
		}
		return true;
	}

	public UsuarioDto actualizar(UsuarioDto usuarioDto) {
		Usuario usuario = usuarioRespository.save(new Usuario (usuarioDto));
		return new UsuarioDto (usuario);
	}
	
}
