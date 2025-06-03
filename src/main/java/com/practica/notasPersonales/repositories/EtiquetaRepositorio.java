package com.practica.notasPersonales.repositories;

import com.practica.notasPersonales.entities.Etiqueta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtiquetaRepositorio extends JpaRepository<Etiqueta, Integer> {
}
