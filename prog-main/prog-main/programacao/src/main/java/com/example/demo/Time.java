package com.example.demo;

public class Time {
    private Long id;
    private String nome;
    private String dataFundacao;
    private String cidade;
    private String estado;

    public Time(){}

    public Time(Long id, String nome, String dataFundacao, String cidade, String estado){
        this.id = id;
        this.nome = nome;
        this.dataFundacao = dataFundacao;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Long getId(){
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(String dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

