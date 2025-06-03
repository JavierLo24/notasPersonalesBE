package com.practica.notasPersonales.services.interfaces;

import com.practica.notasPersonales.entities.Notas;

import java.util.List;

public interface INotasServicio {

    public List<Notas> listarNotas();

    public Notas crearNota(Notas nota);

    public Notas editarNota(Notas nota);

    public void eliminarNota(int idNota);
}
