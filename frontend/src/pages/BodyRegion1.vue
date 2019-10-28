
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
            <map-body-front bodyId="front" @map-clicked="onMapClickFront"></map-body-front>
          </div>
          <div class="card-select">
            <div class="input-field col s12" v-show="mapFront">
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
                >{{ item.name }}</option>
              </select>
            </div>

            <div class="input-field col s12">
              <label>Sintomas</label>
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
                >{{ item }}</option>
                <!-- <option value="1">Option 1</option>
                <option value="2">Option 2</option>
                <option value="3">Option 3</option>-->
              </select>
            </div>

            <button
              v-if="sintomasFront.length>=1"
              v-on:click="add(areaCorporalFront,sintomasFront,'Frente')"
            >Adicionar</button>
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
            <map-body-front bodyId="back" @map-clicked="onMapClickBack"></map-body-front>
          </div>
          <div class="card-select">
            <div class="input-field col s12" v-show="mapBack">
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
                >{{ item.name }}</option>
              </select>
            </div>

            <div class="input-field col s12">
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
                >{{ item }}</option>
                <!-- <option value="1">Option 1</option>
                <option value="2">Option 2</option>
                <option value="3">Option 3</option>-->
              </select>
            </div>

            <button
              v-if="sintomasBack.length>=1"
              v-on:click="add(areaCorporalBack,sintomasBack,'Costas')"
            >Adicionar</button>
          </div>

          <div class="space"></div>
        </div>
      </div>
      <button id="save" v-if="humanResult.length>=1" v-on:click="save()">Adicionar</button>
      <app-footer></app-footer>
    </div>
  </div>
</template>

<script>
import AppHeader from "../components/Header.vue";
import AppFooter from "../components/Footer.vue";
import MapBodyFront from "../components/MapBody.vue";
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
      human: [
        {
          name: "Cabeça",
          subArea: [
            {
              name: "cabeça",
              sintomas: ["Dor", "Enxaqueca", "Latejando"]
            },
            {
              name: "olhos",
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
      this.humanSubAreaFiltredBack = this.filterSubArea(
        this.human,
        this.mapBack
      );
      //alert(`You clicked on state with id: ${attr.mapId} (back) `);
    },
    add: function(areaCorporalFront, sintomasFront, lado) {
      //    console.log(areaCorporalFront);
      //   console.log(sintomasFront);
      this.humanResult.push({
        lado: lado,
        subArea: areaCorporalFront,
        sintomas: sintomasFront
      });
      console.log(this.humanResult);
    },
    save: function() {
      console.log("save");
      console.log(this.humanResult);
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
  min-width: 600px;
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
  min-width: 200px;
  flex: 2;
  background: #f7f7f7;
  border-radius: 6px;
  margin: 16px;
  justify-content: space-between;
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
</style>
 
