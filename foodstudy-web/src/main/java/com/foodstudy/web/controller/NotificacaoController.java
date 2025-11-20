package com.foodstudy.web.controller;

import com.foodstudy.web.model.Notificacao;
import com.foodstudy.web.service.NotificacaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notificacoes")
public class NotificacaoController {

    private final NotificacaoService notificacaoService;

    public NotificacaoController(NotificacaoService notificacaoService) {
        this.notificacaoService = notificacaoService;
    }

    // 1. Enviar notificação para um usuário
    @PostMapping
    public Notificacao enviar(@RequestParam Long usuarioId,
                              @RequestParam String mensagem) {
        return notificacaoService.enviarNotificacao(usuarioId, mensagem);
    }

    // 2. Listar todas as notificações
    @GetMapping
    public List<Notificacao> listarTodas() {
        return notificacaoService.listarTodas();
    }

    // 3. Listar notificações de um usuário
    @GetMapping("/usuario/{id}")
    public List<Notificacao> listarPorUsuario(@PathVariable Long id) {
        return notificacaoService.listarPorUsuario(id);
    }

    // 4. Buscar notificação por ID
    @GetMapping("/{id}")
    public Notificacao buscarPorId(@PathVariable Long id) {
        return notificacaoService.buscarPorId(id);
    }
}
