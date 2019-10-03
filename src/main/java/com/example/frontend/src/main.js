import Vue from 'vue'
import App from './App.vue'
import Routes from './routes.js'

import VueRouter from 'vue-router'
import VueResource from 'vue-resource'

Vue.use(VueResource)
Vue.use(VueRouter)

const router = new VueRouter(Routes)

new Vue({
  el: '#app',
  router: router,
  render: h => h(App)
})
