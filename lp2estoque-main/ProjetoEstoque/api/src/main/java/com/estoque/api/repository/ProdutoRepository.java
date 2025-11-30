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

    public Produto findById(Long id) {
        return bancoDeDados.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Produto save(Produto produto) {
        if (produto.getId() == null) {
            // Criar novo produto
            produto.setId(geradorId.getAndIncrement());
            bancoDeDados.add(produto);
        } else {
            // Atualizar produto existente
            Produto existente = findById(produto.getId());
            if (existente != null) {
                existente.setNome(produto.getNome());
                existente.setQuantidade(produto.getQuantidade());
                existente.setPreco(produto.getPreco());
            }
        }
        return produto;
    }

    public boolean deleteById(Long id) {
        return bancoDeDados.removeIf(p -> p.getId().equals(id));
    }
}
