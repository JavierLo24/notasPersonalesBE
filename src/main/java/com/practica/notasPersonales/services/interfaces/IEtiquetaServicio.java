package com.practica.notasPersonales.services.interfaces;

import com.practica.notasPersonales.entities.Etiqueta;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEtiquetaServicio {

    public List<Etiqueta> listarEtiquetas();

    public Etiqueta crearEtiqueta(Etiqueta etiqueta);

    public Etiqueta editarEtiqueta(Etiqueta etiqueta, int EtiquetaId);

    public void eliminarEtiqueta(int etiquetaId);
}
