<template>
  <div class="header">
    <img src="../assets/logo.png" height="50" width="50"> 
    <div class="d-flex flex-row-reverse bd-highlight">
      <div class="p-2 bd-highlight column1">
        <a v-if="!auth" href="/#/login"
          ><button type="button" class="btn btn-outline-success">
            Entrar
          </button></a
        >
      </div>
      <div class="p-2 bd-highlight column2"></div>
      <div class="p-2 bd-highlight column3">
        <div v-if="auth" class="user-box-login">
          Olá, 
          <span class="user-name">
            {{ this.$session.get("user").nome }}
          </span>

          <button v-on:click="logout()" type="button" class="btn btn-outline-success logout">
            Sair
          </button>
        </div>
 
        <!-- Dropdown Structure -->
        <div class="dropdown">
          <button
            v-if="!auth"
            class="btn btn-secondary dropdown-toggle"
            type="button"
            id="dropdownMenuButton"
            data-toggle="dropdown"
            aria-haspopup="true"
            aria-expanded="false"
          >
            Registrar
          </button>
          <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
            <a class="dropdown-item" href="/#/userRegister"
              >Registrar-se como um paciente</a
            >
            <a class="dropdown-item" href="/#/clinica"
              >Registrar-se como uma clínica</a
            >
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Vue from 'vue'
import VueSession from 'vue-session'

Vue.use(VueSession)

export default {
  data() {
    return {
      auth: false,
      logout: function() {
        this.auth = false;
        this.$session.destroy();
        window.location.href = "/#/login";
      }
    }},
    mounted() {
      if (this.$session.exists()) {
        this.auth = true;
      }
    }
};

</script>

<style scoped>
/* #355dd1 #4676ff  #2f52b9*/

.column1 {
  margin-right: 50px;
}

.column1 > a > .btn-outline-success, .logout {
  width: 100px;
  background-color: #4676ff;
  border-color: #f3f3f3;
  color: #f3f3f3;
  font-weight: bold;
}

.column1 > a > .btn-outline-success:hover, .logout:hover {
  background-color: #f3f3f3;
  color: #9c9c9c;
}

.column3 > .dropdown > .btn-secondary {
  background-color: #f3f3f3;
  color: #4676ff;
  border-color: #4676ff;
  font-weight: bold;
}

.column3 > .dropdown > .dropdown-menu > .dropdown-item {
  font-weight: bold;
  color: #4676ff;
}

.column3 > .dropdown > .dropdown-menu > .dropdown-item:hover {
  background-color: #f3f3f3;
}

.header {
  width: 100%;
  min-height: 55px;
  background-color: #4676ff;
  margin-right: 50px;
  box-shadow: 0px 0px 10px 0px #888888;
}

.user-name {
  font-size: 20px;
  font-weight: bold;
}

.user-box-login {
  color: #fff;

}

.logout {
  margin-left: 30px;
}
</style>
