<script src="https://gist.github.com/kevinbreaker/71a870344e93c8ea376bc95959af3a9a.js"></script>

<template>
  <div id="content">
    <div id="content">
      <app-header></app-header>
      <div class="top-info">
        <span class="subtitle">Identificação dos sintomas</span>
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
                  v-bind:key="index"
                  v-for="(item, index) in humanSubAreaFiltredFront"
                  v-bind:value="item.name"
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
                  :key="index"
                  v-for="(item, index) in tuaSubAreaFront.sintomas"
                  :value="item"
                  >{{ item }}</option
                >
                <!-- <option value="1">Option 1</option>
                <option value="2">Option 2</option>
                <option value="3">Option 3</option>-->
              </select>
            </div>

            <button
              class="selectSympton"
              v-if="sintomasFront.length >= 1"
              v-on:click="add(areaCorporalFront, sintomasFront, true)"
            >
              Adicionar
            </button>
          </div>
          <div class="symptomList">
            <p>Sintomas adicionados</p>

            <div v-for="(item, index) in humanResult">
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
                  v-bind:key="index"
                  v-for="(item, index) in humanSubAreaFiltredBack"
                  v-bind:value="item.name"
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
                  :key="index"
                  v-for="(item, index) in tuaSubAreaBack.sintomas"
                  :value="item"
                  >{{ item }}</option
                >
                <!-- <option value="1">Option 1</option>
                <option value="2">Option 2</option>
                <option value="3">Option 3</option>-->
              </select>
            </div>

            <button
              class="selectSympton"
              v-if="sintomasBack.length >= 1"
              v-on:click="add(areaCorporalBack, sintomasBack, false)"
            >
              Adicionar
            </button>
          </div>
          <div class="symptomList">
            <p>Sintomas adicionados</p>

            <div v-for="(item, index) in humanResult">
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
      <button id="save" v-if="humanResult.length >= 1" v-on:click="save()">
        Adicionar
      </button>
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
      human: [
        {
          name: "Cabeça",
          subArea: [
            {
              name: "Cabeça",
              sintomas: ["Dor", "Enxaqueca", "Latejando"]
            },
            {
              name: "Olhos",
              sintomas: ["Dor", "Visão embaçada"]
            }
          ]
        },
        {
          name: "Braço Direito",
          subArea: [
            {
              name: "AnteBraço",
              sintomas: ["Dor no osso", "Sarna"]
            },
            {
              name: "Mão",
              sintomas: ["Dor no osso", "Sarna"]
            }
          ]
        }
      ],
      podeEscolherSintomasFront: false,
      podeEscolherSintomasBack: false,
      tuaSubAreaFront: [],
      tuaSubAreaBack: []
    };
  },
  methods: {
    removerSympton(index, indexSympton) {
      if (this.humanResult[index].symptom.length > 1) {
        this.humanResult[index].symptom.splice(indexSympton, 1);
      } else {
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
    onChangeSubAreaFront(event) {
      this.podeEscolherSintomasFront = true;
      this.tuaSubAreaFront = this.humanSubAreaFiltredFront.filter(
        el => el.name === event.target.value
      )[0];
      //  console.log("@@ ", event.target.value);
    },
    onChangeSubAreaBack(event) {
      this.podeEscolherSintomasBack = true;
      this.tuaSubAreaBack = this.humanSubAreaFiltredBack.filter(
        el => el.name === event.target.value
      )[0];
      //  console.log("@@ ", event.target.value);
    },
    onMapClickFront: function(attr) {
      this.mapFront = attr.mapId;
      this.mapBack = null;
      this.humanSubAreaFiltredFront = this.filterSubArea(
        this.human,
        this.mapFront
      );
      //   console.log(this.human);
      // console.log(this.humanSubAreaFiltred);
      //alert(`You clicked on state with id: ${attr.mapId} (front) `);
    },
    onMapClickBack: function(attr) {
      this.mapBack = attr.mapId;
      this.mapFront = null;
      this.humanSubAreaFiltredBack = this.filterSubArea(
        this.human,
        this.mapBack
      );
      //alert(`You clicked on state with id: ${attr.mapId} (back) `);
    },
    add: function(areaCorporalFront, sintomasFront, lado) {
      //    console.log(areaCorporalFront);
      //   console.log(sintomasFront);
      if (!this.bodyRegion.includes()) {
        this.bodyRegion.push({
          region: this.mapFront || this.mapBack,
          front: lado
        });
      }

      this.humanResult.push({
        bodyRegion: this.mapFront || this.mapBack,
        bodySubRegion: areaCorporalFront,
        symptom: sintomasFront,
        front: lado
      });
    },
    save: async function() {
      this.bodyRegionJSON.userId = 10; // ### precisa buscar o usuario

      for (let i = 0; i < this.bodyRegion.length; i++) {
        let bodyMember = this.bodyRegion[i];
        if (bodyMember.region == "Cabeça" && bodyMember.front) {
          this.bodyRegionJSON.headFront = true;
        } else if (bodyMember.region == "Cabeça" && !bodyMember.front) {
          this.bodyRegionJSON.headBack = true;
        } else if (bodyMember.region == "Corpo" && bodyMember.front) {
          this.bodyRegionJSON.bodyFront = true;
        } else if (bodyMember.region == "Corpo" && !bodyMember.front) {
          this.bodyRegionJSON.bodyBack = true;
        } else if (bodyMember.region == "Braço Esquerdo" && bodyMember.front) {
          this.bodyRegionJSON.armLeftFront = true;
        } else if (bodyMember.region == "Braço Esquerdo" && !bodyMember.front) {
          this.bodyRegionJSON.armLeftBack = true;
        } else if (bodyMember.region == "Braço Direito" && bodyMember.front) {
          this.bodyRegionJSON.armRightFront = true;
        } else if (bodyMember.region == "Braço Direito" && !bodyMember.front) {
          this.bodyRegionJSON.armRightBack = true;
        } else if (bodyMember.region == "Perna Esquerda" && bodyMember.front) {
          this.bodyRegionJSON.legLeftFront = true;
        } else if (bodyMember.region == "Perna Esquerda" && !bodyMember.front) {
          this.bodyRegionJSON.legLeftBack = true;
        } else if (bodyMember.region == "Perna Direita" && bodyMember.front) {
          this.bodyRegionJSON.legRightFront = true;
        } else if (bodyMember.region == "Perna Direita" && !bodyMember.front) {
          this.bodyRegionJSON.legRightBack = true;
        }
      }

      let bodyRegionId = 0;

      await axios
        .post(this.url + "/bodyRegion", this.bodyRegionJSON)
        .then(function(res) {
          bodyRegionId = res.data;
        })
        .catch(error => {
          //this.error = error.response.data;
          console.log(error);
        });

      for (let i = 0; i < this.humanResult.length; i++) {
        let bodySubRegion = this.humanResult[i];
        bodySubRegion.symptom = this.humanResult[i].symptom;
        bodySubRegion.bodyRegionId = bodyRegionId;
        for (let j = 0; j < bodySubRegion.symptom.length; j++) {
          let bodySubRegionJSON = {
            bodyRegionId: bodySubRegion.bodyRegionId,
            bodyRegion: bodySubRegion.bodyRegion,
            bodySubRegion: bodySubRegion.bodySubRegion,
            symptom: bodySubRegion.symptom[j],
            front: bodySubRegion.front
          };
          console.log(bodySubRegionJSON);
          axios.post(this.url + "/bodySubRegion", bodySubRegionJSON);
        }
      }

      //M.toast({html: 'Registrado com sucesso!', classes: 'rounded'});
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
  margin-top: -20px;
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
#save {
  margin: 16px;
  margin-bottom: 30px;
  width: 100px;
}

.link-remove {
  color: #4676ff;
}

.link-remove:hover {
  color: #355dd1;
  cursor: pointer;
}
</style>
