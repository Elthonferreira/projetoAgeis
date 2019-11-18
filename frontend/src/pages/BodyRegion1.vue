<script src="https://gist.github.com/kevinbreaker/71a870344e93c8ea376bc95959af3a9a.js"></script>

<template>
  <div id="content">
    <div id="content">
      <app-header></app-header>
     <div class="top-info">
        <span class="subtitle">Identificação dos sintomas</span>
        <button id="save" v-if="humanResult.length>=1" v-on:click="save()">Receber Diagnóstico</button>
    </div>

      <div class="body-area">
        <div class="section">
          <span>Frente</span>
          <hr />
        </div>

        <div class="body-area-group">
          <div class="space"></div>
          <div class="body">
            <map-body-front
              bodyId="front"
              @map-clicked="onMapClickFront"
            ></map-body-front>
          </div>
          <div class="card-select">
            <div class="selectSympton col s12" v-show="mapFront">
              <p>Membro</p>
              <select
                class="subarea"
                @change="onChangeSubAreaFront($event)"
                v-model="areaCorporalFront"
              >
                <option
                  v-bind:key="item.id"
                  v-for="(item, index) in humanSubAreaFiltredFront"
                  v-bind:value="item.id"
                  >{{ item.name }}</option
                >
              </select>
            </div>

            <div class="selectSympton col s12">
              <p v-show="mapFront == false">
                Selecione uma região do corpo
              </p>
              <select
                style="display: block"
                multiple
                v-if="podeEscolherSintomasFront"
                v-model="sintomasFront"
              >
                <option
                  :key="item.id"
                  v-for="(item, index) in tuaSubAreaFront"
                  :value="item.id"
                  >{{ item.name }}</option
                >
                <!-- <option value="1">Option 1</option>
                <option value="2">Option 2</option>
                <option value="3">Option 3</option>-->
              </select>
            </div>

            <button
              class="button-add"
              v-if="sintomasFront.length >= 1"
              v-on:click="add(areaCorporalFront, sintomasFront, true)"
            >
              Adicionar
            </button>
          </div>
          <div class="symptomList">
            <p>Sintomas adicionados</p>

            <div v-for="(item, index) in humanResultLabel">
              <div
                v-if="item.front"
                v-for="(sympton, indexSymp) in item.symptom"
              >
                <strong>{{ sympton }}</strong> na região
                <strong>frontal</strong> da(o)
                <strong
                  >{{ item["bodySubRegion"] }} ({{
                    item["bodyRegion"]
                  }})</strong
                >
                <span
                  class="link-remove"
                  v-on:click="removerSympton(index, indexSymp)"
                  >Remover</span
                >
                <br />
              </div>
            </div>
          </div>
          <div class="space"></div>
        </div>

        <div class="section">
          <span>Costas</span>
          <hr />
        </div>
        <div class="body-area-group">
          <div class="space"></div>
          <div class="body">
            <map-body-front
              bodyId="back"
              @map-clicked="onMapClickBack"
            ></map-body-front>
          </div>
          <div class="card-select">
            <div class="selectSympton col s12" v-show="mapBack">
              <p>Membro</p>
              <select
                class="subarea"
                @change="onChangeSubAreaBack($event)"
                v-model="areaCorporalBack"
              >
                <option
                  v-bind:key="item.id"
                  v-for="(item, index) in humanSubAreaFiltredBack"
                  v-bind:value="item.id"
                  >{{ item.name }}</option
                >
              </select>
            </div>

            <div class="selectSympton col s12">
              <label>Sintomas</label>
              <select
                style="display: block"
                multiple
                v-if="podeEscolherSintomasBack"
                v-model="sintomasBack"
              >
                <option
                  :key="item.id"
                  v-for="(item, index) in tuaSubAreaBack"
                  :value="item.id"
                  >{{ item.name }}</option
                >
                <!-- <option value="1">Option 1</option>
                <option value="2">Option 2</option>
                <option value="3">Option 3</option>-->
              </select>
            </div>

            <button
              class="button-add"
              v-if="sintomasBack.length >= 1"
              v-on:click="add(areaCorporalBack, sintomasBack, false)"
            >
              Adicionar
            </button>
          </div>
          <div class="symptomList">
            <p>Sintomas adicionados</p>

            <div v-for="(item, index) in humanResultLabel">
              <div
                v-if="!item.front"
                v-for="(sympton, indexSymp) in item.symptom"
              >
                <strong>{{ sympton }}</strong> na região
                <strong>traseira</strong> da(o)
                <strong
                  >{{ item["bodySubRegion"] }} ({{
                    item["bodyRegion"]
                  }})</strong
                >
                <span
                  class="link-remove"
                  v-on:click="removerSympton(index, indexSymp)"
                  >Remover</span
                >
                <br />
              </div>
            </div>
          </div>
          <div class="space"></div>
        </div>
      </div>
      <app-footer></app-footer>
    </div>
  </div>
</template>

<script>
import AppHeader from "../components/Header.vue";
import AppFooter from "../components/Footer.vue";
import MapBodyFront from "../components/MapBody.vue";
import axios from "axios";
// import { filterSubArea } from "./utils";
export default {
  name: "bodyRegion1",
  components: {
    AppHeader,
    AppFooter,
    MapBodyFront
  },
  data() {
    return {
      url: "http://localhost:8081/api",
      mapFront: "",
      mapBack: "",
      sintomas: [],
      areaCorporalFront: "",
      sintomasFront: [],
      sintomasBack: [],
      areaCorporalBack: [],
      humanSubAreaFiltredFront: [{ name: "Selecione" }],
      humanSubAreaFiltredBack: [{ name: "Selecione" }],
      humanResult: [],
      humanResultLabel: [],
      bodyRegion: [],
      bodyRegionJSON: {
        headFront: false,
        headBack: false,
        bodyFront: false,
        bodyBack: false,
        armLeftFront: false,
        armLeftBack: false,
        armRightFront: false,
        armRightBack: false,
        legLeftFront: false,
        legLeftBack: false,
        legRightFront: false,
        legRightBack: false
      },
      podeEscolherSintomasFront: false,
      podeEscolherSintomasBack: false,
      tuaSubAreaFront: [],
      tuaSubAreaBack: []
    };
  },
  methods: {
    selectMapId(mapId) {
      if (mapId == "Cabeça") {
        return 1;
      } else if (mapId == "Corpo") {
        return 2;
      } else if (mapId == "Braço Esquerdo") {
        return 3;
      } else if (mapId == "Braço Direito") {
        return 4;
      } else if (mapId == "Perna Esquerda") {
        return 5;
      } else if (mapId == "Perna Direita") {
        return 6;
      }
    },
    removerSympton(index, indexSympton) {
      if (this.humanResultLabel[index].symptom.length > 1) {
        this.humanResultLabel[index].symptom.splice(indexSympton, 1);
        this.humanResult[index].symptom.splice(indexSympton, 1);
      } else {
        this.humanResultLabel.splice(index, 1);
        this.humanResult.splice(index, 1);
      }
    },
    filterSubArea(array, stringCompare) {
      // console.log(array);
      var copyAux = [];
      for (var i = 0; i < array.length; i++) {
        if (array[i].name == stringCompare) {
          copyAux = array[i].subArea;
        }
      }
      return copyAux;
    },
    async onChangeSubAreaFront(event) {
      const vue = this;
      this.podeEscolherSintomasFront = true;
      this.tuaSubAreaFront = [];

      await axios
        .get(this.url + "/subareasintoma/" + event.target.value)
        .then(function(res) {
          const symptons = res.data;

          symptons.forEach(function(elem) {
            vue.tuaSubAreaFront.push({
              name: elem.nome,
              id: elem.id_sintoma
            });
          });
        })
        .catch(error => {
          //this.error = error.response.data;
          console.log(error);
        });
    },
    async onChangeSubAreaBack(event) {
      const vue = this;
      this.podeEscolherSintomasBack = true;
      this.tuaSubAreaBack = [];

      await axios
        .get(this.url + "/subareasintoma/" + event.target.value)
        .then(function(res) {
          const symptons = res.data;

          symptons.forEach(function(elem) {
            vue.tuaSubAreaBack.push({
              name: elem.nome,
              id: elem.id_sintoma
            });
          });
        })
        .catch(error => {
          //this.error = error.response.data;
          console.log(error);
        });
    },
    onMapClickFront: async function(attr) {
      const vue = this;
      this.mapFront = attr.mapId;
      this.mapBack = null;
      this.humanSubAreaFiltredFront = [];

      await axios
        .get(this.url + "/subarea/" + this.selectMapId(this.mapFront))
        .then(function(res) {
          const subAreas = res.data;

          subAreas.forEach(function(elem) {
            if (elem.frente) {
              vue.humanSubAreaFiltredFront.push({
                name: elem.nome,
                id: elem.id
              });
            }
          });
        })
        .catch(error => {
          //this.error = error.response.data;
          console.log(error);
        });
    },
    onMapClickBack: async function(attr) {
      const vue = this;
      this.mapBack = attr.mapId;
      this.mapFront = null;
      this.humanSubAreaFiltredBack = [];

      await axios
        .get(this.url + "/subarea/" + this.selectMapId(this.mapBack))
        .then(function(res) {
          const subAreas = res.data;

          subAreas.forEach(function(elem) {
            if (elem.costas) {
              vue.humanSubAreaFiltredBack.push({
                name: elem.nome,
                id: elem.id
              });
            }
          });
        })
        .catch(error => {
          //this.error = error.response.data;
          console.log(error);
        });
    },
    checkIfInclude: function(array, obj) {
      
      let countEqual = 0;
      for (let x in array) {
        countEqual = 0

        for (let key in array[x]) {
          if (key != "symptom" && array[x][key] === obj[key]) {
            countEqual++;
          } 

          if (key == "symptom" 
          && Array.prototype.every.call(obj[key], function(value) {
            return array[x][key].includes(value);
          })) {
           countEqual++;
          }
        }
        if (countEqual == 4) {
          return true;
        }
      }

      return false;
    },
    add: async function(areaCorporalFront, sintomasFront, lado) {
      let subAreaLabel = "";
      let sintomaLabel = [];

      await axios
        .get(this.url + "/subarea/first/" + areaCorporalFront)
        .then(function(res) {
          subAreaLabel = res.data.nome;
        })
        .catch(error => {
          //this.error = error.response.data;
          console.log(error);
        });

      for (let x in sintomasFront) {
        await axios
          .get(this.url + "/sintoma/first/" + sintomasFront[x])
          .then(function(res) {
            sintomaLabel.push(res.data.nome);
          })
          .catch(error => {
            //this.error = error.response.data;
            console.log(error);
          });

        if (!this.checkIfInclude(this.humanResult, {
          bodyRegion: this.selectMapId(this.mapFront || this.mapBack),
          bodySubRegion: areaCorporalFront,
          symptom: [sintomasFront[x]],
          front: lado
        })) {

          this.humanResultLabel.push({
            bodyRegion: this.mapFront || this.mapBack,
            bodySubRegion: subAreaLabel,
            symptom: [sintomaLabel[x]],
            front: lado
          });

          this.humanResult.push({
            bodyRegion: this.selectMapId(this.mapFront || this.mapBack),
            bodySubRegion: areaCorporalFront,
            symptom: [sintomasFront[x]],
            front: lado
          });

        }
      }
    },
    createUserSubAreaSintoma: function(userSubAreaSintomaId, diagnosticoId) {
      axios
        .post(this.url + "/usersubareasintoma/", {
          user_id: this.$session.get("user").id, 
          sub_area_sintoma_id: userSubAreaSintomaId,
          id_diagnostico: diagnosticoId
        })
        .then(function(res) {})
        .catch(error => {
          //this.error = error.response.data;
          console.log(error);
        });
    },
    save: async function() {
      let allUserSubAreaSintomaId = [];
      let diagnosticoId = -1;

      await axios
        .post(this.url + "/diagnostico/", {
          id_user: this.$session.get("user").id
        })
        .then(function(res) {
          diagnosticoId = res.data;
        })
        .catch(error => {
          //this.error = error.response.data;
          console.log(error);
        });

      for (let i in this.humanResult) {
        for (let j in this.humanResult[i].symptom) {
          await axios
            .get(
              this.url +
                "/subareasintoma/" +
                this.humanResult[i].bodySubRegion +
                "/" +
                this.humanResult[i].symptom[j]
            )
            .then(function(res) {
              if (res.data > 0) {
                allUserSubAreaSintomaId.push(res.data);
              }
            })
            .catch(error => {
              //this.error = error.response.data;
              console.log(error);
            });
        }
      }

      for (let id in allUserSubAreaSintomaId) {
        await this.createUserSubAreaSintoma(
          allUserSubAreaSintomaId[id],
          diagnosticoId
        );
      }

      //M.toast({html: 'Registrado com sucesso!', classes: 'rounded'});
      window.location.href = "/#/diagnostico/" + diagnosticoId;
    }
  },
  mounted() {
    if (!this.$session.exists()) {
      window.location.href = "/#/login";
    }
  }
};
</script>
<style scoped>
#content {
  display: flex;
  flex-direction: column;
}
.top-info {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin: 16px;
  font-size: 16px;
}
.body-area {
  display: flex;
  flex-direction: column;
  flex-wrap: wrap;
  flex: 1;
}
.body-area-group {
  margin-bottom: 25px;
  flex: 1;
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
}
.body {
  flex: 2;
  min-width: 300px;
  align-self: flex-end;
  min-height: 800;
  text-align: center;
  font-weight: bold;
  color: gray;
}
.card-select {
  padding: 6px;
  display: flex;
  flex-direction: column;
  width: 400px;
  background: #f7f7f7;
  margin: 16px 0;
  justify-content: space-between;
  border-radius: 6px 0px 0px 6px;
  border-right: 1px solid #d8d8d8;
  flex: 1;
}

.selectSympton {
  width: 250px;
  margin-left: 15px;
}

.symptomList {
  padding: 6px;
  display: flex;
  flex-direction: column;
  width: 400px;
  flex: 3;
  background: #f7f7f7;
  margin: 16px 0;
  padding-left: 20px;
  border-radius: 0px 6px 6px 0px;
}

.space {
  flex: 0.5;
}
.btn {
  background: #4676ff;
}
.title-back {
  color: #2f52b9;
  font-size: 26px;
  font-weight: bold;
  margin-right: 23.5%;
}
.bottom-info {
  display: flex;
  align-items: center;
  justify-content: space-between;
  margin-top: -50px;
}
.title {
  margin-top: 20px;
  font-size: 26px;
  font-weight: bold;
  color: #2f52b9;
}
.subtitle {
  margin-top: 25px;
  font-weight: bold;
}

select {
  width: 100%;
  border: 6px solid transparent;
  border-color: #fff transparent transparent transparent;
  margin-bottom: 16px;
}
hr {
  border: 0;
  width: 100%;
  background-color: darkgray;
  height: 1px;
  margin-top: 0px;
}
.section {
  margin: 16px;
  font-weight: bold;
}

.link-remove {
  color: #4676ff;
}

.link-remove:hover {
  color: #355dd1;
  cursor: pointer;
}

#save {
  border-radius: 15px;
  border-color: transparent;
  background-color: #4676ff;
  color: #fff;
  margin-top: 16px;
  font-size: 20px;
  font-weight: bold;
  width: 250px;
  display: flex;
  align-items: center;
  justify-content: center;
}


.button-add {
  margin: 0 auto;
  width: 200px;
  border-radius: 15px;
  border-color: transparent;
  background-color: #4676ff;
  color: #fff;
}

#save:hover, .button-add:hover {
  background-color: #355dd1;
}
</style>
