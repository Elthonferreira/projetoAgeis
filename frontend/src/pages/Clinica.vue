<template>
  <div id="app">
    <app-header></app-header>
    <div class="container">
      <div class="alert alert-success" hidden id="alert" role="alert">
        Clínica cadastrada com sucesso! Redirecionando para a tela de login em 3 segundos...
      </div>
      <h3>Cadastro de Clínica</h3>
      <form  @submit.prevent="salvar()">
                    <h4>Dados Pessoais</h4>
                    <div class="form-group">
                        <div class="name-column1">
                            <label for="name">Nome da Clínica:</label>
                            <input id="name" type="text" class="form-control" v-model="clinica.nome" required>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="speciality-column1">
                            <label for="speciality">Especialidade</label>
                            <input id="speciality" type="text" class="form-control" v-model="clinica.especialidade" required>
                        </div>
                    </div>
                
                    <div class="form-group">
                        <div class="email-telephone-column1">
                            <label for="email">E-mail</label>
                            <input id="email" type="email" class="form-control" v-model="clinica.email" required>
                        </div>
                        <div class="email-telephone-column2">
                            <label for="Telephone">Telefone</label>
                            <input id="Telephone" type="tel" pattern= "[0-9]*" class="form-control" v-model="clinica.telefone" required>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="neighborhood-column1">
                            <label for="neighborhood">Endereço</label>
                            <input id="neighborhood" type="text" class="form-control" v-model="clinica.endereco" required>
                        </div>
                    </div>

                  
                    <h4>Dados da Conta</h4>

                    <div class="form-group">
                        <div class="user-column1">
                            <label for="user">Usuário</label>
                            <input id="user" type="text" class="form-control" v-model="clinica.usuario" required>
                        </div>
                        <div class="email-column2"></div>
                    </div>

                    <div class="form-group">
                        <div class="password-confirmPassword-column1">
                            <label for="password">Senha</label>
                            <input id="password" type="password" class="form-control" v-model="clinica.senha" required>
                        </div>
                        <div class="password-confirmPassword-column2">
                            <label for="confirmPassword">Confirmar Senha</label>
                            <input id="confirmPassword" type="password" class="form-control" required>
                        </div>

                        <div class="password-confirmPassword-column3"></div>
                    </div>

                    <div class="form-group wrapper-button-submit">
                        <button type="submit" class="btn btn-primary">Cadastrar</button>
                    </div>
                    </form>
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
        endereco: "",
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
          //M.toast({html: 'Clínica cadastrada com sucesso!', classes: 'rounded'});
            let message = document.getElementById("alert");
            message.removeAttribute("hidden");
            setTimeout(() => {
                window.location.href = "/#/login";
            }, 3000);
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

  .form-group {
      display: flex;
      justify-content: center;
      align-items: center;
  }

  .form-group > label {
      height: 100%;
      margin: auto 0;
  }

  .name-column1 {
    width: 100%;
  }

  .speciality-column1 {
    width: 100%;
  }

  .neighborhood-column1 {
    width: 100%;
  }

  .email-telephone-column1 {
    width: 60%;
  }

  .email-telephone-column2 {
    width: 35%;
    margin-left: 5%;
  }

  .user-column1{
    width: 100%;
  }

  .password-confirmPassword-column1 {
        width: 25%;
    }

    .password-confirmPassword-column2 {
        width: 25%;
        margin-left: 5%;
    }

    .password-confirmPassword-column3{
        width: 45%;
    }

  .btn-primary {
          width: 150px;
          font-weight: bold;
          margin-top: 20px;
      }

</style>
