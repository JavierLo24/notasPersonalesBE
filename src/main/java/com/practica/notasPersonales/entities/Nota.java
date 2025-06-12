package com.practica.notasPersonales.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Entity
@NoArgsConstructor
@Builder
@Data
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Título")
    private String title;

    @Column(name = "Contenido")
    private String content;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }) //Es para la relación muchos a muchos sin mas data en la tabla intermedia, salvo los id's
    @JoinTable(
            name = "nota_etiqueta",
            joinColumns = @JoinColumn(name = "nota_id"),
            inverseJoinColumns = @JoinColumn(name = "etiqueta_id")
    ) //Se indica el nombre de la tabla y las tablas involucradas, esto con tal de poder dejar lista en las foráneas
    private List<Etiqueta> etiquetas;

    @Column(name = "Fecha_Creación")
    private LocalDateTime dateCreated;
}
