package com.example.demo;

//criacao da classe
public class Cidade {
    private Long id;
    private String nome;
    private String estado;
    private String pais;
    private int populacao;

    //criacao do método construtor vazio
    public Cidade(){}

    //criacao do método construtor com atributos
    public Cidade(Long id, String nome, String estado, String pais, int populacao) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
        this.pais = pais;
        this.populacao = populacao;
    }

    //getters e setters
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

    public int getPopulacao() {
        return populacao;
    }

    public void setPopulacao(int populacao) {
        this.populacao = populacao;
    }
}
