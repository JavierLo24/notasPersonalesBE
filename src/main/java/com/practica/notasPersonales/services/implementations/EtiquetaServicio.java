package com.practica.notasPersonales.services.implementations;

import com.practica.notasPersonales.entities.Etiqueta;
import com.practica.notasPersonales.http.responses.EtiquetaResponse;
import com.practica.notasPersonales.repositories.EtiquetaRepositorio;
import com.practica.notasPersonales.services.interfaces.IEtiquetaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class EtiquetaServicio implements IEtiquetaServicio {

    @Autowired
    EtiquetaRepositorio etiquetaRepositorio;

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

    @Override
    public EtiquetaResponse buscarEtiqueta(int EtiquetaId) {
        Etiqueta etiquetaBuscada = etiquetaRepositorio.findById(EtiquetaId).orElse(null);
        return EtiquetaResponse.builder()
                .id(etiquetaBuscada.getId())
                .etiqueta(etiquetaBuscada.getEtiqueta())
                .build();
    }
}
