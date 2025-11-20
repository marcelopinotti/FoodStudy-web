package com.foodstudy.web.model;

import com.foodstudy.web.enums.StatusPedido;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Um pedido pertence a um usuário
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    // Um pedido é referente a um único produto
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    // Um pedido é retirado em um estabelecimento
    @ManyToOne
    @JoinColumn(name = "estabelecimento_id")
    private Estabelecimento estabelecimento;

    private LocalDateTime horarioRetirada;

    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    private LocalDateTime criadoEm = LocalDateTime.now();

    // ---- Métodos do diagrama ----

    public void agendarRetirada(LocalDateTime novaData) {
        this.horarioRetirada = novaData;
    }

    public void cancelar() {
        this.status = StatusPedido.CANCELADO;
    }

    // ---- Getters e Setters ----

    public Long getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
    this.criadoEm = criadoEm;
}


    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public LocalDateTime getHorarioRetirada() {
        return horarioRetirada;
    }

    public void setHorarioRetirada(LocalDateTime horarioRetirada) {
        this.horarioRetirada = horarioRetirada;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }
}
