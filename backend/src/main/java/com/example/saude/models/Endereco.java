package com.example.saude.models;

public class Endereco {

    // Atributos
    private String logradouro;
    private String cep;
    private String bairro;
    private String cidade;
    private String uf;

    // Construtor default
    public Endereco() {}

    // Construtor geral
    public Endereco(String logradouro, String cep, String bairro, String cidade, String uf) {
        this.logradouro = logradouro;
        this.cep = cep;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
    }

    // Getters e Setters
    public String getLogradouro() {return logradouro;}

    public void setLogradouro(String logradouro) {this.logradouro = logradouro;}

    public String getCep() {return cep;}

    public void setCep(String cep) {this.cep = cep;}

    public String getBairro() {return bairro;}

    public void setBairro(String bairro) {this.bairro = bairro;}

    public String getCidade() {return cidade;}

    public void setCidade(String cidade) {this.cidade = cidade;}

    public String getUf() {return uf;}

    public void setUf(String uf) {this.uf = uf;}

}
