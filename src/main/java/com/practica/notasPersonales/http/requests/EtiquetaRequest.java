package com.practica.notasPersonales.http.requests;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EtiquetaRequest {

    private String etiqueta;
}
