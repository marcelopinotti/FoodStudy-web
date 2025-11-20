package com.foodstudy.web.controller;

import com.foodstudy.web.model.Estabelecimento;
import com.foodstudy.web.model.Produto;
import com.foodstudy.web.service.EstabelecimentoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estabelecimentos")
public class EstabelecimentoController {

    private final EstabelecimentoService estabelecimentoService;

    public EstabelecimentoController(EstabelecimentoService estabelecimentoService) {
        this.estabelecimentoService = estabelecimentoService;
    }

    // 1. Listar estabelecimentos
    @GetMapping
    public List<Estabelecimento> listar() {
        return estabelecimentoService.listarTodos();
    }

    // 2. Buscar estabelecimento por ID
    @GetMapping("/{id}")
    public Estabelecimento buscarPorId(@PathVariable Long id) {
        return estabelecimentoService.buscarPorId(id);
    }

    // 3. Cadastrar estabelecimentos
    @PostMapping
    public Estabelecimento cadastrar(@RequestBody Estabelecimento estabelecimento) {
        return estabelecimentoService.salvar(estabelecimento);
    }

    // 4. Deletar estabelecimento
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        estabelecimentoService.deletar(id);
    }

    // 5. Adicionar produto ao estabelecimento
    @PostMapping("/{id}/produtos")
    public Produto adicionarProduto(@PathVariable Long id, @RequestBody Produto produto) {
        return estabelecimentoService.adicionarProduto(id, produto);
    }

    // 6. Listar produtos do estabelecimento
    @GetMapping("/{id}/produtos")
    public List<Produto> listarProdutos(@PathVariable Long id) {
        return estabelecimentoService.listarProdutos(id);
    }
}
