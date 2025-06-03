package com.practica.notasPersonales.services.implementations;

import com.practica.notasPersonales.entities.Etiqueta;
import com.practica.notasPersonales.repositories.EtiquetaRepositorio;
import com.practica.notasPersonales.services.interfaces.IEtiquetaServicio;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

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
        Optional<Etiqueta> etiquetaBuscada = etiquetaRepositorio.findById(etiquetaId);
        BeanUtils.copyProperties(etiqueta, etiquetaBuscada);
        Etiqueta etiquetaEditada = etiquetaRepositorio.save(etiqueta);
        return etiquetaEditada;
    }

    @Override
    public void eliminarNota(int etiquetaId) {
        etiquetaRepositorio.deleteById(etiquetaId);
    }
}
