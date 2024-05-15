package com.example.demo;

public class Cidade {
    private Long id;
    private String nome;
    private String estado;
    private String pais;
    private String populacao;

    public Cidade(){}

    public Cidade(Long id, String nome, String estado, String pais, String populacao) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
        this.pais = pais;
        this.populacao = populacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getPopulacao() {
        return populacao;
    }

    public void setPopulacao(String populacao) {
        this.populacao = populacao;
    }
}
