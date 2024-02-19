package com.pruebascrudmicroservicios.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebascrudmicroservicios.entity.Usuario;

public interface UsuarioRespository extends JpaRepository<Usuario, Long>{

}
