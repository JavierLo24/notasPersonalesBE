package com.practica.notasPersonales.controllers;

import com.practica.notasPersonales.http.requests.NotaRequest;
import com.practica.notasPersonales.http.responses.HttpResponse;
import com.practica.notasPersonales.http.responses.NotaResponse;
import com.practica.notasPersonales.services.interfaces.INotasServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notas")
public class NotaController {

    @Autowired
    INotasServicio iNotasServicio;

    @GetMapping()
    public ResponseEntity<List<NotaResponse>> listarNotas() {
        return ResponseEntity.ok(iNotasServicio.listarNotas().stream().toList());
    }

    @GetMapping("/{notaId}")
    public ResponseEntity<NotaResponse> buscarNota(@PathVariable("notaId") int notaId){
        return ResponseEntity.ok(iNotasServicio.buscarNota(notaId));
    }

    @PostMapping("/crear")
    public ResponseEntity<HttpResponse> crearNota(@RequestBody NotaRequest nota){
        iNotasServicio.crearNota(nota);
        return new ResponseEntity<>(new HttpResponse(HttpStatus.OK.value(), "Nota creada correctamente"), HttpStatus.OK);
    }

    @PutMapping("/editar/{notaId}")
    public ResponseEntity<HttpResponse> editarNota(@PathVariable Integer notaId, @RequestBody NotaRequest nota){
        return new ResponseEntity<>(new HttpResponse(HttpStatus.OK.value(), "Nota editada correctamente"), HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{notaId}")
    public ResponseEntity<String> eliminarNota(@PathVariable("notaId") int notaId){
        iNotasServicio.eliminarNota(notaId);
        return ResponseEntity.ok("Nota Eliminada");
    }
}
