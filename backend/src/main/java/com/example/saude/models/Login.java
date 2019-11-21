package com.example.saude.models;

public class Login {

	private Long id;
	private String nome;
	private String email;
	private String tipoUsuario;
	
	public Login() {
		super();
	}

	public Login(Long id, String nome, String email, String tipoUsuario) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.tipoUsuario = tipoUsuario;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

}
