package com.pruebascrudmicroservicios.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebascrudmicroservicios.entity.Perfil;

public interface PerfilRespository extends JpaRepository<Perfil, Long> {

}
