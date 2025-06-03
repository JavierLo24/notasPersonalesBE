package com.practica.notasPersonales.services.interfaces;

import com.practica.notasPersonales.entities.Notas;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface INotasServicio {

    public List<Notas> listarNotas();

    public Notas crearNota(Notas nota);

    public Notas editarNota(Notas nota, int NotaId);

    public void eliminarNota(int NotaId);
}
