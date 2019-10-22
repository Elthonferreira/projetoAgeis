<template>
  <div id="bodyRegion1">
    <app-header></app-header>
    <div class="top-info">
      <span class="title">Selecionar Regiões</span>
      <br />
      <span class="subtitle">Selecione as regiões dos sintomas</span>
    </div>
    <div class="body-area">
      <div class="body-area-group">
        <div class="space"></div>
        <map-body-front class="body" bodyId="front" @map-clicked="onMapClickFront"></map-body-front>

        <div class="card-select">
          <div class="input-field col s12">
            <select v-model="areaCorporal" multiple>
              <option value disabled>Selecione</option>
              <option value="1">Option 1</option>
              <option value="2">Option 2</option>
              <option value="3">Option 3</option>
            </select>
            <label>Membro</label>
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
        <map-body-front class="body" bodyId="back" @map-clicked="onMapClickFront"></map-body-front>

        <div class="card-select">
          <div class="input-field col s12">
            <select v-model="areaCorporal" multiple>
              <option value disabled>Selecione</option>
              <option value="1">Option 1</option>
              <option value="2">Option 2</option>
              <option value="3">Option 3</option>
            </select>
            <label>Membro</label>
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
      <!-- <div class="body-area-group">
        <map-body-front class="body-front" bodyId="back" @map-clicked="onMapClickFront"></map-body-front>
      </div>
    </div>
    <a class="waves-effect waves-light btn">Próximo</a>
    <div class="bottom-info"></div>
      <app-footer></app-footer>-->
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
      mapFront: null,
      mapBack: null,
      sintomas: "",
      areaCorporal: ""
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
}
.card-select {
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

.top-info {
  display: flex;
  align-items: center;
  flex-direction: column;
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