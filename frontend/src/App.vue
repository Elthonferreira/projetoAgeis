<template>
  <div id="app">
    <router-view></router-view>
  </div>
</template>

<script>
  export default {
    name: 'app',
    data () {
      return {

      }
    }
  }
</script>

<style>
  html, body {
    margin: 0;
    padding: 0;
    font-family: Helvetica, sans-serif;
    height: 800px;
    min-height: 100%;
  }

  #app {
    position: relative;
    min-width: 100%;
    min-height: 100%;
  }
</style>
