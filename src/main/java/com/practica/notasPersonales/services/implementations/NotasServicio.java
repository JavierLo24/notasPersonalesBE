package com.practica.notasPersonales.services.implementations;

import com.practica.notasPersonales.entities.Notas;
import com.practica.notasPersonales.repositories.NotasRepositorio;
import com.practica.notasPersonales.services.interfaces.INotasServicio;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotasServicio implements INotasServicio {

    @Autowired
    NotasRepositorio notasRepositorio;

    @Override
    public List<Notas> listarNotas() {
        return notasRepositorio.findAll();
    }

    @Override
    public Notas crearNota(Notas nota) {
        Notas notaCreada = notasRepositorio.save(nota);
        return notaCreada;
    }

    @Override
    public Notas editarNota(Notas nota, int NotaId) {
        Notas notaBuscada = notasRepositorio.findById(NotaId).orElse(null);
        Notas notaPorEditar = new Notas();
        notaPorEditar.setId(notaBuscada.getId());
        notaPorEditar.setTitle(nota.getTitle());
        notaPorEditar.setContent(nota.getContent());
        Notas notaEditada = notasRepositorio.save(notaPorEditar);
        return notaEditada;
    }

    @Override
    public void eliminarNota(int NotaId) {
        notasRepositorio.deleteById(NotaId);
    }
}
