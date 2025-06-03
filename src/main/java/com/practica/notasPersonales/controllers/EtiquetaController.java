package com.practica.notasPersonales.controllers;

import com.practica.notasPersonales.entities.Etiqueta;
import com.practica.notasPersonales.entities.Notas;
import com.practica.notasPersonales.services.interfaces.IEtiquetaServicio;
import com.practica.notasPersonales.services.interfaces.INotasServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etiqueta")
public class EtiquetaController {

    @Autowired
    IEtiquetaServicio iEtiquetaServicio;

    @GetMapping()
    public ResponseEntity<List<Etiqueta>> listarEtiquetas() {
        return ResponseEntity.ok(iEtiquetaServicio.listarEtiquetas().stream().toList());
    }

    @PostMapping("/crear")
    public ResponseEntity<Etiqueta> crearEtiqueta(@RequestBody Etiqueta etiqueta){
        return ResponseEntity.ok(iEtiquetaServicio.crearEtiqueta(etiqueta));
    }

    @PutMapping("/editar/{etiquetaId}")
    public ResponseEntity<Etiqueta> editarEtiqueta(@PathVariable("etiquetaId") Integer etiquetaId, @RequestBody Etiqueta etiqueta){
        return ResponseEntity.ok(iEtiquetaServicio.editarEtiqueta(etiqueta, etiquetaId));
    }

    @DeleteMapping("/eliminar/{etiquetaId}")
    public ResponseEntity<String> eliminarNota(@PathVariable("etiquetaId") int etiquetaId){
        iEtiquetaServicio.eliminarEtiqueta(etiquetaId);
        return ResponseEntity.ok("Nota Eliminada");
    }
}
