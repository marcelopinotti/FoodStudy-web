package com.foodstudy.web.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;
    private String tipo;

    // ---- Relacionamentos ----

    // Um usuário possui 1 FoodCash
    @OneToOne
    @JoinColumn(name = "foodcash_id")
    private FoodCash foodCash;

    // Um usuário pode realizar vários pedidos
    @OneToMany(mappedBy = "usuario")
    private List<Pedido> pedidos;

    // Um usuário pode receber várias notificações
    @OneToMany(mappedBy = "usuario")
    private List<Notificacao> notificacoes;

    // Um usuário possui 1 assinatura
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Assinatura assinatura;

    // ---- Métodos do diagrama ----

    public List<Pedido> visualizarPedidos() {
        return pedidos;
    }

    public void adicionarFoodCash(float valor) {
        if (foodCash != null) {
            foodCash.adicionar(valor);
        }
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public FoodCash getFoodCash() {
        return foodCash;
    }

    public void setFoodCash(FoodCash foodCash) {
        this.foodCash = foodCash;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public List<Notificacao> getNotificacoes() {
        return notificacoes;
    }

    public Assinatura getAssinatura() {
        return assinatura;
    }

    public void setAssinatura(Assinatura assinatura) {
        this.assinatura = assinatura;
    }
}
