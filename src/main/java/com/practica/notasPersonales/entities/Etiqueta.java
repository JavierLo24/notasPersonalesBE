package com.practica.notasPersonales.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Entity
@NoArgsConstructor
@Builder
@Data
public class Etiqueta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String etiqueta;

    @ManyToMany(mappedBy = "etiquetas") //Es para la relación muchos a muchos sin mas data en la tabla intermedia, salvo los id's
    private List<Nota> notaList;
}
