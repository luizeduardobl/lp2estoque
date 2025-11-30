package com.estoque.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // O Lombok cria os Getters e Setters automaticamente
@AllArgsConstructor
@NoArgsConstructor
public class Produto {
    private Long id;
    private String nome;
    private Integer quantidade;
    private Double preco;
}