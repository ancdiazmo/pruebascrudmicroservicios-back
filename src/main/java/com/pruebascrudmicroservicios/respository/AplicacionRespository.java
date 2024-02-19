package com.pruebascrudmicroservicios.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebascrudmicroservicios.entity.Aplicacion;

public interface AplicacionRespository extends JpaRepository<Aplicacion, Long>{

}
