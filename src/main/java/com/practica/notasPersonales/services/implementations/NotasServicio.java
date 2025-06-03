package com.practica.notasPersonales.services.implementations;

import com.practica.notasPersonales.entities.Notas;
import com.practica.notasPersonales.services.interfaces.INotasServicio;

import java.util.List;

public class NotasServicio implements INotasServicio {
    @Override
    public List<Notas> listarNotas() {
        return List.of();
    }

    @Override
    public Notas crearNota(Notas nota) {
        return null;
    }

    @Override
    public Notas editarNota(Notas nota) {
        return null;
    }

    @Override
    public void eliminarNota(int idNota) {

    }
}
