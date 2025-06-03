package com.practica.notasPersonales.services.implementations;

import com.practica.notasPersonales.entities.Etiqueta;
import com.practica.notasPersonales.services.interfaces.IEtiquetaServicio;

import java.util.List;

public class EtiquetaServicio implements IEtiquetaServicio {
    @Override
    public List<Etiqueta> listarEtiquetas() {
        return List.of();
    }

    @Override
    public Etiqueta crearEtiqueta(Etiqueta etiqueta) {
        return null;
    }

    @Override
    public Etiqueta editarEtiqueta(Etiqueta etiqueta) {
        return null;
    }

    @Override
    public void eliminarNota(int idEtiqueta) {

    }
}
