package com.practica.notasPersonales.http.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.practica.notasPersonales.entities.Etiqueta;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class NotaResponse {

    private int id;
    @JsonProperty("Título")
    private String title;
    @JsonProperty("Contenido")
    private String content;
    @JsonProperty("Etiquetas")
    private List<EtiquetaResponse> etiqueta;
}
