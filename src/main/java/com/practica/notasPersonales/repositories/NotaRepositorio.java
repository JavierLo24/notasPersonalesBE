package com.practica.notasPersonales.repositories;

import com.practica.notasPersonales.entities.Etiqueta;
import com.practica.notasPersonales.entities.Nota;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaRepositorio extends JpaRepository<Nota, Integer> {

    List<Nota> findAllByEtiquetasContaining(Etiqueta etiqueta);
}
