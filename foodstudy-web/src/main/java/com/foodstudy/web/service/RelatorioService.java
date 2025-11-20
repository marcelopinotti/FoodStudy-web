package com.foodstudy.web.service;

import com.foodstudy.web.model.Estabelecimento;
import com.foodstudy.web.model.Relatorio;
import com.foodstudy.web.repository.EstabelecimentoRepository;
import com.foodstudy.web.repository.RelatorioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RelatorioService {

    private final RelatorioRepository relatorioRepository;
    private final EstabelecimentoRepository estabelecimentoRepository;

    public RelatorioService(RelatorioRepository relatorioRepository,
                            EstabelecimentoRepository estabelecimentoRepository) {
        this.relatorioRepository = relatorioRepository;
        this.estabelecimentoRepository = estabelecimentoRepository;
    }

    // Criar relatório para um estabelecimento
    public Relatorio criarRelatorio(Long estabelecimentoId, Relatorio dados) {

        Estabelecimento estabelecimento = estabelecimentoRepository.findById(estabelecimentoId)
                .orElseThrow(() -> new RuntimeException("Estabelecimento não encontrado"));

        dados.setEstabelecimento(estabelecimento);
        dados.setData(LocalDateTime.now()); // data atual

        // Chamando o método do próprio MODEL
        dados.gerar();

        return relatorioRepository.save(dados);
    }

    // Listar todos os relatórios
    public List<Relatorio> listarTodos() {
        return relatorioRepository.findAll();
    }

    // Buscar relatório por ID
    public Relatorio buscarPorId(Long id) {
        return relatorioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Relatório não encontrado"));
    }

    // Listar relatórios de um estabelecimento
    public List<Relatorio> listarPorEstabelecimento(Long estabelecimentoId) {

        Estabelecimento estabelecimento = estabelecimentoRepository.findById(estabelecimentoId)
                .orElseThrow(() -> new RuntimeException("Estabelecimento não encontrado"));

        return estabelecimento.getRelatorios();
    }
}
