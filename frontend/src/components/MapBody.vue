<template>
  <div class="contanier">
    <div :id="bodyId" class="svg-container"></div>
  </div>
</template>
<script>
import BodyMap from "../assets/BodyMap";
export default {
  name: "BodyMap",
  props: {
    bodyId: ""
  },
  data: function() {
    return {
      svgId: "BodyMap",
      mapAttr: {
        viewBoxWidth: 1060,
        viewBoxHeight: 800,
        imageWidth: 1060,
        imageHeight: 800
      },
      svgContainer: null
    };
  },
  mounted: function() {
    this.generateVenueMap();
  },
  methods: {
    generateVenueMap: function() {
      const vue = this;
      const mapData = BodyMap.g.path;
      const svgContainer = vue
        .$svg(this.bodyId)
        .size("100%", "100%")
        .viewbox(
          -320,
          -60,
          vue.mapAttr.viewBoxWidth,
          vue.mapAttr.viewBoxHeight
        );
      vue.svgContainer = svgContainer;
      mapData.forEach(pathObj => {
        vue.generatePath(svgContainer, pathObj);
      });
    },
    generatePath: function(svgCont, pathObj) {
      const vue = this;

      const mapData = BodyMap.g.path;

      const attrs = {
        fill: "#4676ff",
        stroke: "white",
        "stroke-width": 2,
        "map-id": pathObj["-id"]
      };
      const element = svgCont.path(pathObj["-d"]).attr(attrs);
      element.node.attributes["fill"].value = "#4676ff";
      element.click(function() {
        if (this.node.attributes["fill"].value === "#4676ff") {
          // pinta a parte selecionada
          this.node.attributes["fill"].value = "#B63232";
        } else {
          this.node.attributes["fill"].value = "#4676ff";
        }

        mapData.forEach(otherPathObj => {
          if (otherPathObj["-id"] != pathObj["-id"]) {
            vue.generatePath(svgCont, otherPathObj);
          }
        });

        const mapId = this.node.attributes["map-id"].value;
        vue.$emit("map-clicked", { mapId });
      });
    }
  }
};
</script>
<style scoped>
.contanier {
  display: flex;
  flex: 1;
  justify-content: center;
}
#BodyMap {
  display: flex;
  align-self: center;
  flex: 1;
}
svg {
  flex: 1 !important;
}
</style>
