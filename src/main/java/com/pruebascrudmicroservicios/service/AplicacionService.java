package com.pruebascrudmicroservicios.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.pruebascrudmicroservicios.dto.AplicacionDto;
import com.pruebascrudmicroservicios.entity.Aplicacion;
import com.pruebascrudmicroservicios.exception.SqlException;
import com.pruebascrudmicroservicios.respository.AplicacionRespository;

@Service
public class AplicacionService {
	
	private AplicacionRespository aplicacionRespository;
	
	public AplicacionService (AplicacionRespository aplicacionRespository) {
		this.aplicacionRespository = aplicacionRespository;
	}

	public List<AplicacionDto> obtenerTodos() {
		
		List<Aplicacion> aplicacionesEntities = aplicacionRespository.findAll();
		List<AplicacionDto> aplicacionesDtos = aplicacionesEntities.stream().
				map((entity) -> new AplicacionDto (entity)).collect(Collectors.toList());
		
		return aplicacionesDtos;
	}

	public AplicacionDto obtenerById(Long id) {
		Aplicacion aplicacion = aplicacionRespository.findById(id).orElse(new Aplicacion ());
		return new AplicacionDto (aplicacion);
	}
	
	public AplicacionDto guardar(AplicacionDto aplicacionDto) {
		Aplicacion aplicacion = aplicacionRespository.save(new Aplicacion (aplicacionDto));
		return new AplicacionDto (aplicacion);
	}

	public boolean borrar(AplicacionDto aplicacionDto) throws SqlException {
		try {
			aplicacionRespository.delete(new Aplicacion (aplicacionDto));
		} catch (Exception e) {
			throw new SqlException ("Ha ocurrido un error en el borrado de la aplicacion");
		}
		return true;
	}

	public AplicacionDto actualizar(AplicacionDto aplicacionDto) {
		Aplicacion aplicacion = aplicacionRespository.save(new Aplicacion (aplicacionDto));
		return new AplicacionDto (aplicacion);
	}
}
