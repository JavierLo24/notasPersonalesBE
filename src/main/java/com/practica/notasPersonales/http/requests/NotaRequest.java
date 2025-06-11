package com.practica.notasPersonales.http.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotaRequest {

    private String title;
    private String content;
    private List<Integer> etiquetasIds;
}
