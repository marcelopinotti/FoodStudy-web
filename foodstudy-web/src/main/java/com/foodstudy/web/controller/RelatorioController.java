package com.foodstudy.web.controller;

import com.foodstudy.web.model.Relatorio;
import com.foodstudy.web.service.RelatorioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/relatorios")
public class RelatorioController {

    private final RelatorioService relatorioService;

    public RelatorioController(RelatorioService relatorioService) {
        this.relatorioService = relatorioService;
    }

    // 1. Listar todos os relatórios
    @GetMapping
    public List<Relatorio> listarTodos() {
        return relatorioService.listarTodos();
    }

    // 2. Buscar relatório por ID
    @GetMapping("/{id}")
    public Relatorio buscarPorId(@PathVariable Long id) {
        return relatorioService.buscarPorId(id);
    }

    // 3. Criar relatório para um estabelecimento
    @PostMapping("/{estabelecimentoId}")
    public Relatorio criar(@PathVariable Long estabelecimentoId,
                           @RequestBody Relatorio relatorio) {
        return relatorioService.criarRelatorio(estabelecimentoId, relatorio);
    }

    // 4. Listar relatórios de um estabelecimento específico
    @GetMapping("/estabelecimento/{id}")
    public List<Relatorio> listarPorEstabelecimento(@PathVariable Long id) {
        return relatorioService.listarPorEstabelecimento(id);
    }
}
