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

import com.pruebascrudmicroservicios.dto.PerfilDto;
import com.pruebascrudmicroservicios.dto.UsuarioDto;
import com.pruebascrudmicroservicios.exception.SqlException;
import com.pruebascrudmicroservicios.service.UsuarioService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/usuario")
public class UsuariolController {
	
	private UsuarioService usuarioService;
	
	@Autowired
	public UsuariolController (UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@GetMapping
	public List<UsuarioDto> obtenerTodos () {
		return usuarioService.obtenerTodos();
	}
	
	@GetMapping("/{id}")
	public UsuarioDto obtenerById (@PathVariable Long id) {
		return usuarioService.obtenerById(id);
	}
	
	@PostMapping
	public UsuarioDto guardar (@RequestBody UsuarioDto usuarioDto) {
		return usuarioService.guardar(usuarioDto);
	}
	
	@DeleteMapping("/{id}")
	public boolean borrar (@PathVariable Long id) throws SqlException {
		UsuarioDto usuarioDto = new UsuarioDto ();
		usuarioDto.setId(id);
		return usuarioService.borrar(usuarioDto);
	}
	
	@PutMapping
	public UsuarioDto actualizar (@RequestBody UsuarioDto usuarioDto) {
		return usuarioService.actualizar(usuarioDto);
	}

}
