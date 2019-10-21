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
        <span>Frente</span>
        <map-body-front class="body-front" bodyId="front" @map-clicked="onMapClickFront"></map-body-front>
      </div>
      <div class="body-area-group">
        <span>Costas</span>
        <map-body-front class="body-front" bodyId="back" @map-clicked="onMapClickFront"></map-body-front>
      </div>
    </div>
    <a class="waves-effect waves-light btn">Próximo</a>
    <div class="bottom-info"></div>
    <app-footer></app-footer>
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
    return {};
  },
  methods: {
    onMapClickFront: function(attr) {
      //alert(`You clicked on state with id: ${attr.mapId} (front) `);
    },
    onMapClickBack: function(attr) {
      //alert(`You clicked on state with id: ${attr.mapId} (back) `);
    }
  }
};
</script> 
<style scoped>
.body-area {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
}
.body-area-group {
  flex: 1;
  justify-content: center;
  text-align: center;
}
.title-front {
  color: #2f52b9;
  font-size: 26px;
  font-weight: bold;
  padding-left: 22%;
}
.legend {
  display: flex;
  text-align: center;
}
.legend > span {
  flex: 1;
  justify-content: space-around;
  align-self: center;
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