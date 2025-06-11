package com.practica.notasPersonales.services.implementations;

import com.practica.notasPersonales.entities.Etiqueta;
import com.practica.notasPersonales.entities.Nota;
import com.practica.notasPersonales.http.requests.NotaRequest;
import com.practica.notasPersonales.http.responses.EtiquetaResponse;
import com.practica.notasPersonales.http.responses.NotaResponse;
import com.practica.notasPersonales.repositories.EtiquetaRepositorio;
import com.practica.notasPersonales.repositories.NotaRepositorio;
import com.practica.notasPersonales.services.interfaces.INotasServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotaServicio implements INotasServicio {

    @Autowired
    NotaRepositorio notaRepositorio;

    @Autowired
    EtiquetaRepositorio etiquetaRepository;

    @Override
    public List<NotaResponse> listarNotas() {
        List<Nota> notaList = notaRepositorio.findAll();
        return notaList.stream().map(x ->
                NotaResponse.builder().
                        id(x.getId()).
                        title(x.getTitle()).
                        content(x.getContent()).
                        etiqueta(x.getEtiquetas().stream().map(y ->
                                y.getId()).
                                toList()).
                        build()).
                toList();
    }

    @Override
    public Nota crearNota(NotaRequest nota) {
        List<Etiqueta> etiquetaList = etiquetaRepository.findAllById(nota.getEtiquetasIds());
        Nota notaCreada = Nota.builder()
                .title(nota.getTitle())
                .content(nota.getContent())
                .etiquetas(etiquetaList)
                .dateCreated(LocalDateTime.now())
                .build();
        notaRepositorio.save(notaCreada);
        return notaCreada;
    }

    @Override
    public Nota editarNota(NotaRequest nota, int NotaId) {
        Nota notaBuscada = notaRepositorio.findById(NotaId).orElse(null);
        List<Etiqueta> etiquetaList = etiquetaRepository.findAllById(nota.getEtiquetasIds());
        Nota notaEditada = Nota.builder()
                .id(notaBuscada.getId())
                .title(nota.getTitle())
                .content(nota.getContent())
                .etiquetas(etiquetaList)
                .dateCreated(LocalDateTime.now())
                .build();
        notaRepositorio.save(notaEditada);
        return notaEditada;
    }

    @Override
    public void eliminarNota(int NotaId) {
        notaRepositorio.deleteById(NotaId);
    }

    @Override
    public NotaResponse buscarNota(int NotaId) {
        Nota notaBuscada = notaRepositorio.findById(NotaId).orElse(null);
        return NotaResponse.builder().
                id(notaBuscada.getId()).
                title(notaBuscada.getTitle()).
                content(notaBuscada.getContent()).
                etiqueta(notaBuscada.getEtiquetas().stream().map(x ->
                        x.getId()).
                        toList()).
                build();
    }
}
