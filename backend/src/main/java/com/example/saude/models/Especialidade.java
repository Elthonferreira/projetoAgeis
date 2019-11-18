package com.example.saude.models;

import javax.persistence.*;

@Entity
@Table(name = "especialidade")
public class Especialidade {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    
    // Construtor default
    public Especialidade () {}

	public Especialidade(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
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
	
}
