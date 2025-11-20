package com.foodstudy.web.service;

import com.foodstudy.web.model.Usuario;
import com.foodstudy.web.model.FoodCash;
import com.foodstudy.web.repository.UsuarioRepository;
import com.foodstudy.web.repository.FoodCashRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final FoodCashRepository foodCashRepository;

    public UsuarioService(UsuarioRepository usuarioRepository,
                          FoodCashRepository foodCashRepository) {
        this.usuarioRepository = usuarioRepository;
        this.foodCashRepository = foodCashRepository;
    }

    // Criar novo usuário
    public Usuario cadastrar(Usuario usuario) {

        // Criar FoodCash automaticamente para o usuário
        FoodCash foodCash = new FoodCash();
        foodCash.setSaldo(0f);
        foodCash.setUsuario(usuario);

        usuario.setFoodCash(foodCash);

        // Salvar usuário (e FoodCash por cascata)
        return usuarioRepository.save(usuario);
    }

    // Retornar TODOS os usuários
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    // Buscar usuário por ID
    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    // Adicionar saldo ao usuário
    public void adicionarFoodCash(Long usuarioId, float valor) {
        Usuario usuario = buscarPorId(usuarioId);
        FoodCash wallet = usuario.getFoodCash();

        wallet.adicionar(valor);
        foodCashRepository.save(wallet);
    }

    // Visualizar pedidos do usuário
    public List<?> visualizarPedidos(Long usuarioId) {
        Usuario usuario = buscarPorId(usuarioId);
        return usuario.getPedidos();
    }
}
