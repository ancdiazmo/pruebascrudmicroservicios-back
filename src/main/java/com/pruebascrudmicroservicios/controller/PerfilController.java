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
import com.pruebascrudmicroservicios.dto.PerfilDto;
import com.pruebascrudmicroservicios.exception.SqlException;
import com.pruebascrudmicroservicios.service.PerfilService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/perfil")
public class PerfilController {

	private PerfilService perfilService;
	
	@Autowired
	public PerfilController (PerfilService perfilService) {
		this.perfilService = perfilService;
	}

	@GetMapping
	public List<PerfilDto> obtenerTodos () {
		return perfilService.obtenerTodos();
	}
	
	@GetMapping("/{id}")
	public PerfilDto obtenerById (@PathVariable Long id) {
		return perfilService.obtenerById(id);
	}
	
	@PostMapping
	public PerfilDto guardar (@RequestBody PerfilDto perfilDto) {
		return perfilService.guardar(perfilDto);
	}
	
	@DeleteMapping("/{id}")
	public boolean borrar (@PathVariable Long id) throws SqlException {
		PerfilDto perfilDto = new PerfilDto ();
		perfilDto.setId(id);
		return perfilService.borrar(perfilDto);
	}
	
	@PutMapping
	public PerfilDto actualizar (@RequestBody PerfilDto perfilDto) {
		return perfilService.actualizar(perfilDto);
	}
	
	
}
