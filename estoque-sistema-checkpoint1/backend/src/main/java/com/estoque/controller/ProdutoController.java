package com.estoque.controller;

import com.estoque.model.Produto;
import com.estoque.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private ProdutoService service = new ProdutoService();

    @PostMapping
    public Produto criar(@RequestParam String nome) {
        return service.cadastrar(nome);
    }

    @GetMapping
    public List<Produto> listar() {
        return service.listarTodos();
    }
}
