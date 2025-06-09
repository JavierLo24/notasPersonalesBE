package com.practica.notasPersonales.services.interfaces;

import com.practica.notasPersonales.entities.Nota;
import com.practica.notasPersonales.http.requests.NotaRequest;
import com.practica.notasPersonales.http.responses.NotaResponse;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface INotasServicio {

    public List<NotaResponse> listarNotas();

    public NotaResponse buscarNota(int NotaId);

    public Nota crearNota(NotaRequest nota);

    public Nota editarNota(NotaRequest nota, int NotaId);

    public void eliminarNota(int NotaId);
}
