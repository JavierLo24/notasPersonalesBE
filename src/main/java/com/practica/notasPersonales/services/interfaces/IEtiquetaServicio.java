package com.practica.notasPersonales.services.interfaces;

import com.practica.notasPersonales.entities.Etiqueta;
import com.practica.notasPersonales.http.responses.EtiquetaResponse;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEtiquetaServicio {

    public List<EtiquetaResponse> listarEtiquetas();

    public EtiquetaResponse buscarEtiqueta(int EtiquetaId);

    public Etiqueta crearEtiqueta(Etiqueta etiqueta) throws RuntimeException;

    public Etiqueta editarEtiqueta(Etiqueta etiqueta, int EtiquetaId);

    public void eliminarEtiqueta(int etiquetaId);
}
