package com.foodstudy.web.service;

import com.foodstudy.web.model.Notificacao;
import com.foodstudy.web.model.Usuario;
import com.foodstudy.web.repository.NotificacaoRepository;
import com.foodstudy.web.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificacaoService {

    private final NotificacaoRepository notificacaoRepository;
    private final UsuarioRepository usuarioRepository;

    public NotificacaoService(NotificacaoRepository notificacaoRepository,
                              UsuarioRepository usuarioRepository) {
        this.notificacaoRepository = notificacaoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    // Enviar notificação ao usuário
    public Notificacao enviarNotificacao(Long usuarioId, String mensagem) {

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Notificacao notificacao = new Notificacao();
        notificacao.setUsuario(usuario);
        notificacao.setMensagem(mensagem);

        // Chamando o método da entidade (futuro envio real)
        notificacao.enviar();

        return notificacaoRepository.save(notificacao);
    }

    // Listar todas as notificações
    public List<Notificacao> listarTodas() {
        return notificacaoRepository.findAll();
    }

    // Listar notificações de um usuário específico
    public List<Notificacao> listarPorUsuario(Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        return usuario.getNotificacoes();
    }

    // Buscar notificação por ID
    public Notificacao buscarPorId(Long id) {
        return notificacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notificação não encontrada"));
    }
}
