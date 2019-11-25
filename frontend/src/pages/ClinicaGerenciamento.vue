<template>
<div class="login">
  <body>
    <app-header></app-header>

    <div class="diagnostico">
      <h4>Pacientes</h4>
      <br />

      <table id="customers">
        <tr>
          <th>Nome do paciente</th>
          <th>Possivel doença</th>
          <th>Contato</th>
          <th>Endereço</th>
          <th>Ação</th>
        </tr>
        <tr v-bind:key="index" v-for="(item, index) in pacientes">
          <td>{{ item.nome }}</td>
          <td>{{ item.doenca }}</td>
          <td>
            <span>{{ item.telefone }}</span>
          </td>
          <td>{{ item.endereco }}</td>

          <td>
            <button class="button-more-info" v-on:click="mostrarClinica(item)">Ver mais</button>
          </td>
        </tr>
      </table>
    </div>

    <app-footer></app-footer>

    <!-- The Modal -->
    <div id="myModal" class="modal">
      <!-- Modal content -->
      <div class="modal-content">
        <span v-on:click="fecharModal()" class="close">&times;</span>

        <h4>{{ clinicaselecionada.nome }}</h4>
        <span>{{ clinicaselecionada.especialidade }}</span>
        <br />
        <span>{{ clinicaselecionada.email }}</span>
        <br />
        <span>{{ clinicaselecionada.telefone }}</span>
        <br />
        <span>{{ clinicaselecionada.endereco }}</span>
      </div>
    </div>
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
      nomeDoenca: "",
      descricao: "",
      sintomasSelecionados: "",
      todasSintomasDoenca: "",
      clinicaselecionada: {
        nome: "",
        especialidade: "",
        email: "",
        telefone: "",
        endereco: ""
      },
      pacientes: []
    };
  },
  methods: {
    mostrarClinica: function(attr) {
      this.clinicaselecionada = attr;
      var modal = document.getElementById("myModal");
      modal.style.display = "block";
      window.onclick = function(event) {
        if (event.target == modal) {
          modal.style.display = "none";
        }
      };
    },
    fecharModal: function(attr) {
      var modal = document.getElementById("myModal");
      modal.style.display = "none";
    },

    getClinica: function(clinicaId) {
      return axios
        .get(this.url + "/clinicaGerenciamento/" + clinicaId)
        .then(res => {
          const vue = this;
          this.pacientes = res.data;
          /* res.data.forEach(function(elem) {
            console.log(elem);
            vue.pacientes.push({
              //nome doenca telefone endereco
              nome: elem.nome,
              doenca: elem.doenca,
              telefone: elem.telefone,
              endereco: elem.endereco
            });
          });*/
          console.log("this.pacientes");
          //  console.log(this.pacientes);
        })
        .catch(error => {
          //this.error = error.response.data;
          console.log(error);
        });
    },

    back: function() {
      window.location.href = "/#/login";
    }
  },
  mounted: async function() {
    this.getClinica(this.$session.get("user").id);
    //  if (!this.$session.exists()) {
    //   window.location.href = "/#/login";
    //  } else {
    this.$nextTick(async function() {
      const vue = this;
      let doencasId = [];
      let clinicaEspecialidade = [];
      vue.items = [];

      for (let x in clinicaEspecialidade) {
        vue.items.push({
          nome: clinicaEspecialidade[x].nome,
          especialidade: clinicaEspecialidade[x].especialidade,
          email: clinicaEspecialidade[x].email,
          telefone: clinicaEspecialidade[x].telefone,
          endereco: clinicaEspecialidade[x].endereço
        });
      }

      console.log(vue.items);
    });
  }
  //}
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

.button-more-info {
  margin: 0 auto;
  width: 100px;
  border-radius: 15px;
  border-color: transparent;
  background-color: #4676ff;
  color: #fff;
}

.button-more-info:hover {
  background-color: #355dd1;
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
</style>
