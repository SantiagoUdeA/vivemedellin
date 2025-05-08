package com.vivemedellin.valoracion_comentarios.category.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoryDTO {

    private Long id;
    private String name;
    private String description;
}
