package com.foodstudy.web.model;

import jakarta.persistence.*;

@Entity
@Table(name = "assinaturas")
public class Assinatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;
    private Float valor;
    private String beneficios;

    // Uma assinatura pertence a um usuário
    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    // ---- Método do diagrama ----

    public void ativar() {
        // Lógica será implementada futuramente
    }

    // ---- Getters e Setters ----

    public Long getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public String getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(String beneficios) {
        this.beneficios = beneficios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
