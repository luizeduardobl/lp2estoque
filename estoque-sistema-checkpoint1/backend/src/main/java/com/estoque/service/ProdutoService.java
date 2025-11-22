package com.estoque.service;

import com.estoque.model.Produto;
import com.estoque.repository.ProdutoRepository;

import java.util.List;

public class ProdutoService {
    private ProdutoRepository repo = new ProdutoRepository();

    public Produto cadastrar(String nome) {
        return repo.salvar(nome);
    }

    public List<Produto> listarTodos() {
        return repo.listar();
    }
}
