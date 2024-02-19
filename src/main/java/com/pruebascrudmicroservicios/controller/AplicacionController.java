package com.pruebascrudmicroservicios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebascrudmicroservicios.dto.AplicacionDto;
import com.pruebascrudmicroservicios.exception.SqlException;
import com.pruebascrudmicroservicios.service.AplicacionService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/aplicacion")
public class AplicacionController {
	
	private AplicacionService aplicacionService;
	
	@Autowired
	public AplicacionController (AplicacionService aplicacionService) {
		this.aplicacionService = aplicacionService;
	}

	@GetMapping
	public List<AplicacionDto> obtenerTodos () {
		return aplicacionService.obtenerTodos();
	}
	
	@GetMapping("/{id}")
	public AplicacionDto obtenerById (@PathVariable Long id) {
		return aplicacionService.obtenerById(id);
	}
	
	@PostMapping
	public AplicacionDto guardar (@RequestBody AplicacionDto aplicacionDto) {
		return aplicacionService.guardar(aplicacionDto);
	}
	
	@DeleteMapping("/{id}")
	public boolean borrar (@PathVariable Long id) throws SqlException {
		AplicacionDto aplicacionDto = new AplicacionDto ();
		aplicacionDto.setId(id);
		return aplicacionService.borrar(aplicacionDto);
	}
	
	@PutMapping
	public AplicacionDto actualizar (@RequestBody AplicacionDto aplicacionDto) {
		return aplicacionService.actualizar(aplicacionDto);
	}
	
}
