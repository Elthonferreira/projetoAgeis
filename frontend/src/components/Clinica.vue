<template>
  <div id="app">
    <nav>
      <div class="nav-wrapper blue darken-1">
        <a href="#" class="brand-logo center">Cadastro de Clínicas</a>
      </div>
    </nav>
    <div class="container">
      {{error}}
      <form @submit.prevent="salvar()">
        <label>Nome</label>
        <input type="text" placeholder="nome" v-model="clinica.nome" />
        <label>Usuário</label>
        <input type="text" placeholder="usuário" v-model="clinica.usuario" />
        <label>Senha</label>
        <input type="password" placeholder="senha" v-model="clinica.senha" />
        <label>Especialidade</label>
        <input type="text" placeholder="especialidade" v-model="clinica.especialidade" />
        <label>Telefone</label>
        <input type="text" placeholder="telefone" v-model="clinica.telefone" />
        <label>Email</label>
        <input type="text" placeholder="email" v-model="clinica.email" />
        <button @click="listar()" class="waves-effect waves-light btn-small">
          Salvar
          <i class="material-icons left">save</i>
        </button>
      </form>
      <table>
        <thead>
          <tr>
            <th>Nome</th>
            <th>Usuário</th>
            <th>Senha</th>
            <th>Especialidade</th>
            <th>Telefone</th>
            <th>Email</th>
            <th>Opções</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="clinica of clinicas" :key="clinica.key">
            <td>{{ clinica.nome }}</td>
            <td>{{ clinica.usuario }}</td>
            <td>{{ clinica.senha }}</td>
            <td>{{ clinica.especialidade }}</td>
            <td>{{ clinica.telefone }}</td>
            <td>{{ clinica.email }}</td>
            <td>
              <button @click="alterar(clinica)" class="waves-effect btn-small blue darken-1">
                <i class="material-icons">Alterar</i>
              </button>
              <button @click="deletar(clinica)" class="waves-effect btn-small red darken-1">
                <i class="material-icons">Deletar</i>
              </button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script type="text/javascript">
import axios from "axios";

export default {
  name: "app",
  data: () => {
    return {
      url: "http://localhost:8081",
      clinica: {
        nome: "",
        usuario: "",
        senha: "",
        especialidade: "",
        telefone: "",
        email: ""
      },
      clinicas: [],
      error: "",
      condicao: false
    };
  },
  methods: {
    salvar() {
      axios
        .post(this.url + "/clinicas", this.clinica)
        .then(function() {
          this.listar();
          this.produto = {};
          alert("Salvo com sucesso!");
        })
        .catch(error => {
          this.error = error.response.data;
        });
    },
    alterar(clinica) {
      this.clinica = clinica;
    },
    deletar(clinica) {
      if (confirm("Deseja excluir a clínica?")) {
        console.log(clinica);
        axios
          .delete(this.url + "/clinicas", { data: clinica })
          .then(function() {
            this.listar();
            this.error = "";
            alert("Deletada com sucesso!");
          })
          .catch(error => {
            this.error = error.response.data;
          });
      }
    },
    listar() {
      axios
        .get(this.url + "/clinicas")
        .then(response => {
          this.clinicas = response.data;
        })
        .catch(error => {
          this.clinicas = [];
          this.error = error.response.data;
        });
    }
  },
  mounted() {
    axios
      .get(this.url + "/clinicas")
      .then(response => {
        this.clinicas = response.data;
      })
      .catch(error => {
        this.clinicas = [];
        this.error = error.response.data;
      });
  }
};
</script>

<style>
</style>
