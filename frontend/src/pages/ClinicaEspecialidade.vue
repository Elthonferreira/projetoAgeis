<template>
  <div class="login">
    <body>
      <app-header></app-header>

      <div class="form-add">
        <div class="especialidade-select">
          <p>Especialidade</p>
          <select v-model="especialidadeDoencaAdicionar.especialidade_id">
            <option
              v-bind:key="item.id"
              v-for="(item, index) in especialidades"
              v-bind:value="item.id"
              >{{ item.nome }}</option
            >
          </select>
        </div>

        <div class="doenca-select">
          <p>Doença</p>
          <select v-model="especialidadeDoencaAdicionar.doenca_id">
            <option
              v-bind:key="item.id"
              v-for="(item, index) in doencas"
              v-bind:value="item.id"
              >{{ item.nome }}</option
            >
          </select>
        </div>

        <button class="button-add" v-on:click="add()">
          Adicionar
        </button>
      </div>

      <div class="diagnostico">
        <h4>Suas especialidades</h4>
        <br />

        <table id="customers">
          <tr>
            <th>Especialidade</th>
            <th>Doença tratado</th>
            <th>Ação</th>
          </tr>
          <tr v-bind:key="index" v-for="(item, index) in especialidadeDoencas">
            <td>{{ getNameEspecialidade(item.especialidade_id) }}</td>
            <td>{{ getNameDoenca(item.doenca_id) }}</td>

            <td>
              <button
                class="button-remove"
                v-on:click="
                  remove(item.id, item.especialidade_id, item.doenca_id)
                "
              >
                Remover
              </button>
            </td>
          </tr>
        </table>
      </div>
      <div class="box-button-back">
        <button
          @click="back()"
          type="button"
          class="btn btn-outline-success back"
        >
          Voltar
        </button>
      </div>

      <app-footer></app-footer>
    </body>
  </div>
</template>

<script>
import AppHeader from "../components/Header.vue";
import AppFooter from "../components/Footer.vue";
import axios from "axios";

export default {
  name: "diagnostico",
  components: {
    AppHeader,
    AppFooter
  },
  data() {
    return {
      url: "http://localhost:8081/api",
      especialidades: [],
      doencas: [],
      especialidadeDoencas: [],
      especialidadeDoencaAdicionar: {},
      clinicaselecionada: {
        nome: "",
        especialidade: "",
        email: "",
        telefone: "",
        endereco: ""
      }
    };
  },
  methods: {
    getNameEspecialidade: function(especialidadeId) {
      for (let x in this.especialidades) {
        if (this.especialidades[x].id == especialidadeId) {
          return this.especialidades[x].nome;
        }
      }

      return "";
    },
    getNameDoenca: function(doencaId) {
      for (let x in this.doencas) {
        if (this.doencas[x].id == doencaId) {
          return this.doencas[x].nome;
        }
      }

      return "";
    },
    back: function() {
      window.location.href = "/#/login";
    },
    update: async function() {
      const vue = this;

      await axios
        .get(
          this.url +
            "/doencaespecialidade/clinica/" +
            this.$session.get("user").id
        )
        .then(function(res) {
          console.log(res.data);
          vue.especialidadeDoencas = res.data;
        })
        .catch(error => {
          //this.error = error.response.data;
          console.log(error);
        });
    },
    add: async function() {
      const vue = this;

      if (
        this.especialidadeDoencaAdicionar.especialidade_id != undefined &&
        this.especialidadeDoencaAdicionar.doenca_id != undefined
      ) {
        this.especialidadeDoencaAdicionar.clinica_id = this.$session.get(
          "user"
        ).id;

        await axios
          .post(
            this.url + "/doencaespecialidade",
            this.especialidadeDoencaAdicionar
          )
          .then(function(res) {
            vue.update();
          })
          .catch(error => {
            //this.error = error.response.data;
            console.log(error);
          });
      }
    },
    remove: async function(doencaEspecialidadeId, especialidadeId, doencaId) {
      const vue = this;
      this.especialidadeDoencaAdicionar.id = doencaEspecialidadeId;
      this.especialidadeDoencaAdicionar.especialidade_id = especialidadeId;
      this.especialidadeDoencaAdicionar.doenca_id = doencaId;
      this.especialidadeDoencaAdicionar.clinica_id = this.$session.get(
        "user"
      ).id;
      console.log(this.especialidadeDoencaAdicionar);
      await axios
        .post(
          this.url +
            "/doencaespecialidade/" +
            this.especialidadeDoencaAdicionar.id
        )
        .then(function(res) {
          vue.update();
        })
        .catch(error => {
          //this.error = error.response.data;
          console.log(error);
        });
    }
  },
  mounted: async function() {
    if (!this.$session.exists()) {
      window.location.href = "/#/login";
    } else {
      this.$nextTick(async function() {
        const vue = this;
        let doencasId = [];
        let clinicaEspecialidade = [];
        vue.items = [];

        await axios
          .get(this.url + "/doenca")
          .then(function(res) {
            vue.doencas = res.data;
          })
          .catch(error => {
            //this.error = error.response.data;
            console.log(error);
          });

        await axios
          .get(this.url + "/especialidade")
          .then(function(res) {
            vue.especialidades = res.data;
          })
          .catch(error => {
            //this.error = error.response.data;
            console.log(error);
          });

        this.update();
      });
    }
  }
};
</script>

<style scoped>
body {
  height: 100vh;

  background-position: center;
  background-size: cover;
}

h4 {
  color: #4676ff;
  font-weight: bold;
}

form {
  margin-top: 60px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

input {
  width: 400px;
  border-radius: 20px;
}

.login-row {
  width: 600px;
  height: 500px;
  background-color: #fff;
  padding-top: 20px;
  padding-bottom: 50px;
  padding-left: 30px;
  padding-right: 30px;
  border-radius: 15px;
  margin: 0 auto;
  margin-top: 5%;

  -webkit-box-shadow: 10px 10px 19px -8px rgba(0, 0, 0, 0.48);
  -moz-box-shadow: 10px 10px 19px -8px rgba(0, 0, 0, 0.48);
  box-shadow: 10px 10px 19px -8px rgba(0, 0, 0, 0.48);
}

.wrapper-button-submit {
  margin-top: 20px;
}

.wrapper-button-submit > .btn-primary {
  width: 150px;
  height: 50px;
  font-size: 24px;
  font-weight: bold;
  border-radius: 30px;
  background-color: #4676ff;
}

.wrapper-button-submit > .btn-primary:hover {
  background-color: #355dd1;
}

.button-submit button:hover {
  background: #355dd1;
  color: #fff;
}

.box-register {
  display: flex;
  justify-content: space-around;
  align-items: center;
  color: #fff;
  margin-top: 40px;
}

.button-register {
  background: #4676ff;
  border-radius: 30px;
  color: #f3f3f3;
  margin-left: 30px;
  margin-right: 30px;
}

.button-register:hover {
  background: #355dd1;
}

#customers {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td,
#customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers tr:nth-child(even) {
  background-color: #f2f2f2;
}

#customers tr:hover {
  background-color: #ddd;
}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #007bff;
  color: white;
}
.diagnostico {
  margin: 16px;
}

.sickness-name {
  font-size: 30px;
}

.sickness-description {
  font-weight: bold;
  color: #636363;
}

/* The Modal (background) */
.modal {
  display: none; /* Hidden by default */
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  padding-top: 100px; /* Location of the box */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: rgb(0, 0, 0); /* Fallback color */
  background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
  background-color: #fefefe;
  margin: auto;
  padding: 20px;
  border: 1px solid #888;
  width: 80%;
}

/* The Close Button */
.close {
  color: #aaaaaa;
  float: right;
  font-size: 28px;
  font-weight: bold;
}

.close:hover,
.close:focus {
  color: #000;
  text-decoration: none;
  cursor: pointer;
}

.button-remove {
  margin: 0 auto;
  width: 100px;
  border-radius: 15px;
  border-color: transparent;
  background-color: #f7321a;
  color: #fff;
}

.button-remove:hover {
  background-color: #ac1300;
}

.box-button-back {
  display: flex;
  justify-content: center;
  align-items: center;
}

.back {
  margin: 25px auto;
  width: 100px;
  background-color: #4676ff;
  border-color: #f3f3f3;
  color: #f3f3f3;
  font-weight: bold;
}

.back:hover {
  background-color: #355dd1;
}

.button-add {
  margin-left: 30px;
  margin-top: 35px;
  width: 150px;
  border-radius: 15px;
  border-color: transparent;
  background-color: #4676ff;
  color: #fff;
}

#save:hover,
.button-add:hover {
  background-color: #355dd1;
}

.form-add {
  width: 80%;
  margin: 25px auto;
  display: flex;
  justify-content: center;
  align-items: center;
}

.doenca-select {
  margin-left: 30px;
}
</style>
