package com.practica.notasPersonales.services.implementations;

import com.practica.notasPersonales.entities.Etiqueta;
import com.practica.notasPersonales.entities.Nota;
import com.practica.notasPersonales.http.responses.EtiquetaResponse;
import com.practica.notasPersonales.repositories.EtiquetaRepositorio;
import com.practica.notasPersonales.repositories.NotaRepositorio;
import com.practica.notasPersonales.services.interfaces.IEtiquetaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtiquetaServicio implements IEtiquetaServicio {

    @Autowired
    EtiquetaRepositorio etiquetaRepositorio;

    @Autowired
    NotaRepositorio notaRepositorio;

    @Override
    public List<EtiquetaResponse> listarEtiquetas() {
        List<Etiqueta> etiquetaList = etiquetaRepositorio.findAll();
        return etiquetaList.stream().map(x -> EtiquetaResponse.builder()
                        .id(x.getId())
                        .etiqueta(x.getEtiqueta())
                .build())
                .toList();
    }

    @Override
    public Etiqueta crearEtiqueta(Etiqueta etiqueta) throws RuntimeException{
        Etiqueta etiquetaCreada;
            if(etiquetaRepositorio.findByEtiqueta(etiqueta.getEtiqueta()) == null){
                etiquetaCreada = etiquetaRepositorio.save(etiqueta);
                return etiquetaCreada;
            } else {
                throw new RuntimeException("Etiqueta registrada anteriormente");
            }
    }

    @Override
    public Etiqueta editarEtiqueta(Etiqueta etiqueta, int etiquetaId) {
        Etiqueta etiquetaBuscada = etiquetaRepositorio.findById(etiquetaId).orElse(null);
        if (etiquetaBuscada == null) {
            throw new RuntimeException("Etiqueta no encontrada");
        }
        Etiqueta etiquetaPorBuscar = new Etiqueta();
        etiquetaPorBuscar.setId(etiquetaBuscada.getId());
        etiquetaPorBuscar.setEtiqueta(etiqueta.getEtiqueta());
        Etiqueta etiquetaEditada = etiquetaRepositorio.save(etiquetaPorBuscar);
        return etiquetaEditada;
    }

    @Override
    public void eliminarEtiqueta(int etiquetaId) {
        Etiqueta etiqueta = etiquetaRepositorio.findById(etiquetaId).orElse(null);
    if (etiqueta != null) {
        List<Nota> notasConEtiqueta = notaRepositorio.findAllByEtiquetasContaining(etiqueta);
        for (Nota nota : notasConEtiqueta) {
            nota.getEtiquetas().remove(etiqueta);
            notaRepositorio.save(nota);
        }
        etiquetaRepositorio.deleteById(etiquetaId);
        } else {
            throw new RuntimeException("Etiqueta no encontrada");
        }
    }

    @Override
    public EtiquetaResponse buscarEtiqueta(int EtiquetaId) {
        Etiqueta etiquetaBuscada = etiquetaRepositorio.findById(EtiquetaId).orElse(null);
        if (etiquetaBuscada == null) {
            throw new RuntimeException("Etiqueta no encontrada");
        }
        return EtiquetaResponse.builder()
                .id(etiquetaBuscada.getId())
                .etiqueta(etiquetaBuscada.getEtiqueta())
                .build();
    }
}
