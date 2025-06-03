package com.practica.notasPersonales.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Entity
@NoArgsConstructor
@Builder
public class NotaEtiqueta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "notas_id")
    private Notas nota;

    @ManyToOne
    @JoinColumn(name = "etiqueta_id")
    private Etiqueta etiqueta_id;
}
