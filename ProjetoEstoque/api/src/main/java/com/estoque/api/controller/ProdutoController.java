package com.estoque.api.controller;

import com.estoque.api.model.Produto;
import com.estoque.api.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoRepository repository;

    public ProdutoController(ProdutoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Produto> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PostMapping
    public Produto criar(@RequestBody Produto produto) {
        return repository.save(produto);
    }

    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Long id, @RequestBody Produto dados) {
        Produto produto = repository.findById(id);

        if (produto == null) {
            return null;
        }

        produto.setNome(dados.getNome());
        produto.setQuantidade(dados.getQuantidade());
        produto.setPreco(dados.getPreco());
        
        return repository.save(produto);
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Long id) {
        boolean removido = repository.deleteById(id);
        return removido ? "Produto removido." : "Produto não encontrado.";
    }
}
