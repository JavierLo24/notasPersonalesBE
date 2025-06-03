package com.practica.notasPersonales.services.implementations;

import com.practica.notasPersonales.entities.Etiqueta;
import com.practica.notasPersonales.repositories.EtiquetaRepositorio;
import com.practica.notasPersonales.services.interfaces.IEtiquetaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtiquetaServicio implements IEtiquetaServicio {

    @Autowired
    EtiquetaRepositorio etiquetaRepositorio;

    @Override
    public List<Etiqueta> listarEtiquetas() {
        return etiquetaRepositorio.findAll();
    }

    @Override
    public Etiqueta crearEtiqueta(Etiqueta etiqueta) {
        Etiqueta etiquetaCreada = etiquetaRepositorio.save(etiqueta);
        return etiquetaCreada;
    }

    @Override
    public Etiqueta editarEtiqueta(Etiqueta etiqueta, int etiquetaId) {
        Etiqueta etiquetaBuscada = etiquetaRepositorio.findById(etiquetaId).orElse(null);
        Etiqueta etiquetaPorBuscar = new Etiqueta();
        etiquetaPorBuscar.setId(etiquetaBuscada.getId());
        etiquetaPorBuscar.setEtiqueta(etiqueta.getEtiqueta());
        Etiqueta etiquetaEditada = etiquetaRepositorio.save(etiquetaPorBuscar);
        return etiquetaEditada;
    }

    @Override
    public void eliminarEtiqueta(int etiquetaId) {
        etiquetaRepositorio.deleteById(etiquetaId);
    }
}
