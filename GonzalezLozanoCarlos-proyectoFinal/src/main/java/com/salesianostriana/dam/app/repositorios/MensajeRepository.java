package com.salesianostriana.dam.app.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianostriana.dam.app.entidades.Mensaje;

@Repository
public interface MensajeRepository extends JpaRepository<Mensaje, Long> {

}
