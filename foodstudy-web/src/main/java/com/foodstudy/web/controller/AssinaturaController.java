package com.foodstudy.web.controller;

import com.foodstudy.web.model.Assinatura;
import com.foodstudy.web.service.AssinaturaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assinaturas")
public class AssinaturaController {

    private final AssinaturaService assinaturaService;

    public AssinaturaController(AssinaturaService assinaturaService) {
        this.assinaturaService = assinaturaService;
    }

    // 1. Listar todas as assinaturas
    @GetMapping
    public List<Assinatura> listarTodas() {
        return assinaturaService.listarTodas();
    }

    // 2. Buscar assinatura por ID
    @GetMapping("/{id}")
    public Assinatura buscarPorId(@PathVariable Long id) {
        return assinaturaService.buscarPorId(id);
    }

    // 3. Criar assinatura
    @PostMapping
    public Assinatura criar(@RequestParam Long usuarioId,
                            @RequestBody Assinatura assinatura) {

        return assinaturaService.salvar(assinatura, usuarioId);
    }

    // 4. Ativar assinatura
    @PostMapping("/{id}/ativar")
    public Assinatura ativar(@PathVariable Long id) {
        return assinaturaService.ativar(id);
    }
}
