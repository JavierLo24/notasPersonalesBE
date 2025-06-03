package com.practica.notasPersonales.controllers;

import com.practica.notasPersonales.entities.Notas;
import com.practica.notasPersonales.services.interfaces.INotasServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/notas")
public class NotasController {

    @Autowired
    INotasServicio iNotasServicio;

    @GetMapping()
    public ResponseEntity<List<Notas>> listarNotas() {
        return ResponseEntity.ok(iNotasServicio.listarNotas().stream().toList());
    }

    @PostMapping("/crear")
    public ResponseEntity<Notas> crearNota(@RequestBody Notas nota){
        return ResponseEntity.ok(iNotasServicio.crearNota(nota));
    }

    @PutMapping("/editar/{notaid}")
    public ResponseEntity<Notas> editarNota(@RequestBody Notas nota, @PathVariable("notaId") int notaId){
        return ResponseEntity.ok(iNotasServicio.editarNota(nota, notaId));
    }

    @DeleteMapping("/eliminar/{notaId}")
    public ResponseEntity<String> eliminarNota(@PathVariable("notaId") int notaId){
        iNotasServicio.eliminarNota(notaId);
        return ResponseEntity.ok("Nota Eliminada");
    }
}
