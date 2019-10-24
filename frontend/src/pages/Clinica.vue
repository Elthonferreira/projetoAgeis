<template>
  <div id="app">
    <app-header></app-header>
    <div class="container">
      <h3>Cadastro de Clínica</h3>
      <div class="row">
        <form @submit.prevent="salvar()" class="col s12">
          <h4>Dados Pessoais</h4>
          <div class="input-field col s12">
            <input id="name" type="text" class="validate" v-model="clinica.nome">
            <label for="name">Nome</label>
          </div>
          <div class="input-field col s12">
            <input id="speciality" type="text" class="validate" v-model="clinica.especialidade">
            <label for="speciality">Especialidade</label>
          </div>
          <div class="input-field col s12">
            <input id="telephone" type="tel" pattern="[0-9]*" class="validate" v-model="clinica.telefone">
            <label for="telephone">Telefone</label>
          </div>
          <div class="input-field col s12">
            <input id="email" type="email" class="validate" v-model="clinica.email">
            <label for="email">E-mail</label>
          </div>
          <h4>Dados da Conta</h4>
           <div class="input-field col s12">
            <input id="user" type="text" class="validate" v-model="clinica.usuario">
            <label for="user">Usuário</label>
          </div>
          <div class="input-field col s12">
            <input id="password" type="password" class="validate" v-model="clinica.senha">
            <label for="password">Senha</label>
          </div>
          <div class="input-field col s12">
            <input id="confirmPassword" type="password" class="validate" >
            <label for="confirmPassword">Confirmar Senha</label>
          </div>
        <div class="button-submit">
          <button type="submit" class="waves-effect waves-light btn-small">
            Cadastrar
          </button>
        </div>
      </form>
      </div>
    </div>
    <app-footer></app-footer>
  </div>
</template>

<script type="text/javascript">
import axios from "axios";
import AppHeader from "../components/Header.vue"
import AppFooter from "../components/Footer.vue"

export default {
  name: "app",
  components: {
    AppHeader, AppFooter
  },
  data: () => {
    return {
      url: "http://localhost:8081/api",
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
          M.toast({html: 'Clínica cadastrada com sucesso!', classes: 'rounded'});
          window.location.href = "/#/login";
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
  h3 {
    text-align: center;
    color: #2f52b9;
    font-weight: bold;  
  }

  h4 {
    color: #2f52b9;
  }

  .container {
    width: 800px;
    margin: 0 auto;
    padding: 80px 0;
  }

  .button-submit {
    width: 100%;
    display: flex;
    justify-content: center;
    margin: 0 auto;
    padding-top: 20px;
    }    

  .button-submit button {
    width: 180px;
    height: 50px;
    font-size: 20px;
    background: #4676ff;
    font-weight: bold;
    border-radius: 5px;
  } 

  .button-submit button:hover {
    background: #2f52b9;
    color: #fff;
  }

  .input-field input[type=text]:focus, .input-field input[type=email]:focus, .input-field input[type=tel]:focus,
    .input-field input[type=password]:focus {
    border-bottom: 1px solid #4676ff !important;
    box-shadow: 0 1px 0 0 #4676ff !important;
  }
  .input-field input[type=text]:focus + label, .input-field input[type=email]:focus + label,
    .input-field input[type=tel]:focus + label, .input-field input[type=password]:focus + label {
    color: #4676ff !important;
  }

</style>
