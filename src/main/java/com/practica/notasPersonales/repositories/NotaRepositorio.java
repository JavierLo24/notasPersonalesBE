package com.practica.notasPersonales.repositories;

import com.practica.notasPersonales.entities.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaRepositorio extends JpaRepository<Nota, Integer> {
}
