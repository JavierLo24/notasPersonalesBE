package com.practica.notasPersonales.http.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HttpResponse {
    private Integer HttpStatusCode;
    private String reason;
}
