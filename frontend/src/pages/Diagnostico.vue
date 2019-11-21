<template>
  <div class="login">
    <body>
      <app-header></app-header>

      <div class="diagnostico">
        <h4>Diagnóstico</h4>
        <br />
        <span class="sickness-name"
          ><strong>{{ nomeDoenca }}</strong></span
        >
        <br />
        <span class="sickness-description">
          {{ descricao }}
        </span>
        <br>
        <span
          >Você possui {{ sintomasSelecionados }} de
          {{ todasSintomasDoenca }} sintomas da(o) {{ nomeDoenca }}</span
        >
        <br />
        <br />
        <h5>Clínicas parceiras perto de você</h5>

        <table id="customers">
          <tr>
            <th>Clínica</th>
            <th>Especialidade</th>
            <th>Contato</th>
            <th>Ação</th>
          </tr>
          <tr v-bind:key="index" v-for="(item, index) in items">
            <td>{{ item.nome }}</td>
            <td>{{ item.especialidade }}</td>
            <td>
              <span>{{ item.email }}</span>
              <br />
              <span>{{ item.telefone }}</span>
            </td>

            <td>
              <button class="button-more-info" v-on:click="mostrarClinica(item)">Ver mais</button>
            </td>
          </tr>
        </table>
        <div class="box-button-back">
          <button @click="back()" type="button" class="btn btn-outline-success back">
              Voltar
          </button>
        </div>

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
      items: []
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
    getAllDoencasId: function(subAreaSintomaId, doencasId) {
      return axios
        .get(this.url + "/doencasubareasintoma/" + subAreaSintomaId)
        .then(function(res) {
          doencasId.push(res.data);
        })
        .catch(error => {
          //this.error = error.response.data;
          console.log(error);
        });
    },
    getMostOccurrence: function(array, getId) {
      if (array.length == 0) return null;
      var modeMap = {};
      var maxEl = array[0],
        maxCount = 1;
      for (var i = 0; i < array.length; i++) {
        var el = array[i];
        if (modeMap[el] == null) modeMap[el] = 1;
        else modeMap[el]++;
        if (modeMap[el] > maxCount) {
          maxEl = el;
          maxCount = modeMap[el];
        }
      }

      if (getId) {
        return maxEl;
      } else {
        return maxCount;
      }
    },
    getClinica: function (clinicaId, clinicaEspecialidade) {
      return axios
        .get(
          this.url +
            "/clinicas/" +
            clinicaId
        )
        .then(function(res) {
          clinicaEspecialidade.push(res.data);
        })
        .catch(error => {
          //this.error = error.response.data;
          console.log(error);
        });
    },
    getEspecialidade: function (especialidadeId, clinicaEspecialidade, index) {
      return axios
        .get(
          this.url +
            "/especialidade/" +
            especialidadeId
        )
        .then(function(res) {
          clinicaEspecialidade[index].especialidade = res.data.nome;
        })
        .catch(error => {
          //this.error = error.response.data;
          console.log(error);
        });
    },
    back: function() {
      window.location.href = "/#/bodyregion1";
    }
  },
  mounted: async function() {
    if (!this.$session.exists()) {
      window.location.href = "/#/login";
    } else {
      this.$nextTick(async function() {
        const vue = this;
        let doencasId = [];
        let clinicaEspecialidade = []
        vue.items = []

        await axios
          .get(this.url + "/usersubareasintoma/" + this.$route.params.id)
          .then(async function(res) {
            for (let x in res.data) {
              await vue.getAllDoencasId(
                res.data[x].sub_area_sintoma_id,
                doencasId
              );
            }
          })
          .catch(error => {
            //this.error = error.response.data;
            console.log(error);
          });
    
        await axios
          .get(this.url + "/doenca/" + vue.getMostOccurrence(doencasId, true))
          .then(function(res) {
            vue.nomeDoenca = res.data.nome;
            vue.descricao = res.data.descricao;
          })
          .catch(error => {
            //this.error = error.response.data;
            console.log(error);
          });

        await axios
          .get(
            this.url +
              "/doencasubareasintoma/countSintomas/" +
              vue.getMostOccurrence(doencasId, true)
          )
          .then(function(res) {
            vue.sintomasSelecionados = vue.getMostOccurrence(doencasId, false);
            vue.todasSintomasDoenca = res.data;
          })
          .catch(error => {
            //this.error = error.response.data;
            console.log(error);
          });

          await axios
          .get(
            this.url +
              "/doencaespecialidade/" +
              vue.getMostOccurrence(doencasId, true)
          )
          .then(async function(res) {
            for (let x in res.data) {
              await vue.getClinica(res.data[x].clinica_id, clinicaEspecialidade);
              await vue.getEspecialidade(res.data[x].especialidade_id, clinicaEspecialidade, x);
            }
          })
          .catch(error => {
            //this.error = error.response.data;
            console.log(error);
          });

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
