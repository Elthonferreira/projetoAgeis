<template>
    <div id="bodyRegion1">
        <app-header></app-header>
        <div class="top-info">
          <span class="title">Selecionar Regiões</span>
          <br>
          <span class="subtitle">Selecione as regiões dos sintomas</span>
        </div>
        <map-body-front class="body-front" @map-clicked="onMapClickFront"></map-body-front>
        <map-body-front class="body-back" @map-clicked="onMapClickBack"></map-body-front> 
        <div class="bottom-info">
            <span class="title-front">Frente</span>
            <a class="waves-effect waves-light btn">Próximo</a>
            <span class="title-back">Costas</span>
        </div>
        <app-footer></app-footer>
    </div>
</template>

<script>
    import AppHeader from "../components/Header.vue"
    import AppFooter from "../components/Footer.vue"
    import MapBodyFront from "../components/MapBody.vue"

export default {
    name: "bodyRegion1",
    components: {
      AppHeader, AppFooter, MapBodyFront
    },
    data() {
        return {
            
        }
    }, 
    methods: {
    onMapClickFront : function(attr){
      //alert(`You clicked on state with id: ${attr.mapId} (front) `);
    }, 
    onMapClickBack: function(attr){
      //alert(`You clicked on state with id: ${attr.mapId} (back) `);
    }
  }
}
</script>

<style scoped>
  .title-front {
    color: #2f52b9;
    font-size: 26px;
    font-weight: bold;
    padding-left: 22%;
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