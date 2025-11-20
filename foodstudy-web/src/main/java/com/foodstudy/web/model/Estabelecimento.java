package com.foodstudy.web.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "estabelecimentos")
public class Estabelecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    // Um estabelecimento tem vários produtos
    @OneToMany(mappedBy = "estabelecimento")
    private List<Produto> produtos;

    // Um estabelecimento possui vários pedidos
    @OneToMany(mappedBy = "estabelecimento")
    private List<Pedido> pedidos;

    // Um estabelecimento possui vários relatórios
    @OneToMany(mappedBy = "estabelecimento")
    private List<Relatorio> relatorios;

    // ---- Métodos do diagrama ----

    public void cadastrarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void processarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    // ---- Getters e Setters ----

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public List<Relatorio> getRelatorios() {
        return relatorios;
    }
}
