package com.foodstudy.web.controller;

import com.foodstudy.web.model.Pedido;
import com.foodstudy.web.service.PedidoService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    // 1. Listar todos os pedidos
    @GetMapping
    public List<Pedido> listar() {
        return pedidoService.listarTodos();
    }

    // 2. Buscar por ID
    @GetMapping("/{id}")
    public Pedido buscarPorId(@PathVariable Long id) {
        return pedidoService.buscarPorId(id);
    }

    // 3. Criar pedido
    @PostMapping
    public Pedido criarPedido(@RequestParam Long usuarioId,
                              @RequestParam Long produtoId,
                              @RequestParam Long estabelecimentoId) {

        return pedidoService.criarPedido(usuarioId, produtoId, estabelecimentoId);
    }

    // 4. Cancelar pedido
    @PostMapping("/{id}/cancelar")
    public Pedido cancelar(@PathVariable Long id) {
        return pedidoService.cancelar(id);
    }

    // 5. Agendar retirada
    @PostMapping("/{id}/agendar")
    public Pedido agendarRetirada(@PathVariable Long id,
                                  @RequestParam String dataHora) {

        LocalDateTime retirar = LocalDateTime.parse(dataHora);
        return pedidoService.agendarRetirada(id, retirar);
    }

    // 6. Marcar como retirado
    @PostMapping("/{id}/retirado")
    public Pedido marcarRetirado(@PathVariable Long id) {
        return pedidoService.marcarRetirado(id);
    }
}
