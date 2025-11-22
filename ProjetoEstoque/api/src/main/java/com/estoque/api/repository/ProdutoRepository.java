package com.estoque.api.repository;

import com.estoque.api.model.Produto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ProdutoRepository {
    private final List<Produto> bancoDeDados = new ArrayList<>();
    private final AtomicLong geradorId = new AtomicLong(1);

    public List<Produto> findAll() {
        return bancoDeDados;
    }

    public Produto save(Produto produto) {
        if (produto.getId() == null) {
            produto.setId(geradorId.getAndIncrement());
        }
        bancoDeDados.add(produto);
        return produto;
    }
}