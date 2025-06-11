package com.practica.notasPersonales.http.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class NotaResponse {

    private int id;
    @JsonProperty("titulo")
    private String title;
    @JsonProperty("contenido")
    private String content;
    @JsonProperty("etiquetas")
    private List<Integer> etiqueta;
}
