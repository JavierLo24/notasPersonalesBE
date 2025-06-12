package com.practica.notasPersonales.controllers;

import com.practica.notasPersonales.entities.Etiqueta;
import com.practica.notasPersonales.http.responses.EtiquetaResponse;
import com.practica.notasPersonales.http.responses.HttpResponse;
import com.practica.notasPersonales.services.interfaces.IEtiquetaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etiqueta")
public class EtiquetaController {

    @Autowired
    IEtiquetaServicio iEtiquetaServicio;

    @GetMapping()
    public ResponseEntity<List<EtiquetaResponse>> listarEtiquetas() {
        return ResponseEntity.ok(iEtiquetaServicio.listarEtiquetas().stream().toList());
    }

    @GetMapping("/{etiquetaId}")
    public ResponseEntity<EtiquetaResponse> buscarEtiqueta(@PathVariable("etiquetaId") int etiquetaId){
        return ResponseEntity.ok(iEtiquetaServicio.buscarEtiqueta(etiquetaId));
    }

    @PostMapping("/crear")
    public ResponseEntity<HttpResponse> crearEtiqueta(@RequestBody Etiqueta etiqueta) throws RuntimeException{
        iEtiquetaServicio.crearEtiqueta(etiqueta);
        return new ResponseEntity<>(new HttpResponse(HttpStatus.OK.value(), "Etiqueta creada correctamente"), HttpStatus.OK);
    }

    @PutMapping("/editar/{etiquetaId}")
    public ResponseEntity<HttpResponse> editarEtiqueta(@PathVariable("etiquetaId") Integer etiquetaId, @RequestBody Etiqueta etiqueta){
        iEtiquetaServicio.editarEtiqueta(etiqueta, etiquetaId);
        return new ResponseEntity<>(new HttpResponse(HttpStatus.OK.value(), "Etiqueta editada correctamente"), HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{etiquetaId}")
    public ResponseEntity<HttpResponse> eliminarNota(@PathVariable("etiquetaId") int etiquetaId){
        iEtiquetaServicio.eliminarEtiqueta(etiquetaId);
        return new ResponseEntity<>(new HttpResponse(HttpStatus.OK.value(), "Etiqueta eliminada correctamente"), HttpStatus.OK);
    }
}
