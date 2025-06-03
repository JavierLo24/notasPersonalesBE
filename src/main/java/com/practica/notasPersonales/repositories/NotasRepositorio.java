package com.practica.notasPersonales.repositories;

import com.practica.notasPersonales.entities.Notas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotasRepositorio extends JpaRepository<Notas, Integer> {
}
