package com.foodstudy.web.model;

import jakarta.persistence.*;

@Entity
@Table(name = "foodcash")
public class FoodCash {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Float saldo;

    // FoodCash pertence a 1 usuário
    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    // Métodos do diagrama
    public void adicionar(float valor) {
        this.saldo += valor;
    }

    public void descontar(float valor) {
        this.saldo -= valor;
    }

    public float consultarSaldo() {
        return saldo;
    }

    // Getters e setters
    public Long getId() {
        return id;
    }

    public Float getSaldo() {
        return saldo;
    }

    public void setSaldo(Float saldo) {
        this.saldo = saldo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
