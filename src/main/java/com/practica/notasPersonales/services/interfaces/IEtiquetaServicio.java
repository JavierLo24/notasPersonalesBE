package com.practica.notasPersonales.services.interfaces;

import com.practica.notasPersonales.entities.Etiqueta;
import com.practica.notasPersonales.entities.Notas;

import java.util.List;

public interface IEtiquetaServicio {

    public List<Etiqueta> listarEtiquetas();

    public Etiqueta crearEtiqueta(Etiqueta etiqueta);

    public Etiqueta editarEtiqueta(Etiqueta etiqueta, int EtiquetaId);

    public void eliminarNota(int etiquetaId);
}
