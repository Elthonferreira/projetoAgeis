package com.example.saude.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    String serverName = "localhost";  // Caminho servidor BD
    String mydatabase = "projetoageis"; // Nome do seu banco
    String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
    String username = "root"; // Nome do usuário do seu BD
    String password = ""; // Senha de acesso

    Connection conexao;

    Conexao() throws SQLException {
        conexao = DriverManager.getConnection(url, username, password);
    }
}
