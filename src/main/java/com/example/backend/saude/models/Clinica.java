package com.example.backend.saude.models;

import javax.persistence.*;

@Entity
@Table(name = "clinica")
public class Clinica {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_clinica;

    private String usuario;
    private String senha;
    private String nome;
    private String especialidade;
    //private Endereco endereço;
    private String telefone;
    private String email;

    // Construtor default
    public Clinica () {}

    // Construtor geral
    public Clinica(String usuario, String senha, String nome, String especialidade, String telefone, String email) {
        this.usuario = usuario;
        this.senha = senha;
        this.nome = nome;
        this.especialidade = especialidade;
        //this.endereço = endereço;
        this.telefone = telefone;
        this.email = email;
    }

    // Getters e Setters
    public Long getId_clinica() {return id_clinica;}

    public void setId_clinica(Long id_clinica) {this.id_clinica = id_clinica;}

    public String getUsuario() {return usuario;}

    public void setUsuario(String usuario) {this.usuario = usuario;}

    public String getSenha() {return senha;}

    public void setSenha(String senha) {this.senha = senha;}

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public String getEspecialidade() {return especialidade;}

    public void setEspecialidade(String especialidade) {this.especialidade = especialidade;}

    //public Endereco getEndereço() {return endereço;}

    //public void setEndereço(Endereco endereço) {this.endereço = endereço;}

    public String getTelefone() {return telefone;}

    public void setTelefone(String telefone) {this.telefone = telefone;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

}
