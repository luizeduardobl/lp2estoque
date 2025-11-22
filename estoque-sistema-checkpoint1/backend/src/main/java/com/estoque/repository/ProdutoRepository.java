package com.estoque.repository;

import com.estoque.model.Produto;
import java.util.ArrayList;
import java.util.List;

public class ProdutoRepository {
    private static List<Produto> produtos = new ArrayList<>();
    private static int idCounter = 1;

    public Produto salvar(String nome) {
        Produto p = new Produto(idCounter++, nome);
        produtos.add(p);
        return p;
    }

    public List<Produto> listar() {
        return produtos;
    }
}
