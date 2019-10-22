<template>
  <div id="content">
    <div id="content">
      <app-header></app-header>
      <div class="top-info">
        <span class="subtitle">Identificação dos sintomas</span>
      </div>
      <div class="body-area">
        <div class="body-area-group">
          <div class="space"></div>
          <div class="body">
            <span>Frente</span>
            <map-body-front bodyId="front" @map-clicked="onMapClickFront"></map-body-front>
          </div>
          <div class="card-select">
            <div class="input-field col s12">
              <select v-model="areaCorporal" multiple>
                <option value disabled>Selecione</option>
                <option
                  v-bind:key="index"
                  v-for="(item, index) in human"
                  value="1"
                >{{ item.name | filterA('arg1', arg2) }}</option>
              </select>
              <label>{{ mapFront}}</label>
            </div>
            <p>{{ areaCorporal }}</p>

            <div class="input-field col s12">
              <select v-model="sintomas" multiple>
                <option value disabled>Selecione</option>
                <option value="1">Option 1</option>
                <option value="2">Option 2</option>
                <option value="3">Option 3</option>
              </select>
              <label>Sintomas</label>
            </div>
            <p>{{ sintomas}}</p>
          </div>
          <div class="space"></div>
        </div>

        <div class="body-area-group">
          <div class="space"></div>
          <div class="body">
            <span>Costas</span>
            <map-body-front bodyId="back" @map-clicked="onMapClickBack"></map-body-front>
          </div>
          <div class="card-select">
            <div class="input-field col s12">
              <select v-model="areaCorporal" multiple>
                <option value disabled>Selecione</option>
                <option value="1">Option 1</option>
                <option value="2">Option 2</option>
                <option value="3">Option 3</option>
              </select>
              <label>{{ mapBack}}</label>
            </div>
            <p>{{ areaCorporal }}</p>

            <div class="input-field col s12">
              <select v-model="sintomas" multiple>
                <option value disabled>Selecione</option>
                <option value="1">Option 1</option>
                <option value="2">Option 2</option>
                <option value="3">Option 3</option>
              </select>
              <label>Sintomas</label>
            </div>
            <p>{{ sintomas}}</p>
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

export default {
  name: "bodyRegion1",
  components: {
    AppHeader,
    AppFooter,
    MapBodyFront
  },
  data() {
    return {
      mapFront: "Membro",
      mapBack: "Membro",
      sintomas: "",
      areaCorporal: "",
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
        {},
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
        },
        {},
        {},
        {}
      ]
    };
  },
  methods: {
    onMapClickFront: function(attr) {
      this.mapFront = attr.mapId;
      //alert(`You clicked on state with id: ${attr.mapId} (front) `);
    },
    onMapClickBack: function(attr) {
      this.mapBack = attr.mapId;
      //alert(`You clicked on state with id: ${attr.mapId} (back) `);
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
</style>