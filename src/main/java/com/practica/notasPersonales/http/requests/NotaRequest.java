package com.practica.notasPersonales.http.requests;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class NotaRequest {

    private String title;
    private String content;
    private List<Integer> etiquetasIds;
}
