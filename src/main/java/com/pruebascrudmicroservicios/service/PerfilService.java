package com.pruebascrudmicroservicios.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.pruebascrudmicroservicios.dto.AplicacionDto;
import com.pruebascrudmicroservicios.dto.PerfilDto;
import com.pruebascrudmicroservicios.entity.Aplicacion;
import com.pruebascrudmicroservicios.entity.Perfil;
import com.pruebascrudmicroservicios.exception.SqlException;
import com.pruebascrudmicroservicios.respository.PerfilRespository;

@Service
public class PerfilService {

	private PerfilRespository perfilRespository;
	
	public PerfilService (PerfilRespository perfilRespository) {
		this.perfilRespository = perfilRespository;
	}

	public List<PerfilDto> obtenerTodos() {
		List<Perfil> perfilesEntities = perfilRespository.findAll();
		List<PerfilDto> perfilesDtos = perfilesEntities.stream().
				map((entity) -> new PerfilDto (entity)).collect(Collectors.toList());
		
		return perfilesDtos;
	}

	public PerfilDto obtenerById(Long id) {
		Perfil perfil = perfilRespository.findById(id).orElse(new Perfil ());
		return new PerfilDto (perfil);
	}

	public PerfilDto guardar(PerfilDto perfilDto) {
		Perfil perfil = perfilRespository.save(new Perfil (perfilDto));
		return new PerfilDto (perfil);
	}

	public boolean borrar(PerfilDto perfilDto) throws SqlException {
		try {
			perfilRespository.delete(new Perfil (perfilDto));
		} catch (Exception e) {
			throw new SqlException ("Ha ocurrido un error en el borrado del perfil");
		}
		return true;
	}

	public PerfilDto actualizar(PerfilDto perfilDto) {
		Perfil perfil = perfilRespository.save(new Perfil (perfilDto));
		return new PerfilDto (perfil);
	}
}
