package com.practica.notasPersonales.repositories;

import com.practica.notasPersonales.entities.NotaEtiqueta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaEtiquetaRepositorio extends JpaRepository<NotaEtiqueta, Repository> {
}
