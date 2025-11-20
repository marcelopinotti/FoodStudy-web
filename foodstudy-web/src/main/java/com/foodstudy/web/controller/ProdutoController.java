package com.foodstudy.web.controller;

import com.foodstudy.web.model.Produto;
import com.foodstudy.web.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    // 1. Listar todos os produtos
    @GetMapping
    public List<Produto> listar() {
        return produtoService.listarTodos();
    }

    // 2. Buscar produto por ID
    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable Long id) {
        return produtoService.buscarPorId(id);
    }

    // 3. Cadastrar produto
    @PostMapping
    public Produto cadastrar(@RequestBody Produto produto) {
        return produtoService.salvar(produto);
    }

    // 4. Atualizar produto
    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Long id, @RequestBody Produto dados) {
        return produtoService.atualizar(id, dados);
    }

    // 5. Deletar produto
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        produtoService.deletar(id);
    }
}
