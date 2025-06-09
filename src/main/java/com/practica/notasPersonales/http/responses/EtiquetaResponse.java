package com.practica.notasPersonales.http.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class EtiquetaResponse {

    private int id;
    @JsonProperty("etiqueta")
    private String etiqueta;
}
